package parkingalot.Singleton;

import parkingalot.enums.VehicleType;
import parkingalot.models.Floor;
import parkingalot.models.ParkingLot;
import parkingalot.models.ParkingSlot;
import parkingalot.models.Zone;

public class ParkingLotManager {

    private static ParkingLotManager instance;
    private ParkingLot parkingLot;
    private ParkingLotManager() {
    }

    public static synchronized ParkingLotManager getInstance()
    {
        if(instance==null)
            {
                instance=new ParkingLotManager();
            }
        return  instance;   
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingSlot findAvailableSlot(VehicleType type)
    {
        for(Floor floor: parkingLot.getFloors())
            {
                for(Zone zone:floor.getZones())
                    {
                        for(ParkingSlot slot:zone.getSlots())
                            {
                                if(slot.isAvailable() && slot.getSupportedType()==type)
                                    {
                                        return slot;
                                    }
                            }
                    }
            }
    
    return null;
        }
}
