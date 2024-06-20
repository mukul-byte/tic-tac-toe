package services.PlayersFactory;

import models.player.ComputerPlayer;
import models.player.HumanPlayer;

public class PlayersFactory {
    public static HumanPlayer.HumanPlayerBuilder getHumanPlayerBuilder(){
        return new HumanPlayer.HumanPlayerBuilder();
    }

    public static ComputerPlayer.ComputerPlayerBuiler getComputerPlayerBuilder(){
        return new ComputerPlayer.ComputerPlayerBuiler();
    }
}
