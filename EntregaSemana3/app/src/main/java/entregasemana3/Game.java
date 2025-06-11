package entregasemana3;

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
}
