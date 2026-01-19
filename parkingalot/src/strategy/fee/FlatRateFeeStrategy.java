package src.strategy.fee;

import src.entities.ParkingTicket;

public class FlatRateFeeStrategy implements FeeStrategy{

    private static final double RATE_PER_HOUR = 10.0;

    @Override
    public double calculateFee(ParkingTicket parkingTicket)
    {
        long duration= parkingTicket.getExitTimeStamp()-parkingTicket.getEntryTimeStamp();
        long hours = (duration/(1000*60*60))+1;
        return RATE_PER_HOUR*hours;
    }
}