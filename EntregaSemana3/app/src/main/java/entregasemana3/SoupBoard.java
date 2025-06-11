package entregasemana3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SoupBoard {
    private final char[][] lettersArray;
    private final Word[] words;
    private final Map<String,int[]> wordCoordinates;
    private final Map<Character, LinkedList<int[]>> lettersMap= new HashMap<>();
    private final char nullChar = '\u0000';
    private int span = 4;

    public SoupBoard(Word[] wordsList){
        int maxNumberOfLetters = 0;
        words = wordsList;
        for (Word word : words) {
            if (maxNumberOfLetters < word.getLetters().length)  {maxNumberOfLetters = word.getLetters().length;} ;
        }
        lettersArray = new char[maxNumberOfLetters+span][maxNumberOfLetters+span];
        wordCoordinates =new HashMap<>();
    }

    private char getCharByCoordinate(int row, int column) {
        return lettersArray[row][column];
    }

    private int[][] generateWordLocation(Word word) {
        int randomDirection;
        int[][] coordinates = new int[word.getLetters().length][2];
        LinkedList<Integer> possibleDirections = new LinkedList<>();
        for (int i=0; i<10;i++){
            int[] initialPosition = {
                    (int) Math.round(Math.random() * (lettersArray.length - 1)),
                    (int) Math.round(Math.random() * (lettersArray.length - 1))
            };
    //        int[] initialPosition = {9,4};
            if (initialPosition[0] + (word.getLetters().length) < lettersArray.length) {
                possibleDirections.add(1);
            }
            if (initialPosition[0] - (word.getLetters().length)  >= 0) {
                possibleDirections.add(2);
            }

            if (initialPosition[1] + (word.getLetters().length) < lettersArray.length) {
                possibleDirections.add(3);
            }
            if (initialPosition[1] - (word.getLetters().length) >= 0) {
                possibleDirections.add(4);
            }
            if (possibleDirections.size() > 1) {
                randomDirection = possibleDirections.get((int) (Math.random() * (possibleDirections.size())));
                coordinates = coordinatesByDirection(initialPosition, word.getLetters().length, randomDirection);
                int[] wordStartEndPosition = {
                        coordinates[0][0],
                        coordinates[0][1],
                        coordinates[word.getLetters().length - 1][0],
                        coordinates[word.getLetters().length-1][1],
                        randomDirection
                };
                wordCoordinates.put(word.getKeyword(), wordStartEndPosition);
                break;
            }
        }
        return coordinates;
    }

    public void setWordLocation(Word word){
        int x, y, counter;
        int[][] wordLocations = new int[word.getLetters().length][2];
        boolean isLocationNotFound = true; 

        while(isLocationNotFound){
            counter = 0;
            wordLocations = generateWordLocation(word);
            for(int i=0; i<wordLocations.length; i++){
                x = wordLocations[i][0];
                y = wordLocations[i][1];
                if (lettersArray[x][y] != nullChar && lettersArray[x][y] != word.getLetters()[i]){
                    break;
                }
                counter++;
            }
            if (counter == word.getLetters().length){
                isLocationNotFound = false;
            }
        }
        for(int i=0; i<word.getLetters().length; i++){
            lettersMap.computeIfAbsent(word.getLetters()[i], k -> new LinkedList<>());
            lettersMap.get(word.getLetters()[i]).add(wordLocations[i]);
            lettersArray[wordLocations[i][0]][wordLocations[i][1]] = word.getLetters()[i];

        }

    }

    private int[][] coordinatesByDirection(int[] initialCoor, int lengthOfWord, int direction) {
        int[][] coordinates = new int[lengthOfWord][2];

        for (int i=0; i < lengthOfWord; i++){
            switch (direction) {
                case 1:
                    coordinates[i][0] = initialCoor[0] + i;
                    coordinates[i][1] = initialCoor[1];
                    continue;
                case 2:
                    coordinates[i][0] = initialCoor[0] - i;
                    coordinates[i][1] = initialCoor[1];
                    continue;
                case 3:
                    coordinates[i][0] = initialCoor[0];
                    coordinates[i][1] = initialCoor[1] + i;
                    continue;
                case 4:
                    coordinates[i][0] = initialCoor[0];
                    coordinates[i][1] = initialCoor[1] - i;
                    continue;
                case 5:
                    coordinates[i][0] = initialCoor[0] + i;
                    coordinates[i][1] = initialCoor[1] + i;
                    continue;
                case 6:
                    coordinates[i][0] = initialCoor[0] + i;
                    coordinates[i][1] = initialCoor[1] - i;
                    continue;
                case 7:
                    coordinates[i][0] = initialCoor[0] - i;
                    coordinates[i][1] = initialCoor[1] + i;
                    continue;
                case 8:
                    coordinates[i][0] = initialCoor[0] - i;
                    coordinates[i][1] = initialCoor[1] - i;
            }
        }
        return coordinates;
    }

    public void printBoard(){
        for (char[] chars : lettersArray) {
            for (int j = 0; j < lettersArray.length; j++) {
                System.out.print(chars[j] == nullChar ? '.' : chars[j]);
            }
            System.out.println();
        }

    }

    public Word[] getWords(){
        return words;
    }

    public void generateSoupBoard(Word[] words) {
        for(Word word : words){
            setWordLocation(word);
        }
    }

    public LinkedList<Word> getFoundWords(){
        LinkedList<Word> foundWords = new LinkedList<>();
        for(Word word: words) {
            if (word.isFound()){
                foundWords.add(word);
            }
        }
        return foundWords;
    }

    public void markWordAsFound(Word wordInSoup){
        for(Word word: words) {
            if (wordInSoup.getKeyword() == word.getKeyword()){
                word.setAsFound();
            }
        }
    }

    public int[] getWordLocation(Word word){
        return wordCoordinates.get(word.getKeyword());
    }



}
