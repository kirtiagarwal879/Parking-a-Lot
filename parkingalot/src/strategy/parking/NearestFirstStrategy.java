package src.strategy.parking;

import java.util.List;
import java.util.Optional;

import src.entities.ParkingFloor;
import src.entities.ParkingSpot;
import src.vehicle.Vehicle;

public class NearestFirstStrategy implements ParkingStrategy{

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle){
        for(ParkingFloor floor: floors)
        {
            Optional<ParkingSpot> spot= floor.findAvailableSpot(vehicle);
            if (spot.isPresent()) {
                return spot;
            }
        }
        return Optional.empty();

    }
}