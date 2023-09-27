package com.github.straider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return service.save(vehicle);
    }

    @PutMapping
    public Vehicle update(@RequestBody Vehicle vehicle) {
        return service.save(vehicle);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping
    public void deleteAll() {
        service.deleteAll();
    }

    @GetMapping
    public List<Vehicle> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Vehicle> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/vehicles/make/{make}")
    public List<Vehicle> findByMake(@PathVariable String make) {
        return service.findByMake(make);
    }

    @GetMapping("/vehicles/model/{model}")
    public List<Vehicle> findByModel(@PathVariable String model) {
        return service.findByModel(model);
    }

    @GetMapping("/vehicles/fuel/{fuel}")
    public List<Vehicle> findByFuelContaining(@PathVariable String fuel) {
        return service.findByFuelContaining(fuel);
    }

    @GetMapping("/vehicles/sold-on-or-after/{date}")
    public List<Vehicle> findBySoldOnAfter(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date)
    {
        return service.findBySoldOnAfter(date);
    }

    @GetMapping("/vehicles/sold")
    public ResponseEntity<List<Vehicle>> findVehiclesSold() {
        try {
            List<Vehicle> vehicles = service.findVehiclesSold();

            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
