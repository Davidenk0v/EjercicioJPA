package com.practica.jpa.jpa.persistence;

import com.practica.jpa.jpa.models.Member;

import java.util.List;
import java.util.Optional;

public interface MemberDAO {

    List<Member> findAll();
    Optional<Member> findById(Long id);
    Optional<Member> findByShip(Long idShip);
    void save(Member member);
    void deleteById(Long id);

    void addMember(Member member);
}
