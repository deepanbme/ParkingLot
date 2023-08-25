package strategy.spotAllocationStrategy;

import model.Gate;
import model.ParkingSpot;
import model.VehicleType;

public interface SpotAllocationStrategy {
    ParkingSpot getSpot(VehicleType vehicleType, Gate gate);
}
