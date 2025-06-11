package entregasemana3;

import java.sql.Timestamp;
/**
 * Clase que representa la puntuación de un jugador en una partida.
 * Incluye el número de palabras encontradas y el tiempo promedio para encontrarlas.
 */
public class Score {
    /** Número de palabras encontradas por el jugador. */
    private int numberFoundWords;
        /** Tiempo promedio en segundos que el jugador tardó en encontrar cada palabra. */
    private float meanTimeToFindWord;
     /**
     * Constructor por defecto de la clase Score.
     * Inicializa los valores de palabras encontradas y tiempo promedio a cero.
     */
    public Score() {
        numberFoundWords = 0;
        meanTimeToFindWord = 0;
    }
     /**
     * Obtiene el número de palabras encontradas por el jugador.
     *
     * @return Número total de palabras encontradas.
     */
    public int getNumberFoundWords() {
        return numberFoundWords;
    }
    /**
     * Obtiene el tiempo promedio que el jugador tardó en encontrar una palabra.
     *
     * @return Tiempo promedio en segundos.
     */
    public float getMeanTimeToFindWord() {
        return meanTimeToFindWord;
    }
    /**
     * Suma puntos al contador de palabras encontradas.
     * Normalmente, 1 punto equivale a 1 palabra encontrada.
     *
     * @param points Cantidad de puntos (palabras) a sumar.
     */
    public void addWordPoints(int points) {
        numberFoundWords += points;
    }
    /**
     * Calcula el tiempo promedio que el jugador tardó en encontrar las palabras.
     * Usa un arreglo de marcas de tiempo y la marca de inicio del juego.
     *
     * @param times Arreglo de timestamps que representa los momentos en que se encontró cada palabra.
     * @param startGame Timestamp que representa el inicio de la partida.
     */
    public void calculateAverage(Timestamp[] times, Timestamp startGame){

        double averageTime = (double) (times[0].getTime() - startGame.getTime())/1000.0 ;
        for (int i=1; i<times.length; i++){
            averageTime += (double) (times[i].getTime() - times[i-1].getTime())/1000.0;
        }
        meanTimeToFindWord /= times.length;
    }
}
