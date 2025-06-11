package entregasemana3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Clase que lleva el registro de las puntuaciones de un jugador.
 * Almacena la cantidad de juegos completados y las puntuaciones por categoría.
 */
public class RecordScore {
        /** Número total de juegos completados por el jugador. */
    private int gamesCompleted;
        /** Mapa que asocia el nombre de una categoría con la lista de puntuaciones obtenidas en ella. */
    private Map<String, LinkedList<Score>> scores;
    /**
     * Constructor de la clase RecordScore.
     * Inicializa el contador de juegos completados y el mapa de puntuaciones.
     */
    public RecordScore(){
        gamesCompleted = 0;
        scores = new HashMap<>();
    }
     /**
     * Agrega un juego al registro de puntuaciones.
     * Actualiza el mapa de puntuaciones con las del nuevo juego y aumenta el contador de juegos completados.
     *
     * @param game Juego a registrar.
     */
    public void addGame(Game game) {
        scores.computeIfAbsent(game.getCategory(), k -> new LinkedList<>());
        scores.get(game.getCategory()).add(game.getScore());
        gamesCompleted += 1;
    }
     /**
     * Calcula la puntuación global sumando el número de palabras encontradas en todos los juegos.
     *
     * @return Puntuación global del jugador.
     */
    public int calculateGlobalScore() {
        int globalScore = 0;
        for (String category : scores.keySet()) {
            for (Score s : scores.get(category)) {
                globalScore += s.getNumberFoundWords();
            }
        }
        return globalScore;
    }
     /**
     * Calcula el tiempo promedio global en encontrar palabras, promediando entre todos los juegos completados.
     *
     * @return Tiempo promedio global en segundos.
     */
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
