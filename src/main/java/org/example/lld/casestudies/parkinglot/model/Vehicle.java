package org.example.lld.casestudies.parkinglot.model;

public class Vehicle extends BaseModel {
    private String vehicleNumber;
    private String ownerName;
    private int ownerContactNumber;
    private VehicleType vehicleType;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getOwnerContactNumber() {
        return ownerContactNumber;
    }

    public void setOwnerContactNumber(int ownerContactNumber) {
        this.ownerContactNumber = ownerContactNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}

