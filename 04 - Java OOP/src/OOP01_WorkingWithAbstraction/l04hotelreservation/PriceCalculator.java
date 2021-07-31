package OOP01_WorkingWithAbstraction.l04hotelreservation;

public class PriceCalculator {

    public static double calculate(ReservationDetails reservationDetails){
        double price = reservationDetails.getPricePerDay() * reservationDetails.getNumberOfDays();

        price = price * reservationDetails.getSeason().getValue();

        price *= (1 - reservationDetails.getType().getDiscount());

        return price;
    }

}
