package blackjack.services;

public class GetWinners {
    public boolean[] getWinners(boolean blackjackP1, boolean blackjackP2, boolean blackjackCp, int scoreP1, int scoreP2, int scoreCp, boolean p1Lose, boolean p2Lose, boolean cpLose) {
        boolean p1Wins = false;
        boolean p1Ties = false;
        boolean p2Wins = false;
        boolean p2Ties = false;
        boolean[] results = new boolean[6];
        for (int i = 0; i < results.length; i++) {
            results[i] = false;
        }
        if (cpLose) {
            if (!p1Lose) {
                p1Wins = true;
            }
            if (!p2Lose) {
                p2Wins = true;
            }
        } else if (blackjackCp) {
            if (blackjackP1) {
                p1Wins = true;
            }
            if (blackjackP2) {
                p2Wins = true;
            }
        } else {
            if (scoreP1 > scoreCp && scoreP1 <= 21) {
                p1Wins = true;
            } else if (scoreP1 == scoreCp){
                p1Ties = true;
            }
            if (scoreP2 > scoreCp && scoreP2 <= 21) {
                p2Wins = true;
            } else if (scoreP2 == scoreCp){
                p2Ties = true;
            }
        }

        //Agrupo resultados en un array para devolver multiples booleanos
        if (p1Wins){
            results[0] = true;
        } else if (p1Ties){
            results[1] = true;
        } else {
            results[2] = true;
        }
        if (p2Wins){
            results[3] = true;
        } else if (p2Ties){
            results[4] = true;
        } else {
            results[5] = true;
        }
        return results;
    }
}
