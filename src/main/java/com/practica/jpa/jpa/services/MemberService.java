package com.practica.jpa.jpa.services;

import com.practica.jpa.jpa.models.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    List<Member> findAll();

    public void addMember(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByShip(Long idShip);
    void save(Member member);
    void deleteById(Long id);
}
