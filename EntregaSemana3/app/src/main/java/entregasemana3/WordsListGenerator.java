package entregasemana3;

import entregasemana3.Interfaces.IGenerator;
import entregasemana3.Categories;

import java.util.HashMap;
import java.util.Map;
/**
 * Clase que genera listas de palabras según la categoría seleccionada.
 * También puede seleccionar palabras aleatorias como bonificación.
 */
public class WordsListGenerator implements IGenerator {
        /** Semilla aleatoria usada para generación de palabras. */
    private int seed;
        /** Máximo número de palabras de bonificación permitidas. */
    private final int maxNumberOfBonusWords = 3;
        /** Mínimo valor para la semilla aleatoria. */
    private final int minSeed = 1000;
        /** Máximo valor para la semilla aleatoria. */
    private final int maxSeed = 100000;
        /** Mapa que asocia una categoría con su lista correspondiente de palabras. */
    private Map<String, Word[]> wordCategories = new HashMap<>();
    /**
     * Constructor que inicializa la semilla y carga las listas de palabras por categoría.
     */
    public WordsListGenerator(){
        seed = (int)(Math.random() * (maxSeed - minSeed)) + minSeed;
        wordCategories.put(Categories.PERSONAL.toString(), personalities);
        wordCategories.put(Categories.BUSSINESS.toString(), businessWords);
        wordCategories.put(Categories.OBJECTS.toString(), objectDefects);
        wordCategories.put(Categories.PROGRAMMING.toString(), programmingWords);
    }
    /**
     * Selecciona un conjunto aleatorio de palabras de una categoría específica.
     *
     * @param category Nombre de la categoría.
     * @param numberOfWords Número de palabras a seleccionar.
     * @return Arreglo de palabras seleccionadas aleatoriamente.
     */
    @Override
    public Word[] selectWordsFromCategory(String category, int numberOfWords) {
        return selectRandomWordsFromGroup(wordCategories.get(category), numberOfWords);
    }
     /**
     * Obtiene palabras de bonificación del tablero del juego.
     *
     * @param game Instancia del juego.
     * @return Arreglo de palabras de bonificación seleccionadas aleatoriamente.
     */
    @Override
    public Word[] getBonusWords(Game game) {
        return selectRandomWordsFromGroup(game.getBoard().getWords(), maxNumberOfBonusWords);
    }
     /**
     * Método auxiliar para seleccionar palabras aleatorias desde un arreglo dado.
     *
     * @param words Arreglo de palabras fuente.
     * @param numberOfWords Número de palabras a seleccionar.
     * @return Arreglo con palabras seleccionadas aleatoriamente.
     */
    private static Word[] selectRandomWordsFromGroup(Word[] words, int numberOfWords){
        Word[] selectedWords = new Word[numberOfWords];
        int randomIndex;
        for (int i = 0; i <= numberOfWords; i++){
            randomIndex = (int)(Math.random() * (numberOfWords - 1));
            selectedWords[i] = words[randomIndex];
        }
        return  selectedWords;
    }
        /** Lista de palabras relacionadas con aspectos de personalidad. */
    private final Word[] personalities = {
            new Word("Honest", "free from fraud or deception; legitimate, truthful"),
            new Word("Kind", "having or showing a friendly, generous, and considerate nature"),
            new Word("Brave", "having or showing courage; not afraid"),
            new Word("Shy", "being reserved or having or showing nervousness or timidity in the company of other people"),
            new Word("Friendly", "showing kindness or goodwill"),
            new Word("Generous", "showing a readiness to give more of something, as money or time, than is strictly necessary or expected"),
            new Word("Loyal", "giving or showing firm and constant support or allegiance to a person or institution"),
            new Word("Humble", "having or showing a modest or low estimate of one's importance"),
            new Word("Confident", "feeling or showing confidence in oneself; self-assured"),
            new Word("Patient", "able to accept or tolerate delays, problems, or suffering without becoming annoyed or anxious"),
            new Word("Outgoing", "friendly and socially confident"),
            new Word("Responsible", "having an obligation to do something, or having control over or care for someone, as part of one's job or role"),
            new Word("Optimistic", "hopeful and confident about the future"),
            new Word("Pessimistic", "tending to see the worst aspect of things or believe that the worst will happen"),
            new Word("Creative", "relating to or involving the use of the imagination or original ideas to create something"),
            new Word("Ambitious", "having a strong desire for success or achievement"),
            new Word("Polite", "having or showing behavior that is respectful and considerate of other people"),
            new Word("Rude", "offensively impolite or ill-mannered"),
            new Word("Stubborn", "having or showing dogged determination not to change one's attitude or position on something"),
            new Word("Reliable", "consistently good in quality or performance; able to be trusted"),
            new Word("Lazy", "unwilling to work or put in effort"),
            new Word("Energetic", "showing or involving great activity or vitality"),
            new Word("Jealous", "feeling or showing envy of someone or their achievements and advantages"),
            new Word("Caring", "displaying kindness and concern for others"),
            new Word("Arrogant", "having or revealing an exaggerated sense of one's own importance or abilities"),
            new Word("Funny", "causing laughter or amusement; humorous"),
            new Word("Serious", "demanding careful consideration or application"),
            new Word("Intelligent", "having or showing intelligence, especially of a high level"),
            new Word("Talkative", "fond of or given to talking"),
            new Word("Quiet", "making little or no noise")
    };
    /** Lista de palabras relacionadas con defectos en objetos. */
    private final Word[] objectDefects = {
            new Word("Broken", "damaged and no longer in one piece or in working order"),
            new Word("Cracked", "having one or more lines on the surface where something is broken but not completely separated"),
            new Word("Chipped", "having small pieces broken off the edge or surface"),
            new Word("Scratched", "having surface marks caused by scraping or rubbing"),
            new Word("Stained", "marked or discolored by something"),
            new Word("Dented", "having a small hollow mark in the surface caused by pressure or a blow"),
            new Word("Warped", "bent or twisted out of shape"),
            new Word("Rusty", "covered with or affected by rust"),
            new Word("Faded", "having lost color or brightness"),
            new Word("Torn", "ripped or pulled apart"),
            new Word("Loose", "not firmly or tightly fixed in place"),
            new Word("Leaking", "allowing liquid or gas to escape"),
            new Word("Worn", "damaged or impaired through continuous use"),
            new Word("Frayed", "worn at the edges or ends, especially of cloth"),
            new Word("Splintered", "broken into sharp fragments"),
            new Word("Peeling", "coming off in thin layers"),
            new Word("Bent", "shaped or forced out of its natural straight or flat form"),
            new Word("Crushed", "pressed or squeezed with force so as to break or deform"),
            new Word("Blistered", "covered with bubbles on the surface, often from heat or moisture"),
            new Word("Moldy", "covered with or smelling of mold"),
            new Word("Warped", "distorted in shape"),
            new Word("Ripped", "torn forcibly"),
            new Word("Splattered", "covered with drops of a liquid or small particles scattered irregularly"),
            new Word("Smudged", "marked or blurred with dirty or oily marks"),
            new Word("Jagged", "having rough, sharp points"),
            new Word("Corroded", "damaged or destroyed gradually by chemical action"),
            new Word("Pitted", "having small holes or indentations"),
            new Word("Squeaky", "making a short, high-pitched sound, often a sign of wear"),
            new Word("Loose", "not tightly fixed or fastened"),
            new Word("Discolored", "having a change in color, usually undesired")
    };
    /** Lista de palabras relacionadas con negocios. */
    private final Word[] businessWords = {
            new Word("Profit", "the financial gain after all expenses are deducted"),
            new Word("Revenue", "income generated from normal business operations"),
            new Word("Assets", "resources owned by a business that have economic value"),
            new Word("Liabilities", "a company's debts or obligations"),
            new Word("Equity", "the value of ownership interest in a company"),
            new Word("Investment", "allocating money in the expectation of some benefit in the future"),
            new Word("Dividend", "a portion of a company's earnings distributed to shareholders"),
            new Word("Merger", "the combination of two companies into one"),
            new Word("Acquisition", "one company buying most or all of another company's shares"),
            new Word("Stakeholder", "anyone with an interest in the success of a business"),
            new Word("Market share", "the portion of a market controlled by a particular company"),
            new Word("Brand", "a type of product or company identified by a distinctive name or design"),
            new Word("Entrepreneur", "a person who starts and runs a business"),
            new Word("Startup", "a newly established business"),
            new Word("Liability", "legal responsibility for something"),
            new Word("Cash flow", "the total amount of money being transferred into and out of a business"),
            new Word("Budget", "an estimate of income and expenditure for a set period"),
            new Word("Forecast", "a prediction or estimate of future business performance"),
            new Word("Negotiation", "discussion aimed at reaching an agreement"),
            new Word("Partnership", "a business owned by two or more people"),
            new Word("Strategy", "a plan of action to achieve business goals"),
            new Word("Target market", "a particular group of consumers at which a product is aimed"),
            new Word("Revenue stream", "a source of income for a business"),
            new Word("Shareholder", "an owner of shares in a company"),
            new Word("Supply chain", "the sequence of processes involved in production and distribution"),
            new Word("Synergy", "combined effort greater than the sum of individual efforts"),
            new Word("Turnover", "the amount of business conducted during a particular period"),
            new Word("Valuation", "the process of determining the worth of an asset or company"),
            new Word("Wholesale", "selling goods in large quantities at lower prices"),
            new Word("IPO", "Initial Public Offering, when a company sells shares to the public for the first time")
    };
    /** Lista de palabras relacionadas con programación. */
    private final Word[] programmingWords = {
            new Word("Algorithm", "a step-by-step procedure for solving a problem or performing a task"),
            new Word("Array", "a collection of elements identified by index or key"),
            new Word("Boolean", "a data type with two possible values: true or false"),
            new Word("Class", "a blueprint for creating objects, defining their properties and behaviors"),
            new Word("Compilation", "the process of converting source code into executable code"),
            new Word("Constructor", "a special method used to initialize objects"),
            new Word("Debugging", "the process of identifying and fixing errors in code"),
            new Word("Encapsulation", "the bundling of data with the methods that operate on that data"),
            new Word("Exception", "an event that disrupts normal program flow, often an error"),
            new Word("Function", "a named block of code that performs a specific task"),
            new Word("Inheritance", "a mechanism where one class acquires properties and behaviors of another"),
            new Word("Interface", "a contract that defines methods a class must implement"),
            new Word("Loop", "a sequence of instructions that repeats until a condition is met"),
            new Word("Method", "a function defined inside a class"),
            new Word("Object", "an instance of a class"),
            new Word("Parameter", "a variable used to pass information into functions or methods"),
            new Word("Polymorphism", "the ability of different classes to be treated as instances of the same class through inheritance"),
            new Word("Recursion", "when a function calls itself"),
            new Word("Syntax", "the set of rules that defines the structure of code"),
            new Word("Variable", "a storage location identified by a name that holds data"),
            new Word("Abstraction", "the concept of hiding complex implementation details and showing only necessary features"),
            new Word("Binary", "a numbering system using base 2, consisting of 0s and 1s"),
            new Word("Compiler", "a program that translates source code into machine code"),
            new Word("Data structure", "a particular way of organizing and storing data"),
            new Word("Framework", "a platform for developing software applications"),
            new Word("Garbage collection", "automatic memory management that frees unused objects"),
            new Word("IDE", "Integrated Development Environment, a software application for programming"),
            new Word("Library", "a collection of precompiled routines used by programs"),
            new Word("Pointer", "a variable that stores the memory address of another variable"),
            new Word("Stack", "a data structure that follows last-in, first-out (LIFO) order")
    };


}
