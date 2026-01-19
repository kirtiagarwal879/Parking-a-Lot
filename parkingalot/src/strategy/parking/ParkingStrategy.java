package src.strategy.parking;

import java.util.Optional;
import java.util.List;

import src.entities.ParkingSpot;
import src.entities.ParkingFloor;
import src.vehicle.*;

public interface ParkingStrategy {
        Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}