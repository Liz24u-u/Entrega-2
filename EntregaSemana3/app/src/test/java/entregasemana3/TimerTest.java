package entregasemana3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimerTest {

    private Timer timer;

    // Se ejecuta antes de cada test: inicializa el temporizador
    @BeforeEach
    public void setUp() {
        timer = new Timer();
    }

    // Test 1: Verifica que el temporizador se inicializa con 10 minutos (600
    // segundos)
    @Test
    public void testInitialTime() {
        assertEquals(600, timer.getTime(), "El tiempo inicial debería ser de 600 segundos (10 minutos)");
    }

    // Test 2: Verifica que el método addTime() añade tiempo correctamente
    @Test
    public void testAddTimeIncreasesTimeCorrectly() {
        timer.addTime(5); // Añade 5 minutos

        assertEquals(600 + 300, timer.getTime(), "El tiempo debería ser 900 segundos tras añadir 5 minutos");
    }

    // Test 3: Verifica que el método addTime() con valor cero no cambia el tiempo
    @Test
    public void testAddZeroTimeDoesNotChangeTime() {
        timer.addTime(0);

        assertEquals(600, timer.getTime(), "El tiempo no debería cambiar al añadir 0 minutos");
    }

    // Test 4: Verifica que el método addTime() puede manejar valores negativos (si
    // se permite)
    @Test
    public void testAddNegativeTimeDecreasesTime() {
        timer.addTime(-2); // Resta 2 minutos

        assertEquals(600 - 120, timer.getTime(), "El tiempo debería ser 480 segundos tras restar 2 minutos");
    }

    // Test 5: Verifica que el método start() no lanza excepciones (aunque esté
    // vacío)
    @Test
    public void testStartDoesNotThrow() {
        assertDoesNotThrow(() -> timer.start(), "El método start() no debería lanzar excepción");
    }

    // Test 6: Verifica que el método stop() no lanza excepciones (aunque esté
    // vacío)
    @Test
    public void testStopDoesNotThrow() {
        assertDoesNotThrow(() -> timer.stop(), "El método stop() no debería lanzar excepción");
    }
}
