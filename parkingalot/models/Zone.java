package parkingalot.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import parkingalot.enums.ZoneType;

public class Zone {

    private UUID id;
    private String name;
    private ZoneType type;
    private List<ParkingSlot> slots;

     public Zone(String name, ZoneType type) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.slots = new ArrayList<>();
    }

    public void addSlot(ParkingSlot slot) {
        slots.add(slot);
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }
}