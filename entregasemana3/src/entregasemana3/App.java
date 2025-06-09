package entregasemana3;

/**
 * Clase principal de la aplicación que imprime un saludo simple.
 */
public class App {

    /**
     * Devuelve un saludo de prueba.
     *
     * @return Una cadena con el saludo "prueba compilacion".
     */
    public String getGreeting() {
        return "prueba compilacion";
    }

    /**
     * Método principal que ejecuta la aplicación.
     *
     * @param args Argumentos de línea de comandos (no se usan).
     */
    public static void main(String[] args) {
        // Crea una instancia de App y muestra el saludo
        System.out.println(new App().getGreeting());
    }
}

