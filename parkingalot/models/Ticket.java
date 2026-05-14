package parkingalot.models;

import parkingalot.enums.TicketStatus;
import java.time.LocalDateTime;
import java.util.UUID;


public class Ticket {
    private UUID id;
    private Vehicle vehicle;
    private ParkingSlot slot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus status;
    private double totalAmount;

    public Ticket(Vehicle vehicle, ParkingSlot slot) {
        this.id = UUID.randomUUID();
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.ACTIVE;
    }

    public void closeTicket(double amount) {
        this.exitTime = LocalDateTime.now();
        this.totalAmount = amount;
        this.status = TicketStatus.CLOSED;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}