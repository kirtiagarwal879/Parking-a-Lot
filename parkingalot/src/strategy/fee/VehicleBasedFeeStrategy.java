package src.strategy.fee;

import src.entities.ParkingTicket;
import src.vehicle.*;
import java.util.HashMap;

public class VehicleBasedFeeStrategy implements FeeStrategy {

    private static final HashMap<VehicleSize, Double> HOURLY_RATES;

    static {
        HOURLY_RATES = new HashMap<>();
        HOURLY_RATES.put(VehicleSize.SMALL, 10.0);
        HOURLY_RATES.put(VehicleSize.MEDIUM, 20.0);
        HOURLY_RATES.put(VehicleSize.LARGE, 30.0);
    }

    @Override
    public double calculateFee(ParkingTicket parkingTicket) {
        long duration = parkingTicket.getExitTimeStamp() - parkingTicket.getEntryTimeStamp();
        long hours = (long) Math.ceil(duration / (1000.0 * 60 * 60));
        return hours * HOURLY_RATES.get(
                parkingTicket.getVehicle().getVehicleSize());
    }
}
