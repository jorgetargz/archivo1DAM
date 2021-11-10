package tui;

import utils.Constants;

public class ShowWinners {
    public void showWinners(boolean p1Wins, boolean p1Ties, boolean p2Wins, boolean p2Ties) {
        if (p1Wins){
            System.out.println(Constants.PLAYER_1_WINS);
        } else if (p1Ties){
            System.out.println(Constants.PLAYER_1_TIES);
        } else
            System.out.println(Constants.PLAYER_1_LOSE);
        if (p2Wins){
            System.out.println(Constants.PLAYER_2_WINS);
        } else if (p2Ties){
            System.out.println(Constants.PLAYER_2_TIES);
        } else {
            System.out.println(Constants.PLAYER_2_LOSE);
        }
    }
}
