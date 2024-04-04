package com.practica.jpa.jpa.controllers;

import com.practica.jpa.jpa.Mapper;
import com.practica.jpa.jpa.controllers.dto.MemberDTO;
import com.practica.jpa.jpa.models.Member;
import com.practica.jpa.jpa.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/members")
    public ResponseEntity<?> getAllMembers(){
        List<Member> members = service.findAll();
        if(members.isEmpty()){
            return new ResponseEntity<>("Users not found", HttpStatus.NOT_FOUND);
        }

        members.stream()
                .map(member -> Mapper.memberToDTO(member))
                .toList();

        return new ResponseEntity<>(members, HttpStatus.OK);
    }


    @GetMapping("/members/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Member> optionalMember = service.findById(id);

        if(optionalMember.isPresent()){
            Member member = optionalMember.get();

            MemberDTO memberDTO = Mapper.memberToDTO(member);

            return new ResponseEntity<>(memberDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Member does not exist.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/members/ship/{id}")
    public ResponseEntity<?> getByShip(@PathVariable Long shipId){
        Optional<Member> optionalMember = service.findByShip(shipId);

        if(optionalMember.isPresent()){
            Member member = optionalMember.get();

            MemberDTO memberDTO = Mapper.memberToDTO(member);

            return new ResponseEntity<>(memberDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Member does not exist.", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/members")
    public ResponseEntity<String> saveMember(@RequestBody Member member){
        service.save(member);
        return new ResponseEntity<>("Member added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/members/{id}")

    public ResponseEntity<String> deleteMember(@PathVariable Long id){
        Optional<Member> optionalMember = service.findById(id);

        if(optionalMember.isPresent()){
            service.deleteById(id);
            return new ResponseEntity<>("Member removed successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Member does not exist", HttpStatus.BAD_REQUEST);
    }
}
