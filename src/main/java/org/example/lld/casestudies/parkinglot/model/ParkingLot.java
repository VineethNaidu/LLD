package org.example.lld.casestudies.parkinglot.model;

import java.util.List;

public class ParkingLot extends BaseModel {

    private List<ParkingFloor> parkingFloors;
    private List<VehicleType> allowedVehicleTypes;
    private List<Gate> gates;
    private String address;
    private ParkingLotStatus status;
    private SlotAssignmentStrategyType slotAssignmentStrategy;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public SlotAssignmentStrategyType getSlotAssignmentStrategy() {
        return slotAssignmentStrategy;
    }

    public void setSlotAssignmentStrategy(SlotAssignmentStrategyType slotAssignmentStrategy) {
        this.slotAssignmentStrategy = slotAssignmentStrategy;
    }
}
