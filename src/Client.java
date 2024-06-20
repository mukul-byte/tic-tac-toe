import models.Game;
import models.Symbol;
import models.User;
import models.player.ComputerPlayer;
import models.player.HumanPlayer;
import models.player.Player;
import services.PlayersFactory.PlayersFactory;
import services.constants.ComputerPlayingStrategyEnum;
import services.computerPlayingStrategy.ComputerPlayingStrategyFactory;
import services.constants.WinningStrategyEnum;

public class Client {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        User user1 = new User.UserBuilder()
                .setName("nike")
                .setEmail("nike@gmail.com")
                .setPhoto("nie.png")
                .build();
        Player humanPlayer = PlayersFactory.getHumanPlayerBuilder()
                .setUser(user1)
                .setSymbol(Symbol.O)
                .build();
               // new HumanPlayer(user1, Symbol.O);

        Player computerPLayer = PlayersFactory.getComputerPlayerBuilder()
                .setSymbol(Symbol.X)
                .getComputerPlayingStartegy(ComputerPlayingStrategyFactory
                        .getComputerPlayingStrategy(ComputerPlayingStrategyEnum.EASY))
                .build();

//                new ComputerPlayer(
//                ComputerPlayingStrategyFactory
//                        .getComputerPlayingStrategy(ComputerPlayingStrategyEnum.EASY),
//                Symbol.X);

        Game game = new Game.GameBuilder()
                .setWinningStrategy(WinningStrategyEnum.VERTICAL)
                .setBoardSize(3)
                .addPlayer(humanPlayer)
                .addPlayer(computerPLayer)
                .validateAndBuild();

        game.start();

    }
}