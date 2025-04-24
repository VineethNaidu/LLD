package org.example.lld.casestudies.parkinglot.strategies;

import org.example.lld.casestudies.parkinglot.model.Gate;
import org.example.lld.casestudies.parkinglot.model.ParkingSlot;
import org.example.lld.casestudies.parkinglot.model.VehicleType;

public interface SlotAssignmentStrategy {
    public ParkingSlot getSlot(Gate gate , VehicleType vehicletype);
}

// parking lot -> slots
// floors -> slots
