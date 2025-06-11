package entregasemana3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class RecordScoreTest {

    private RecordScore recordScore;

    @BeforeEach
    public void setUp() {
        recordScore = new RecordScore();
    }

    // Test 1: Verifica que al iniciar RecordScore, no haya juegos completados ni
    // puntajes registrados
    @Test
    public void testInitialState() {
        // Calculamos el puntaje y tiempo global antes de agregar ningún juego
        assertEquals(0, recordScore.calculateGlobalScore());
        assertEquals(Double.NaN, recordScore.calculateGlobalMeanTime()); // 0/0 da NaN
    }

    // Test 2: Verifica que agregar un juego incrementa el contador de juegos
    @Test
    public void testAddGameIncrementsGamesCompleted() {
        // Creamos un juego con una categoría y una lista de scores
        Game game = new Game("Animals", createScores(3, 5f));

        recordScore.addGame(game);

        // El puntaje global debería ser 3 (sólo una Score con 3 palabras)
        assertEquals(3, recordScore.calculateGlobalScore());

        // El tiempo medio global debería ser 5 (media de una única puntuación)
        assertEquals(5.0, recordScore.calculateGlobalMeanTime(), 0.001);
    }

    // Test 3: Verifica el cálculo correcto con múltiples juegos y categorías
    @Test
    public void testGlobalScoreAndMeanWithMultipleGames() {
        Game game1 = new Game("Science", createScores(4, 6f));
        Game game2 = new Game("Math", createScores(2, 4f));
        Game game3 = new Game("Science", createScores(1, 8f));

        recordScore.addGame(game1);
        recordScore.addGame(game2);
        recordScore.addGame(game3);

        // Puntaje total: 4 + 2 + 1 = 7
        assertEquals(7, recordScore.calculateGlobalScore());

        // Tiempo promedio global: (6 + 4 + 8) / 3 = 6.0
        assertEquals(6.0, recordScore.calculateGlobalMeanTime(), 0.001);
    }

    // Test 4: Verifica comportamiento con categorías duplicadas (sobrescribe la
    // anterior)
    @Test
    public void testCategoryOverwriteInAddGame() {
        Game game1 = new Game("History", createScores(3, 9f));
        Game game2 = new Game("History", createScores(2, 3f)); // debería reemplazar al anterior

        recordScore.addGame(game1);
        recordScore.addGame(game2); // sobrescribe la categoría "History"

        // Solo debería contar el score del segundo juego
        assertEquals(2, recordScore.calculateGlobalScore());
        assertEquals(3.0, recordScore.calculateGlobalMeanTime(), 0.001);
    }

    // Método auxiliar para crear una lista de Score con un único Score con datos
    // específicos
    private LinkedList<Score> createScores(int foundWords, float meanTime) {
        Score s = new Score();
        s.addWordPoints(foundWords);
        // Simula que el promedio ya fue calculado
        try {
            java.lang.reflect.Field field = Score.class.getDeclaredField("meanTimeToFindWord");
            field.setAccessible(true);
            field.set(s, meanTime);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        LinkedList<Score> list = new LinkedList<>();
        list.add(s);
        return list;
    }
}
