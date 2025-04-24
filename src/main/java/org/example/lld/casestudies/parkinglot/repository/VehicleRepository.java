package org.example.lld.casestudies.parkinglot.repository;

import org.example.lld.casestudies.parkinglot.model.Vehicle;

import java.util.Optional;

public class VehicleRepository {
    public Optional<Vehicle> findVehicleByVehicleNumber(String vehicleNumber) {
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicle;
    }
}
