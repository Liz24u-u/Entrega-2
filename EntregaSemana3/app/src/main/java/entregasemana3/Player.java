package entregasemana3;
/**
 * Clase que representa a un jugador del juego.
 * Contiene la información básica del usuario como nombre, contraseña y su puntuación.
 */
public class Player {
        /** Nombre de usuario del jugador. */
    private String username;
        /** Contraseña del jugador. */
    private String password;
    /** Puntaje global del jugador. */
    private RecordScore score;
/**
     * Constructor de la clase Player.
     * Crea un nuevo jugador con nombre de usuario y contraseña especificados.
     *
     * @param userName Nombre de usuario del jugador.
     * @param pass Contraseña del jugador.
     */

    public Player(String userName, String pass) {
        username = userName;
        password = pass;
        score = new RecordScore();
    }

    public RecordScore getScore(){
        return score;
    }
}
