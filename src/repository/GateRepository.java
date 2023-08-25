package repository;

import exceptions.ParkingGateNotFoundException;
import exceptions.ParkingLotNotFoundException;
import model.Gate;
import model.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    private Map<Integer, Gate> gateMap;

    public GateRepository() {
        this.gateMap = new HashMap<>();
    }

    public Gate get(int gateNumber){
        Gate gate =  gateMap.get(gateNumber);
        if(gate == null){
            throw new ParkingGateNotFoundException("Parking gate not found for: " + gateNumber);
        }
        return gate;
    }

    public void put(Gate gate){
        gateMap.put(gate.getId(), gate);
        System.out.println("Parking lot has been added successfully");
    }
}
