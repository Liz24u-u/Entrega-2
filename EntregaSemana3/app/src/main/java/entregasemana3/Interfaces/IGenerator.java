package entregasemana3.Interfaces;

import entregasemana3.Game;
import entregasemana3.Word;

public interface IGenerator {
    public Word[] selectWordsFromCategory(String category, int numberOfWords);
    public Word[] getBonusWords(Game game);


}
