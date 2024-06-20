package services.winningStrategy;

import services.constants.WinningStrategyEnum;

public class WinningStrategyFactory {
    public static WinningStrategy getWinninStrategy(WinningStrategyEnum winningStrategyEnum){
        if(WinningStrategyEnum.VERTICAL.equals(winningStrategyEnum)){
            return new VerticalWinningStrategy();
        }
        return null;
    }
}
