package entregasemana3;

import entregasemana3.Interfaces.ICountdown;
/**
 * Representa un temporizador para el juego, que implementa la interfaz {@link ICountdown}.
 * Inicia con un tiempo predeterminado y puede ser iniciado, detenido o modificado.
 */
public class Timer implements ICountdown {
        /** Tiempo actual del temporizador en segundos. */
    private int timeInSeconds;
     /**
     * Constructor que inicializa el temporizador con 10 minutos (600 segundos).
     */
    public Timer(){
        timeInSeconds = 10 * 60;
    }
     /**
     * Devuelve el tiempo actual del temporizador en segundos.
     *
     * @return Tiempo en segundos.
     */
    public int getTime(){
        return timeInSeconds;
    }
    
    /**
     * Inicia el temporizador.
     * (Implementación pendiente)
     */
    @Override
    public void start() {
        // Lógica de inicio aún no implementada
    }
     /**
     * Agrega minutos al temporizador.
     * (Implementación pendiente)
     *
     * @param minutes Cantidad de minutos a agregar.
     */
    @Override
    public void addTime(int minutes) {

    }
     /**
     * Detiene el temporizador.
     * (Implementación pendiente)
     */
    @Override
    public void stop() {

    }
}
