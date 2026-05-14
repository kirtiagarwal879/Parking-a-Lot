package parkingalot.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingLot {
    private UUID id;
    private String name;
    private String address;
    private List<Floor> floors;

    public ParkingLot(String name, String address) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.floors = new ArrayList<>();
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public List<Floor> getFloors() {
        return floors;
    }
}