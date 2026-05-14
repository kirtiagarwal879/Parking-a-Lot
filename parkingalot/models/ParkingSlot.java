package parkingalot.models;

import java.util.UUID;

import parkingalot.enums.SlotStatus;
import parkingalot.enums.VehicleType;

public class ParkingSlot {

    private UUID id;
    private String slotNumber;
    private SlotStatus status;
    private VehicleType supportedType;
    private String location;

    public ParkingSlot(String slotNumber, VehicleType supportedType, String location) {
        this.id = UUID.randomUUID();
        this.slotNumber = slotNumber;
        this.status = SlotStatus.AVAILABLE;
        this.supportedType = supportedType;
        this.location = location;
    }

    public boolean isAvailable()
    {
        return status==SlotStatus.AVAILABLE;
    }
    public void occupy() {
        this.status = SlotStatus.OCCUPIED;
    }
    public void release() {
        this.status = SlotStatus.AVAILABLE;
    }
    public VehicleType getSupportedType() {
        return supportedType;
    }

    public String getSlotNumber() {
        return slotNumber;
    }
    
}