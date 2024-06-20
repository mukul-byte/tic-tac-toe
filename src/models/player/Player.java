package models.player;

import models.Board;
import models.PlayerType;
import models.Symbol;

public abstract class Player {
    protected Symbol symbol;
//    protected PlayerType playerType;

    public abstract boolean play(Board board, Symbol symbol);

    public Symbol getSymbol() {
        return this.symbol;
    }

//    public PlayerType getPlayerType() {
//        return this.playerType;
//    }
}
