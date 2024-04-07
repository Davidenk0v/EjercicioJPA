package com.practica.jpa.jpa.services;

import com.practica.jpa.jpa.models.Member;
import com.practica.jpa.jpa.models.dto.MemberDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    ResponseEntity<?> findAll();
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> findByShip(Long idShip);
    ResponseEntity<String> update(Long id, MemberDTO memberDTO);
    void save(Member member);
    ResponseEntity<String> deleteById(Long id);
}
