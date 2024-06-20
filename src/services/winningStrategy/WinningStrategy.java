package services.winningStrategy;

import models.Board;
import models.Symbol;

public interface WinningStrategy {
    public Symbol check(Board board);
}
