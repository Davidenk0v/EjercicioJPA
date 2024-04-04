package com.practica.jpa.jpa.persistence.impl;

import com.practica.jpa.jpa.models.Member;
import com.practica.jpa.jpa.persistence.MemberDAO;
import com.practica.jpa.jpa.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    private MemberRepository memberRepository;
    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Optional<Member> findByShip(Long idShip) {
        return memberRepository.findByShip(idShip);
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public void addMember(Member member) {
        memberRepository.save(member);
    }
}
