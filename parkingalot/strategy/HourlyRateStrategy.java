package parkingalot.strategy;

public class HourlyRateStrategy implements FeeStrategy {
     @Override
    public double calculateFee(long hours) {
        return hours * 20;
    }
}
