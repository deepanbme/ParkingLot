package strategy.spotAllocationStrategy;

import exceptions.ParkingSpotNotFoundException;
import model.*;
import repository.ParkingLotRepository;

public class RandomSpotAllocationStrategy implements SpotAllocationStrategy{
    private ParkingLotRepository parkingLotRepository;

    public RandomSpotAllocationStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingSpot getSpot(VehicleType vehicleType, Gate gate) {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotFromGate(gate);
        int currentFloor = gate.getFloorNumber();
        ParkingFloor parkingFloor = parkingLot.getFloors().get(currentFloor-1);
        for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots()){
            if(parkingSpot.getSupportedVehicleType().equals(vehicleType) &&
                    parkingSpot.getStatus().equals(Status.AVAILABLE)){
                return parkingSpot;
            }
        }

        for(ParkingFloor floor : parkingLot.getFloors()){
            for(ParkingSpot parkingSpot : floor.getParkingSpots()){
                if(parkingSpot.getSupportedVehicleType().equals(vehicleType) &&
                        parkingSpot.getStatus().equals(Status.AVAILABLE)){
                    return parkingSpot;
                }
            }
        }

        throw new ParkingSpotNotFoundException("Parking spot is not available for the vehicle type: " + vehicleType);
    }
}
