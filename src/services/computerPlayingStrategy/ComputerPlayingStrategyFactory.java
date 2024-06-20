package services.computerPlayingStrategy;

import services.constants.ComputerPlayingStrategyEnum;

public class ComputerPlayingStrategyFactory {
    public static ComputerPlayingStrategy getComputerPlayingStrategy(ComputerPlayingStrategyEnum computerPlayingStrategyEnum){
        if(ComputerPlayingStrategyEnum.EASY.equals(computerPlayingStrategyEnum)){
            return new EasyComputerPlayingStrategy();
        }
        return null;
    }
}
