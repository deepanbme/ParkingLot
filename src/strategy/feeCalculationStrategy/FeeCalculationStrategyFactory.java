package strategy.feeCalculationStrategy;

public class FeeCalculationStrategyFactory {
    public static FeeCalculationStrategy geFeeCalculationStrategy(){
        return new LowFeeCalculationStrategy();
    }
}
