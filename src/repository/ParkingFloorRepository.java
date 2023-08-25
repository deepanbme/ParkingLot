package repository;

import exceptions.ParkingFloorNotFoundException;
import exceptions.ParkingLotNotFoundException;
import model.ParkingFloor;
import model.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    private Map<Integer, ParkingFloor> parkingFloors;

    public ParkingFloorRepository() {
        this.parkingFloors = new HashMap<>();
    }

    public ParkingFloor get(int parkingFloorNumber){
        ParkingFloor parkingFloor =  parkingFloors.get(parkingFloorNumber);
        if(parkingFloor == null){
            throw new ParkingFloorNotFoundException("Parking floor not found for: " + parkingFloorNumber);
        }
        return parkingFloor;
    }

    public void put(ParkingFloor parkingFloor){
        parkingFloors.put(parkingFloor.getId(), parkingFloor);
        System.out.println("Parking floor has been added successfully");
    }
}
