package com.practica.jpa.jpa.controllers;

import com.practica.jpa.jpa.Mapper;
import com.practica.jpa.jpa.models.dto.MemberDTO;
import com.practica.jpa.jpa.models.Member;
import com.practica.jpa.jpa.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.practica.jpa.jpa.Mapper.memberToDTO;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    @Autowired
    private MemberService service;

    //GETTERS
    @GetMapping("/")
    public ResponseEntity<?> getAllMembers(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/ship/{shipId}")
    public ResponseEntity<?> getByShip(@PathVariable Long shipId){
        return service.findByShip(shipId);
    }

    //POTS
    @PostMapping("/")
    public ResponseEntity<String> addMember(@RequestBody Member member){
        service.save(member);
        return new ResponseEntity<>("Member added successfully", HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMember(@PathVariable Long id, @RequestBody MemberDTO memberDTO){
        return service.update(id, memberDTO);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
