package org.example.lld.casestudies.parkinglot.strategies;

import org.example.lld.casestudies.parkinglot.model.Gate;
import org.example.lld.casestudies.parkinglot.model.ParkingSlot;
import org.example.lld.casestudies.parkinglot.model.VehicleType;

public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy{
    @Override
    public ParkingSlot getSlot(Gate gate, VehicleType vehicleType) {
        // using gate -> Parking Lot
        // using Parking lot -> floors
        // on the floors -> slots
        // choose an empty slot of corresponding vehicle type
        return null;
    }
}