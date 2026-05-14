package parkingalot.strategy;

public class FlatRateStrategy implements FeeStrategy {
    @Override
    public double calculateFee(long hours) {
        return 100;
    }
}
