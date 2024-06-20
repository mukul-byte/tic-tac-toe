package models;

import exceptions.BoardExceptionException;
import exceptions.PlayerNumberException;
import exceptions.WinningStrategyException;
import models.player.Player;
import services.winningStrategy.WinningStrategy;
import services.constants.WinningStrategyEnum;
import services.winningStrategy.WinningStrategyFactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class Game {
    private Board board;
    private List<Player> players;
    private WinningStrategy winningStrategy;

    Game(GameBuilder gameBuilder) {
        this.board = gameBuilder.board;
        this.players = gameBuilder.players;
        this.winningStrategy = gameBuilder.winningStrategy;
    }

    public void start(){
        int playerIdx = 0;
        for(Player player: players){
            System.out.println("Player 1: "+ player.getSymbol());
        }
        System.out.println("==========GAME START=================");

        while(true){
            Player player = players.get(playerIdx);

            players.get(playerIdx).play(board, player.getSymbol());

            Symbol winnerSymbol = this.winningStrategy.check(board);
            if(!Symbol.N.equals(winnerSymbol)){
                System.out.println("==========GAME END==================");
                System.out.println("WInner is player: "+ playerIdx + " with symbol: " + player.getSymbol());
            }
            playerIdx = (playerIdx+1)%2;
        }
    }

    public static class GameBuilder{
        private Board board;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public GameBuilder(){
            players = new ArrayList<Player>();
        }

        public GameBuilder addPlayer(Player player){
            this.players.add(player);
            return this;
        }

        public GameBuilder setBoardSize(int size){
            this.board = new Board(size);
            return this;
        }

        public GameBuilder setWinningStrategy(WinningStrategyEnum startegy){
            this.winningStrategy = WinningStrategyFactory.getWinninStrategy(startegy);
            return this;
        }

        public Game validateAndBuild(){
            if(this.players.size() != 2) throw new PlayerNumberException("Total number of players should be only 2");
            if(isNull(this.board)){
                throw new BoardExceptionException("Board should be defined.");
            }
            if(isNull(this.winningStrategy)) {
                throw new WinningStrategyException("Winning Strategy should be defined.");
            }

            return new Game(this);
        }


    }
}
