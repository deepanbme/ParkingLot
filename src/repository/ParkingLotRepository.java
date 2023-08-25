package repository;

import exceptions.ParkingLotNotFoundException;
import model.Gate;
import model.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLots;

    public ParkingLotRepository() {
        this.parkingLots = new HashMap<>();
    }

    public ParkingLot get(int parkingLotId){
        ParkingLot parkingLot =  parkingLots.get(parkingLotId);
        if(parkingLot == null){
            throw new ParkingLotNotFoundException("Parking lot not found for: " + parkingLotId);
        }
        return parkingLot;
    }

    public void put(ParkingLot parkingLot){
        parkingLots.put(parkingLot.getId(), parkingLot);
        System.out.println("Parking lot has been added successfully");
    }

    public ParkingLot getParkingLotFromGate(Gate gate){
        ParkingLot parkingLot = parkingLots.get(gate.getParkingLotId());
        if (parkingLot == null){
            throw new ParkingLotNotFoundException("Parking lot not available");
        }
        return parkingLot;
    }
}
