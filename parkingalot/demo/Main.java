package parkingalot.demo;

import parkingalot.Singleton.ParkingLotManager;
import parkingalot.enums.PaymentMethod;
import parkingalot.enums.VehicleType;
import parkingalot.enums.ZoneType;
import parkingalot.factorypattern.ParkingSlotFactory;
import parkingalot.models.*;
import parkingalot.services.PaymentService;
import parkingalot.services.TicketService;
import parkingalot.strategy.HourlyRateStrategy;

public class Main {

    public static void main(String[] args)
    {
        User user=new User("Kirti Agarwal","kirti@gmail.com","09890020698");
        User user2=new User("Harshit Jain","harshit2@gmail.com","0989020698");

        Vehicle vehicle = new Vehicle("KA01AB1234",VehicleType.FOUR_WHEELER,user);

        ParkingLot parkingLot = new ParkingLot(
                "City Mall Parking",
                "Bangalore"
        );
        Floor floor1 = new Floor(1, "Ground Floor");

         Zone regularZone = new Zone(
                "Regular Zone",
                ZoneType.REGULAR
        );
        ParkingSlot slot1 = ParkingSlotFactory.createSlot(
                VehicleType.FOUR_WHEELER,
                "A1",
                "Near Lift"
        );
        regularZone.addSlot(slot1);
        floor1.addZone(regularZone);
        parkingLot.addFloor(floor1);

        ParkingLotManager manager =ParkingLotManager.getInstance();
        
        manager.setParkingLot(parkingLot);
        ParkingSlot availableSlot = manager.findAvailableSlot(
                vehicle.getType()
        );
        if (availableSlot == null) {
            System.out.println("No Slot Available");
            return;
        }
        TicketService ticketService = new TicketService(
                new HourlyRateStrategy()
        );
        Ticket ticket = ticketService.generateTicket(
                vehicle,
                availableSlot
        );
        System.out.println(
                "Ticket Generated for Slot: " +
                availableSlot.getSlotNumber()
        );
         ticketService.exitVehicle(ticket);
          PaymentService paymentService = new PaymentService();
          Payment payment = paymentService.processPayment(
                100,
                PaymentMethod.UPI
        );

        System.out.println("Payment Successful");
    }
}