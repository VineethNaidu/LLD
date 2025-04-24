package org.example.lld.casestudies.parkinglot.dtos;

import org.example.lld.casestudies.parkinglot.model.VehicleType;

public class IssueTokenRequestDTO {
    private String vehicleNumber;
    private String vehicleOwnerName;
    private VehicleType VehicleType;
    private int ownerContactNumber;
    private int gateNumber;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public VehicleType getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        VehicleType = vehicleType;
    }

    public int getOwnerContactNumber() {
        return ownerContactNumber;
    }

    public void setOwnerContactNumber(int ownerContactNumber) {
        this.ownerContactNumber = ownerContactNumber;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }
}
