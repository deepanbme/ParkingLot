package strategy.feeCalculationStrategy;

import model.Ticket;

public interface FeeCalculationStrategy {
    long getFeeAmount(Ticket ticket);
}
