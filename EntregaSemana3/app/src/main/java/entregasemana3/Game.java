package entregasemana3;

import java.util.LinkedList;
import java.util.Objects;

public class Game {
    private final Player player;
    private final Categories category;
    private final Timer timer;
    private final SoupBoard board;
    private final Score score;
    private final WordsListGenerator listGenerator;
    private final int numberOfWords;

    public Game(Player newPlayer, Categories gameCategory, SoupBoard newBoard){
        player = newPlayer;
        board = newBoard;
        category = gameCategory;
        timer = new Timer();
        score = new Score();
        listGenerator = new WordsListGenerator();
        numberOfWords = newBoard.getWords().length;
    }

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
