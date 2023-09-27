package com.github.straider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByMake(String make);
    List<Vehicle> findByModel(String model);

    List<Vehicle> findByFuelContaining(String fuel);

    @Query("SELECT v FROM Vehicle v WHERE v.soldOn >= :date")
    List<Vehicle> findBySoldOnAfter(@Param("date") LocalDate date);

    @Query("SELECT v FROM Vehicle v WHERE v.soldOn IS NOT NULL")
    List<Vehicle> findVehiclesSold();

}
