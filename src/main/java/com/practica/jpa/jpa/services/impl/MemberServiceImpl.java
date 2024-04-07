package com.practica.jpa.jpa.services.impl;

import com.practica.jpa.jpa.Mapper;
import com.practica.jpa.jpa.models.Member;
import com.practica.jpa.jpa.models.dto.MemberDTO;
import com.practica.jpa.jpa.persistence.MemberDAO;
import com.practica.jpa.jpa.repositories.MemberRepository;
import com.practica.jpa.jpa.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.practica.jpa.jpa.Mapper.memberToDTO;

@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public ResponseEntity<?> findAll() {
        List<Member> members = memberDAO.findAll();
        if(members.isEmpty()){
            return new ResponseEntity<>("Members not found", HttpStatus.NOT_FOUND);
        }
        members.stream()
                .map(Mapper::memberToDTO)
                .toList();

        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        Optional<Member> optionalMember = memberDAO.findById(id);

        if(optionalMember.isPresent()){
            Member member = optionalMember.get();

            MemberDTO memberDTO = memberToDTO(member);

            return new ResponseEntity<>(memberDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Member does not exist.", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> findByShip(Long idShip) {
        Optional<Member> optionalMember = memberDAO.findByShip(idShip);

        if(optionalMember.isPresent()){
            Member member = optionalMember.get();

            MemberDTO memberDTO = memberToDTO(member);

            return new ResponseEntity<>(memberDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Member does not exist.", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> update(Long id, MemberDTO memberDTO) {
        Optional<Member> memberOptional = memberDAO.findById(id);
        if(memberOptional.isPresent()){
            Member member = memberOptional.get();
            member.setFirstName(memberDTO.getFirstName());
            member.setLastName(memberDTO.getLastName());
            member.setShips(memberDTO.getShips());

            memberDAO.save(member);
            return new ResponseEntity<>("Member successfully updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Member does not exists", HttpStatus.BAD_REQUEST);
    }

    @Override
    public void save(Member member) {
        memberDAO.save(member);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        Optional<Member> optionalMember = memberDAO.findById(id);

        if(optionalMember.isPresent()){
            memberDAO.deleteById(id);
            return new ResponseEntity<>("Member removed successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Member does not exist", HttpStatus.BAD_REQUEST);
    }
}
