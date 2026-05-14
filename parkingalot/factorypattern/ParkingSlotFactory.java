package parkingalot.factorypattern;

import parkingalot.enums.VehicleType;
import parkingalot.models.ParkingSlot;

public class ParkingSlotFactory {

     public static ParkingSlot createSlot(VehicleType type,String slotNumber,String location) {

        return new ParkingSlot(slotNumber, type, location);
    }
    
}


