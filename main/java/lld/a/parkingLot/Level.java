package lld.a.parkingLot;

import lld.a.parkingLot.vehicle.Vehicle;
import lld.a.parkingLot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int floor;
    private List<ParkingSpot> parkingSpotList;

    public Level(int floor, int numOfSpots) {
        this.floor = floor;
        parkingSpotList = new ArrayList<>(numOfSpots);
        double spotsForMotor = 0.50;
        double spotsForCar = 0.40;

        int noOfMotor = (int) (spotsForMotor * numOfSpots);
        int noOfCar = (int) (spotsForCar * numOfSpots);
        for(int i = 1; i<= noOfMotor; i++) {
            ParkingSpot parkingSpot = new ParkingSpot(VehicleType.MOTORCYCLE, i);
            parkingSpotList.add(parkingSpot);
        }
        for(int i = noOfMotor+1; i<= noOfMotor+noOfCar; i++) {
            ParkingSpot parkingSpot = new ParkingSpot(VehicleType.CAR, i);
            parkingSpotList.add(parkingSpot);
        }
        for(int i = noOfCar+noOfMotor+1; i<= numOfSpots; i++) {
            ParkingSpot parkingSpot = new ParkingSpot(VehicleType.TRUCK, i);
            parkingSpotList.add(parkingSpot);
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpotList) {
            if(spot.isAvailable() && spot.getVehicleType().equals(vehicle.getVehicleType())){
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpotList) {
            if(!spot.isAvailable() && spot.getParkedVehicle() == vehicle) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public synchronized void displayAvailability () {
        for (ParkingSpot spot :parkingSpotList) {
            if(spot.isAvailable())
                System.out.println("Parking spot available at level: "+floor+" parking spot: "+spot.getSpotNumber()+ " for vehicle type: "+spot.getVehicleType());
        }
    }
}
