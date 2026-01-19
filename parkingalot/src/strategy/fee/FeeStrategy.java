package src.strategy.fee;

import src.entities.ParkingTicket;

public interface FeeStrategy {

    public double calculateFee(ParkingTicket parkingTicket);
    
}