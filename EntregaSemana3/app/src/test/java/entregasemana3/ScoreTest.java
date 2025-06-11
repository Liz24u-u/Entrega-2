package entregasemana3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {

    private Score score;

    // Este método se ejecuta antes de cada prueba para inicializar una nueva
    // instancia de Score
    @BeforeEach
    public void setUp() {
        score = new Score();
    }

    // Test 1: Verifica que los valores iniciales sean correctos
    @Test
    public void testInitialValues() {
        // Al crear una nueva instancia, el número de palabras encontradas debe ser 0
        assertEquals(0, score.getNumberFoundWords());

        // El tiempo promedio para encontrar palabras también debe iniciar en 0.0
        assertEquals(0.0f, score.getMeanTimeToFindWord());
    }

    // Test 2: Verifica que el método addWordPoints sume correctamente los puntos
    @Test
    public void testAddWordPoints() {
        // Agregamos 1 punto
        score.addWordPoints(1);
        assertEquals(1, score.getNumberFoundWords());

        // Luego agregamos 2 puntos más, total esperado: 3
        score.addWordPoints(2);
        assertEquals(3, score.getNumberFoundWords());
    }

    // Test 3: Verifica que el cálculo del tiempo promedio sea correcto con varios
    // tiempos
    @Test
    public void testCalculateAverageTime() {
        // Inicio del juego a las 10:00:00
        Timestamp startGame = Timestamp.valueOf("2023-01-01 10:00:00");

        // Tiempos en los que se encontraron palabras:
        Timestamp[] times = new Timestamp[] {
                Timestamp.valueOf("2023-01-01 10:00:05"), // +5s desde inicio
                Timestamp.valueOf("2023-01-01 10:00:10"), // +5s desde el anterior
                Timestamp.valueOf("2023-01-01 10:00:25") // +15s desde el anterior
        };

        // Llamamos al método que calcula el tiempo promedio
        score.calculateAverage(times, startGame);

        // El tiempo total es 5 + 5 + 15 = 25 segundos
        // Promedio esperado = 25 / 3 = 8.33...
        float expectedAverage = (5 + 5 + 15) / 3.0f;

        // Verificamos que el resultado esté dentro del margen de error
        assertEquals(expectedAverage, score.getMeanTimeToFindWord(), 0.001f);
    }

    // Test 4: Verifica el cálculo con un solo tiempo
    @Test
    public void testCalculateAverageWithOneTime() {
        // Inicio del juego
        Timestamp startGame = Timestamp.valueOf("2023-01-01 10:00:00");

        // Solo un tiempo registrado a los 7 segundos
        Timestamp[] times = new Timestamp[] {
                Timestamp.valueOf("2023-01-01 10:00:07")
        };

        // Llamamos al método
        score.calculateAverage(times, startGame);

        // El promedio debe ser simplemente 7 segundos
        assertEquals(7.0f, score.getMeanTimeToFindWord(), 0.001f);
    }
}