package org.example.lld.casestudies.parkinglot.service;

import org.example.lld.casestudies.parkinglot.model.*;
import org.example.lld.casestudies.parkinglot.repository.GateRepository;
import org.example.lld.casestudies.parkinglot.repository.ParkingLotRepository;
import org.example.lld.casestudies.parkinglot.repository.TokenRepository;
import org.example.lld.casestudies.parkinglot.repository.VehicleRepository;
import org.example.lld.casestudies.parkinglot.strategies.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TokenService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TokenRepository tokenRepository;

    public TokenService(
            GateRepository gateRepository,
            VehicleRepository vehicleRepository,
            ParkingLotRepository parkingLotRepository,
            TokenRepository tokenRepository) {

        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.tokenRepository = tokenRepository;
    }

    public Token issueToken(String vehicleNumber,
                            VehicleType vehicleType,
                            String ownerName,
                            int ownerContactNumber,
                            int gateNumber) {

        // 1. Create a token object
        Token token = new Token();
        token.setEntryTime(new Date());

        // Add Gate Details to Token Object - GeneratedAt, GeneratedBy details from Gate Object
        Optional<Gate> gateOptional = gateRepository.findGateByGateNumber(gateNumber);
        if(gateOptional.isEmpty()) {
            throw new RuntimeException("Gate Not Found");
        }
        Gate gate = gateOptional.get();
        token.setGeneratedAt(gate);
        token.setGeneratedBy(gate.getCurrentOperator());

        // Add Vehicle Details to Token Object
        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByVehicleNumber(vehicleNumber);
        Vehicle savedVehicle;
        if(vehicleOptional.isEmpty()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            vehicle.setOwnerContactNumber(ownerContactNumber);
            vehicle.setVehicleType(vehicleType);
            savedVehicle = vehicleRepository.save(vehicle);
        } else {
            savedVehicle = vehicleOptional.get();
        }
        token.setVehicle(savedVehicle);

        // Assign a spot to the vehicle
        SlotAssignmentStrategyType slotAssignmentStrategyType = parkingLotRepository.findParkingLotByGate(gate)
                .getSlotAssignmentStrategy();
        ParkingSlot parkingSlot = SlotAssignmentStrategyFactory.getSlotAssignmentStrategy(slotAssignmentStrategyType)
                .getSlot(gate, vehicleType);

        token.setParkingSlot(parkingSlot);
        parkingSlot.setStatus(ParkingSlotStatus.OCCUPIED);
        Token savedToken = tokenRepository.saveToken(token);
        savedToken.setTokenNumber(Integer.parseInt("TICKET - " + savedToken.getId()));
        // 3. return token
        return savedToken;
    }

}
