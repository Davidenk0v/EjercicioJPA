package com.practica.jpa.jpa.repositories;

import com.practica.jpa.jpa.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    @Query(value = "SELECT s FROM Ship s WHERE s.tieNumber = :tieNum")
    Optional<Ship> findByTiemNum(Integer tieNum);

    @Query(value = "SELECT * FROM Ship s WHERE s.feed BETWEEN :lower AND :higher", nativeQuery = true)
    Set<Ship> filterByFeedPrice(@Param("lower") BigDecimal lower, @Param("higher") BigDecimal higher);

    @Query("SELECT s FROM Ship s JOIN s.trips t WHERE t.id = :idTrip")
    Set<Ship> findByTrip(@Param("idTrip") Long idTrip);

    @Query("SELECT s FROM Ship s WHERE s.owner.id = :idOwner")
    Set<Ship> findByOwner(@Param("idOwner") Long idOwner);
}
