package tui;

import utils.Constants;

public class ShowWinners {
    public void mostrarPuntuaciones(boolean j1Gana, boolean j1Empata, boolean j2Gana, boolean j2Empata) {
        if (j1Gana){
            System.out.println(Constants.PLAYER_1_WINS);
        } else if (j1Empata){
            System.out.println(Constants.PLAYER_1_TIES);
        } else
            System.out.println(Constants.PLAYER_1_LOSE);
        if (j2Gana){
            System.out.println(Constants.PLAYER_2_WINS);
        } else if (j2Empata){
            System.out.println(Constants.PLAYER_2_TIES);
        } else {
            System.out.println(Constants.PLAYER_2_LOSE);
        }
    }
}
