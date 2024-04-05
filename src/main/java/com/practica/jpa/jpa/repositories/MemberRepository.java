package com.practica.jpa.jpa.repositories;

import com.practica.jpa.jpa.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT m FROM Member m JOIN m.ships s WHERE s.id = :idShip")
    Optional<Member> findByShip(@Param("idShip") Long idShip);
}
