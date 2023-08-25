package service;

import model.*;
import repository.GateRepository;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

public class InitialisationService {
    private GateRepository gateRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingLotRepository parkingLotRepository;

    public InitialisationService() {
        this.gateRepository = new GateRepository();
        this.parkingFloorRepository = new ParkingFloorRepository();
        this.parkingSpotRepository = new ParkingSpotRepository();
        this.parkingLotRepository = new ParkingLotRepository();
    }

    public void initialise(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setStatus(Status.ACTIVE);
        parkingLot.setAddress(" a a a a");
        parkingLot.setCapacity(100);

        Gate entryGate = new Gate();
        entryGate.setId(1);
        entryGate.setGateNumber(1);
        entryGate.setOperator("Deepan");
        entryGate.setGateType(GateType.ENTRY);
        entryGate.setFloorNumber(1);
        entryGate.setStatus(Status.ACTIVE);

        Gate exitGate = new Gate();
        exitGate.setId(2);
        exitGate.setGateNumber(1);
        exitGate.setOperator("Barathi");
        exitGate.setGateType(GateType.EXIT);
        exitGate.setFloorNumber(1);
        exitGate.setStatus(Status.ACTIVE);

        parkingLot.setGates(List.of(entryGate, exitGate));
        gateRepository.put(entryGate);
        gateRepository.put(exitGate);

        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int i = 1; i <=10; i++){
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(100 + i);
            parkingFloor.setStatus(Status.ACTIVE);
            parkingFloor.setFloorNumber(i);
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            for(int j = 1; j <=10; j++){
                ParkingSpot parkingSpot = new ParkingSpot();
                if(j%2 == 0) parkingSpot.setSupportedVehicleType(VehicleType.TWO_WHEELER);
                else parkingSpot.setSupportedVehicleType(VehicleType.FOUR_WHEELER);
                parkingSpot.setNumber(i*10+j);
                parkingSpot.setStatus(Status.ACTIVE);
                parkingSpot.setId(1000+j);
                parkingSpots.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);
            }
            parkingFloor.setParkingSpots(parkingSpots);
            parkingFloorRepository.put(parkingFloor);
            parkingFloors.add(parkingFloor);
        }

        parkingLot.setFloors(parkingFloors);
        parkingLotRepository.put(parkingLot);
    }
}
