package entregasemana3;
import java.sql.Array;
import java.sql.Timestamp;
import java.util.Arrays;

public class Word {
    private final String keyword;
    private final char[] letters;
    private final String meaning;
    private boolean isFound;
    private Timestamp foundAt;

    public Word(String word, String meaningFromDict) {
        keyword = word;
        letters = word.toCharArray();
        isFound = false;
        meaning = meaningFromDict;
        foundAt = null;
    }

    public boolean checkIfFound(char[] letters) {
        return Arrays.equals(this.letters, letters);
    }

    public char[] getLetters(){
        return letters;
    }

    public void setAsFound(){
        isFound = true;
    }

    public void setFoundAt(Timestamp time){
        foundAt = time;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getKeyword(){
        return keyword;
    }
}
