package model;

public class Vehicle extends BaseModel{
    private String vehicleNumber;
    private String color;
    private String make;
    private VehicleType vehicleType;

    public Vehicle() {
    }

    public Vehicle(String vehicleNumber, String color, String make, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.color = color;
        this.make = make;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
