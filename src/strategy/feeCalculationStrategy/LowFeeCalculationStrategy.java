package strategy.feeCalculationStrategy;

import model.Ticket;
import model.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LowFeeCalculationStrategy implements FeeCalculationStrategy{

    private static final int two_Wheeler = 2;
    private static final int four_Wheeler = 2;

    @Override
    public long getFeeAmount(Ticket ticket) {
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime currentTime = LocalDateTime.now();
        long numberOfMinutes = ChronoUnit.MINUTES.between(entryTime, currentTime);
        if(vehicleType.equals(VehicleType.TWO_WHEELER)){
            return two_Wheeler * numberOfMinutes;
        }else{
            return four_Wheeler * numberOfMinutes;
        }
    }
}
