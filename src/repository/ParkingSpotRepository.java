package repository;

import exceptions.ParkingGateNotFoundException;
import exceptions.ParkingSpotNotFoundException;
import model.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepository {
    private Map<Integer, ParkingSpot> parkingSpots;

    public ParkingSpotRepository() {
        this.parkingSpots = new HashMap<>();
    }

    public ParkingSpot get(int parkingSpotNumber){
        ParkingSpot parkingSpot =  parkingSpots.get(parkingSpotNumber);
        if(parkingSpot == null){
            throw new ParkingSpotNotFoundException("Parking gate not found for: " + parkingSpotNumber);
        }
        return parkingSpot;
    }

    public void put(ParkingSpot parkingSpot){
        parkingSpots.put(parkingSpot.getId(), parkingSpot);
        System.out.println("Parking spot has been added successfully");
    }
}
