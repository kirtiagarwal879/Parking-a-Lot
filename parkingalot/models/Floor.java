package parkingalot.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Floor {
    private UUID id;
    private int floorNumber;
    private String name;
    private List<Zone> zones;

    public Floor(int floorNumber, String name) {
        this.id = UUID.randomUUID();
        this.floorNumber = floorNumber;
        this.name = name;
        this.zones = new ArrayList<>();
    }

    public void addZone(Zone zone) {
        zones.add(zone);
    }

    public List<Zone> getZones() {
        return zones;
    }
}