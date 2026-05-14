package parkingalot.models;

import parkingalot.enums.VehicleType;

public class Vehicle{
   private String plateNumber;
    private VehicleType type;
    private User owner;
    public Vehicle(String plateNumber, VehicleType type, User owner) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.owner = owner;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public VehicleType getType() {
        return type;
    }
    public User getOwner() {
        return owner;
    }
    

}