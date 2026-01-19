package src.strategy.parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import src.entities.ParkingFloor;
import src.entities.ParkingSpot;
import src.vehicle.Vehicle;

public class FarthestFirstStrategy implements ParkingStrategy{

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle){

        List<ParkingFloor> reversedFloors = new ArrayList<>(floors);
        Collections.reverse(reversedFloors);
        for(ParkingFloor floor: reversedFloors)
        {
            Optional<ParkingSpot> spot= floor.findAvailableSpot(vehicle);
            if (spot.isPresent()) {
                return spot;
            }
        }
        return Optional.empty();

    }
}