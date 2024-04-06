package com.practica.jpa.jpa.repositories;

import com.practica.jpa.jpa.models.Member;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemberRepositoryTest {
    @Autowired
    private MemberRepository repository;
    @Test
    void testAddMember() {
        Member newMember = new Member(Long.valueOf(77), "Luis David", "Alvarez", null);
        Member member = repository.save(newMember);
        assertNotNull(member);
    }

    @Test
    void testFindByShip(){
        String name = "Cly";
        String lastname = "Bittleson";
        Member member = repository.findByShip(Long.valueOf(5)).get();
        assertNotNull(member);
        assertEquals(member.getFirstName(), name);
        assertEquals(member.getLastName(), lastname);
    }
}