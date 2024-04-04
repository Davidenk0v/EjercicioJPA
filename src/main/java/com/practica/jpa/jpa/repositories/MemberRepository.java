package com.practica.jpa.jpa.repositories;

import com.practica.jpa.jpa.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "SELECT m FROM member WHERE ships = :idShip", nativeQuery = true)
    Optional<Member> findByShip(Long idShip);
}
