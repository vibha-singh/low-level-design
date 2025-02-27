package lld.a.parkingLot;

import lld.a.parkingLot.vehicle.Vehicle;
import lld.a.parkingLot.vehicle.VehicleType;

public class ParkingSpot {
    private VehicleType vehicleType;
    private int spotNumber;
    private Vehicle parkedVehicle;

    public ParkingSpot(VehicleType vehicleType, int spotNumber) {
        this.vehicleType = vehicleType;
        this.spotNumber = spotNumber;
    }

    public synchronized boolean isAvailable(){
        return parkedVehicle == null;
    }
    public int getSpotNumber() {
        return spotNumber;
    }
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if(isAvailable() && vehicleType == vehicle.getVehicleType()){
            parkedVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Spot already occupied or incorrect vehicle type");
        }
    }
}
