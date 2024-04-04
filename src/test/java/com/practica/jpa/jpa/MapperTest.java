package com.practica.jpa.jpa;

import com.practica.jpa.jpa.models.Member;
import com.practica.jpa.jpa.models.Ship;
import org.junit.Assert;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MapperTest {
    Member member = new Member(null,"John", "Doe", null);
    @org.junit.jupiter.api.Test
    void tryMemberToDTO() {
        System.out.println(Mapper.memberToDTO(member).getFirstName());
    }
}