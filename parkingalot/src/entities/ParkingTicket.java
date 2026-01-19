package src.entities;


import java.util.Date;
import java.util.UUID;

import src.vehicle.Vehicle;


public class ParkingTicket{
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final long entryTimestamp;
    private long exitTimeStamp;

    public ParkingTicket(Vehicle vehicle,ParkingSpot spot){
        this.ticketId=UUID.randomUUID().toString();
        this.vehicle =vehicle;
        this.spot=spot;
        this.entryTimestamp = new Date().getTime();
    }

    public String getTicketId()
    {
        return ticketId;
    }
    public Vehicle getVehicle()
    {
        return vehicle;
    }
    public ParkingSpot getSpot()
    {
        return spot;
    }
    public long getEntryTimeStamp()
    {
        return entryTimestamp;
    }
    public long getExitTimeStamp()
    {
        return exitTimeStamp;
    }
    public void setExitTimeStamp()
    {
        exitTimeStamp= new Date().getTime();
    }
}