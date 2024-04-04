package com.practica.jpa.jpa.controllers.dto;

import com.practica.jpa.jpa.models.Member;
import com.practica.jpa.jpa.models.Trip;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipDTO {

    private Long id;
    private String registration;
    private String name;
    private Integer tieNumber;
    private BigDecimal feed;

    private List<Trip> trip;

    private Member owner;
}
