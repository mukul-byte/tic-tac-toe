package services.computerPlayingStrategy;

import models.Board;
import models.Symbol;

public interface ComputerPlayingStrategy {
    public boolean play(Board board, Symbol symbol);
}
