package lld.a.parkingLot;

import lld.a.parkingLot.vehicle.Car;
import lld.a.parkingLot.vehicle.Motorcycle;
import lld.a.parkingLot.vehicle.Truck;
import lld.a.parkingLot.vehicle.Vehicle;

public class ParkingLotDemo {
    public static void main(String[] args) {
        Parkinglot parkingLot = Parkinglot.getInstance();
        parkingLot.addLevel(new Level(1, 100));
        parkingLot.addLevel(new Level(2, 70));
        Vehicle car = new Car();
        Vehicle truck = new Truck();
        Vehicle motorcycle = new Motorcycle();

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        // Display availability
        parkingLot.displayAvailability();

        // Unpark vehicle
        parkingLot.unparkVehicle(motorcycle);

        // Display updated availability
        parkingLot.displayAvailability();
    }
}
