package entregasemana3;
/**
 * Enum que representa diferentes categorías utilizadas para clasificar frases o vocabulario.
 * Cada categoría tiene una descripción asociada.
 */
public enum Categories {
     /** 
     * Categoría relacionada con aspectos de la personalidad de las personas. 
     */
    PERSONAL("aspectos de personalidad de las personas"),
      /** 
     * Categoría relacionada con defectos o fallas en objetos. 
     */
    OBJECTS("defectos en objetos"),
     /** 
     * Categoría relacionada con el vocabulario del ámbito de los negocios. 
     */
    BUSSINESS("vocabulario de negocios"),
    /** 
     * Categoría relacionada con términos del ámbito de la programación. 
     */
    PROGRAMMING("vocabulario de programación");
    // Descripción asociada a cada categoría

    Categories(String phrase) {

    }

}
