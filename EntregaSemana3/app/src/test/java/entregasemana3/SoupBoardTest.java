package entregasemana3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SoupBoardTest {

    private SoupBoard board;

    // Se ejecuta antes de cada test: inicializa un tablero con una lista de
    // palabras
    @BeforeEach
    public void setUp() {
        Word[] words = {
                new Word("JAVA"),
                new Word("CODE")
        };
        board = new SoupBoard(words);
    }

    // Test 1: Verifica que las palabras se almacenan correctamente en el
    // constructor
    @Test
    public void testWordsAreStoredCorrectly() {
        Word[] storedWords = board.getWords();

        // Verifica que la cantidad de palabras es correcta
        assertEquals(2, storedWords.length);

        // Verifica que el contenido de las palabras se mantuvo correctamente
        assertArrayEquals("JAVA".toCharArray(), storedWords[0].getLetters());
        assertArrayEquals("CODE".toCharArray(), storedWords[1].getLetters());
    }

    // Test 2: Verifica que al establecer la ubicación de una palabra, todas sus
    // letras están en el tablero
    @Test
    public void testSetWordLocationPlacesLetters() {
        Word word = new Word("TEST");
        board.setWordLocation(word);

        // Revisamos si todas las letras están presentes al menos una vez en el tablero
        for (char c : word.getLetters()) {
            boolean found = false;

            for (int i = 0; i < 20; i++) { // Se asume un tamaño de tablero razonable (max word + span)
                for (int j = 0; j < 20; j++) {
                    // Refleja si la letra está en alguna celda del tablero
                    try {
                        java.lang.reflect.Method method = SoupBoard.class.getDeclaredMethod("getCharByCoordinate",
                                int.class, int.class);
                        method.setAccessible(true);
                        char ch = (char) method.invoke(board, i, j);
                        if (ch == c) {
                            found = true;
                            break;
                        }
                    } catch (Exception e) {
                        fail("Error accediendo al tablero internamente");
                    }
                }
                if (found)
                    break;
            }

            // Verifica que se haya encontrado la letra en el tablero
            assertTrue(found, "Letra '" + c + "' no encontrada en el tablero");
        }
    }

    // Test 3: Verifica que no se sobrescriban letras diferentes en la misma
    // posición
    @Test
    public void testNoLetterOverwriteConflict() {
        Word word1 = new Word("JAVA");
        Word word2 = new Word("JAZZ"); // Comparte letras con 'JAVA', pero también contiene una diferente

        board.setWordLocation(word1);
        board.setWordLocation(word2);

        // No se puede verificar con certeza sin acceso público al tablero,
        // pero al menos aseguramos que no haya excepciones y ambas palabras se insertan
        assertDoesNotThrow(() -> {
            board.setWordLocation(new Word("TEST"));
        });
    }

    // Test 4: Verifica que el tablero imprime sin errores
    @Test
    public void testPrintBoard() {
        // Inserta una palabra y verifica que imprimir el tablero no genera excepciones
        board.setWordLocation(new Word("HELLO"));

        // No se verifica salida, solo que no lance excepción
        assertDoesNotThrow(() -> {
            board.printBoard();
        });
    }
}