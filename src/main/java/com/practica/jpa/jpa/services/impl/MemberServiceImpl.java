package com.practica.jpa.jpa.services.impl;

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

@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public void addMember(Member member){ memberDAO.addMember(member);}
    @Override
    public List<Member> findAll() {
        return memberDAO.findAll();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberDAO.findById(id);
    }

    @Override
    public Optional<Member> findByShip(Long idShip) {
        return memberDAO.findByShip(idShip);
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
    public void deleteById(Long id) {
        memberDAO.deleteById(id);
    }
}
