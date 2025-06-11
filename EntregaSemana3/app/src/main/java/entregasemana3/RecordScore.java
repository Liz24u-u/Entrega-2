package entregasemana3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RecordScore {
    private int gamesCompleted;
    private Map<String, LinkedList<Score>> scores;
    public RecordScore(){
        gamesCompleted = 0;
        scores = new HashMap<>();
    }
    public void addGame(Game game) {
        scores.computeIfAbsent(game.getCategory(), k -> new LinkedList<>());
        scores.get(game.getCategory()).add(game.getScore());
        gamesCompleted += 1;
    }

    public int calculateGlobalScore() {
        int globalScore = 0;
        for (String category : scores.keySet()) {
            for (Score s : scores.get(category)) {
                globalScore += s.getNumberFoundWords();
            }
        }
        return globalScore;
    }

    public double calculateGlobalMeanTime() {
        double globalMeanTime = 0d;
        for (String category : scores.keySet()) {
            for (Score s : scores.get(category)) {
                globalMeanTime += s.getMeanTimeToFindWord();
            }
        }
        return globalMeanTime/(double)gamesCompleted;
    }
}
