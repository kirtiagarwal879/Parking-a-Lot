package parkingalot.services;

import java.time.Duration;
import java.time.LocalDateTime;

import parkingalot.models.ParkingSlot;
import parkingalot.models.Ticket;
import parkingalot.models.Vehicle;
import parkingalot.strategy.FeeStrategy;

public class TicketService {

    private FeeStrategy feeStrategy;

    public TicketService(FeeStrategy feeStrategy)
    {
        this.feeStrategy=feeStrategy;
    }


    public Ticket generateTicket(Vehicle vehicle , ParkingSlot slot)
    {
        slot.occupy();
        return new Ticket(vehicle , slot);
    }
    public double calculateFee(Ticket ticket)
    {
        long hours=Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
        if(hours==0)
            {
                hours=1;
            }
            return feeStrategy.calculateFee(hours);
    }

    public void exitVehicle(Ticket ticket)
    {
        double amount = calculateFee(ticket);
        ticket.closeTicket(amount);
        ticket.getSlot().release();
    }
}