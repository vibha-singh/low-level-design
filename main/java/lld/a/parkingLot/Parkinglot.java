package lld.a.parkingLot;

import lld.a.parkingLot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Parkinglot {
    private static Parkinglot parkinglot;
    private List<Level> levels;

    private Parkinglot(){
        levels = new ArrayList<>();
    }
    public static synchronized Parkinglot getInstance(){
        if (parkinglot == null) {
            parkinglot = new Parkinglot();
        }
        return parkinglot;
    }

    public synchronized void addLevel (Level level) {
        levels.add(level);
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        for (Level level: levels) {
            if(level.parkVehicle(vehicle)){
                System.out.println(" Vehicle parked successfully");
                return true;
            }
        }
        System.out.println("Could not park vehicle");
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
             if(level.unParkVehicle(vehicle)){
                 return true;
             }
        }
        return false;
    }

    public synchronized void displayAvailability() {
        for (Level level: levels) {
            level.displayAvailability();;
        }
    }

}
