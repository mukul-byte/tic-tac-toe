package models.player;

import exceptions.ComputerPlayingStrateyNotDefinedException;
import exceptions.SymbolNotDefinedException;
import models.Board;
import models.Symbol;
import models.player.Player;
import models.PlayerType;
import services.computerPlayingStrategy.ComputerPlayingStrategy;

import static java.util.Objects.isNull;

public class ComputerPlayer extends Player {
    private ComputerPlayingStrategy computerPlayingStartegy;

    public ComputerPlayer(ComputerPlayingStrategy computerPlayingStartegy, Symbol symbol) {
        this.computerPlayingStartegy = computerPlayingStartegy;
        this.symbol = symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    private ComputerPlayer(ComputerPlayerBuiler computerPlayerBuiler){
        this.computerPlayingStartegy= computerPlayerBuiler.computerPlayingStartegy;
        this.symbol = computerPlayerBuiler.symbol;
    }

    @Override
    public boolean play(Board board, Symbol symbol) {
        return this.computerPlayingStartegy.play(board, symbol);
    }

    public static class ComputerPlayerBuiler{
        private ComputerPlayingStrategy computerPlayingStartegy;
        private Symbol symbol;

        public ComputerPlayerBuiler getComputerPlayingStartegy(ComputerPlayingStrategy computerPlayingStartegy) {
            this.computerPlayingStartegy= computerPlayingStartegy;
            return this;
        }

        public ComputerPlayerBuiler setSymbol(Symbol symbol) {
            this.symbol= symbol;
            return this;
        }

        public ComputerPlayer build(){
            if(isNull(this.symbol)){
                throw new SymbolNotDefinedException();
            }

            if(isNull(this.computerPlayingStartegy)){
                throw new ComputerPlayingStrateyNotDefinedException();
            }

            return new ComputerPlayer(this);
        }
    }
}
