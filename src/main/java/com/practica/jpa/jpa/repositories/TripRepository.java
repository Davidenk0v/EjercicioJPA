package com.practica.jpa.jpa.repositories;

import com.practica.jpa.jpa.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query(value = "SELECT * FROM Trip WHERE destination = :idDestination", nativeQuery = true)
    Set<Trip> findByDestination(Long idDestination);

    @Query(value = "SELECT * FROM Trip WHERE boatMaster = :masterId", nativeQuery = true)
    Set<Trip> findByMaster(Long masterId);

    @Query(value = "SELECT * FROM Trip WHERE date BETWEEN :date1 AND :date2", nativeQuery = true)
    Set<Trip> findByDate(Date date1, Date date2);
}
