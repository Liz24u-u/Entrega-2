package entregasemana3;
/**
 * Clase que representa una partida del juego.
 * Contiene la información del jugador, categoría, tablero, temporizador, puntuación
 * y generador de lista de palabras, entre otros elementos necesarios para la ejecución del juego.
 */

import java.util.LinkedList;
import java.util.Objects;

public class Game {
        /** Jugador que participa en la partida. */
    private final Player player;
        /** Categoría del vocabulario utilizado en la partida. */
    private final Categories category;
        /** Temporizador del juego. */
    private final Timer timer;
        /** Tablero de sopa de letras. */
    private final SoupBoard board;
        /** Puntuación del jugador en la partida. */
    private final Score score;
        /** Generador de listas de palabras para el juego. */
    private final WordsListGenerator listGenerator;
        /** Número de palabras que contiene el tablero. */
    private final int numberOfWords;

     /**
     * Constructor de la clase Game.
     * Inicializa todos los componentes del juego con los valores proporcionados y crea instancias de soporte.
     *
     * @param newPlayer Jugador que inicia la partida.
     * @param gameCategory Categoría del vocabulario que se utilizará en la partida.
     * @param newBoard Tablero de sopa de letras generado para esta partida.
     */
    public Game(Player newPlayer, Categories gameCategory, SoupBoard newBoard){
        player = newPlayer;
        board = newBoard;
        category = gameCategory;
        timer = new Timer();
        score = new Score();
        listGenerator = new WordsListGenerator();
        numberOfWords = newBoard.getWords().length;
    }
 /**
     * Devuelve el tablero actual del juego.
     *
     * @return El objeto {@code SoupBoard} utilizado en esta partida.
     */
    public SoupBoard getBoard(){
        return board;
    }

    public String getCategory(){
        return category.toString();
    }

    public Score getScore(){
        return score;
    }

    public void buildGame(){
        board.generateSoupBoard(listGenerator.selectWordsFromCategory(category.toString(), numberOfWords));
    }

    public int[][] getFoundWordsLocation(){
        LinkedList<Word> foundWords = board.getFoundWords();
        int[][] coordinates = new int[foundWords.size()][5];
        for(int i=0; i<foundWords.size(); i++){
            coordinates[i] = board.getWordLocation(foundWords.get(i));
        }
        return coordinates;
    }

    public boolean matchWord(Word wordToFind){
        for(Word word: board.getWords()){
            if (!word.isFound() && Objects.equals(wordToFind.getKeyword(), word.getKeyword())){
                return true;
            }
        }
        return false;
    }

    public void startGame(){

    }
    public void endGame(){

    }

    public void saveScore(){
        player.getScore().addGame(this);
    }

}
