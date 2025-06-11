package entregasemana3;

import java.sql.Timestamp;

public class Score {

    private int numberFoundWords;
    private float meanTimeToFindWord;

    public Score() {
        numberFoundWords = 0;
        meanTimeToFindWord = 0;
    }

    public int getNumberFoundWords() {
        return numberFoundWords;
    }

    public float getMeanTimeToFindWord() {
        return meanTimeToFindWord;
    }

    public void addWordPoints(int points) {
        numberFoundWords += points;
    }

    public void calculateAverage(Timestamp[] times, Timestamp startGame){

        double averageTime = (double) (times[0].getTime() - startGame.getTime())/1000.0 ;
        for (int i=1; i<times.length; i++){
            averageTime += (double) (times[i].getTime() - times[i-1].getTime())/1000.0;
        }
        meanTimeToFindWord /= times.length;
    }
}
