package entregasemana3;
import java.sql.Array;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Representa una palabra dentro del juego, incluyendo su significado,
 * estado de descubrimiento y momento en que fue encontrada.
 */
public class Word {
        /** Palabra clave escrita en texto plano. */
    private final String keyword;
        /** Letras individuales que componen la palabra. */
    private final char[] letters;
        /** Significado de la palabra según el diccionario. */
    private final String meaning;
        /** Indica si la palabra ha sido encontrada en el juego. */
    private boolean isFound;
        /** Marca de tiempo que indica cuándo se encontró la palabra. */
    private Timestamp foundAt;
    
     /**
     * Constructor que inicializa una palabra con su significado.
     *
     * @param word Texto de la palabra.
     * @param meaningFromDict Significado asociado a la palabra.
     */
    public Word(String word, String meaningFromDict) {
        keyword = word;
        letters = word.toCharArray();
        isFound = false;
        meaning = meaningFromDict;
        foundAt = null;
    }
    /**
     * Verifica si la palabra ha sido encontrada comparando sus letras.
     *
     * @param letters Letras a comparar con la palabra original.
     * @return {@code true} si las letras coinciden exactamente, {@code false} en caso contrario.
     */
    public boolean checkIfFound(char[] letters) {
        return Arrays.equals(this.letters, letters);
    }
    /**
     * Devuelve el arreglo de letras que componen la palabra.
     *
     * @return Arreglo de caracteres.
     */
    public char[] getLetters(){
        return letters;
    }
    /**
     * Marca la palabra como encontrada.
     */
    public void setAsFound(){
        isFound = true;
    }
    /**
     * Establece el momento en que se encontró la palabra.
     *
     * @param time Objeto {@link Timestamp} con la hora de descubrimiento.
     */
    public void setFoundAt(Timestamp time){
        foundAt = time;
    }
    /**
     * Devuelve el significado de la palabra.
     *
     * @return Significado en formato texto.
     */
    public String getMeaning() {
        return meaning;
    }
    /**
     * Devuelve la palabra clave.
     *
     * @return Palabra original en formato texto.
     */
    public String getKeyword(){
        return keyword;
    }
    /**
     * Indica si la palabra ya ha sido encontrada en el juego.
     *
     * @return {@code true} si la palabra ha sido encontrada, {@code false} en caso contrario.
     */
    public boolean isFound() {
        return isFound;
    }
}
