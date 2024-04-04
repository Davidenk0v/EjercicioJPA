package com.practica.jpa.jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ship")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registration;
    private String name;
    private Integer tieNumber;
    private BigDecimal feed;
    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Trip> trips;
    @ManyToOne
    @JoinColumn(name = "id_owner", nullable = false)
    private Member owner;
}
