package models.player;

import models.Board;
import models.Symbol;
import models.User;

public class HumanPlayer extends Player {
    private User user;

    public HumanPlayer(User user, Symbol symbol) {
        this.user = user;
        this.symbol = symbol;
    }

    private HumanPlayer(HumanPlayerBuilder humanPlayerBuilder){
        this.user = humanPlayerBuilder.user;
        this.symbol = humanPlayerBuilder.symbol;
    }

    @Override
    public boolean play(Board board, Symbol symbol) {
        return false;
    }

    public static class HumanPlayerBuilder{
        private User user;
        private Symbol symbol;
        public HumanPlayerBuilder(){}

        public HumanPlayerBuilder setUser(User user){
            this.user = user;
            return this;
        }
        public HumanPlayerBuilder setSymbol(Symbol symbol){
            this.symbol = symbol;
            return this;
        }

        public HumanPlayer build(){
            return new HumanPlayer(this);
        }

    }
}
