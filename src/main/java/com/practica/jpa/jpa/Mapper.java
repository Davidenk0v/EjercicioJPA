package com.practica.jpa.jpa;

import com.practica.jpa.jpa.controllers.dto.MemberDTO;
import com.practica.jpa.jpa.models.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

public class Mapper {

    @Bean
    public static MemberDTO memberToDTO(Member member){
        MemberDTO memberDTO = new MemberDTO();
                memberDTO.setId(member.getId());
                memberDTO.setFirstName(member.getFirstName());
                memberDTO.setLastName(member.getLastName());
                memberDTO.setShips(member.getShips());
        return memberDTO;
    }
}
