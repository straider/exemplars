package com.github.straider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    public Optional<Vehicle> findById(Long id) {
        return repository.findById(id);
    }

    public List<Vehicle> findByMake(String make) {
        return repository.findByMake(make);
    }

    public List<Vehicle> findByModel(String model) {
        return repository.findByModel(model);
    }

    public List<Vehicle> findByFuelContaining(String fuel) {
        return repository.findByFuelContaining(fuel);
    }

    public List<Vehicle> findBySoldOnAfter(LocalDate date) {
        return repository.findBySoldOnAfter(date);
    }

    public List<Vehicle> findVehiclesSold() {
        return repository.findVehiclesSold();
    }

}
