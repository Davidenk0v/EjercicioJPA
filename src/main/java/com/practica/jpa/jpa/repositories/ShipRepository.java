package com.practica.jpa.jpa.repositories;

import com.practica.jpa.jpa.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    @Query(value = "SELECT s FROM Ship s WHERE tieNumber = :tieNum", nativeQuery = true)
    Optional<Ship> findByTiemNum(Long tieNum);

    @Query(value = "SELECT * FROM Ship WHERE tiePrice >= :lower AND tiePrice <= :higher", nativeQuery = true)
    Set<Ship> filterByTiePrice(BigDecimal lower, BigDecimal higher);

    @Query(value ="SELECT * FROM Ship WHERE trips = :idTrip", nativeQuery = true)
    Set<Ship> findByTrip(Long idTrip);

    @Query(value = "SELECT * FROM Ship WHERE owner = :idOwner", nativeQuery = true)
    Set<Ship> findByOwner(Long idOwner);
}
