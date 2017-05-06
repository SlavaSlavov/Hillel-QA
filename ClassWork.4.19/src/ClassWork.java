import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class ClassWork {

        public static void main( String args[]) {
            class WordData {
                public int getFrequency() {
                    return frequency;
                }

                public void setFrequency(int frequency) {
                    this.frequency = frequency;
                }

                public String getWord() {
                    return word;
                }

                public void setWord(String word) {
                    this.word = word;
                }

                private int frequency = 0;
                private String word;

                public WordData(int frequency, String word) {
                    this.frequency = frequency;
                    this.word = word;
                }

                public void increaseFrequency() {
                    this.frequency = this.frequency + 1;
                }
            }
            HashMap<String, WordData> Words = new HashMap<String, WordData>();
            try {
                File textFile = new File("TextFile.txt");
                Scanner scan = new Scanner(textFile, "UTF-8");
                String word, line;
                WordData wordData;
                String[] wordsOfLine;
                while (scan.hasNext()) {
                    line = scan.nextLine().trim();
                    wordsOfLine = line.split("\\s");

                    for (int i = 0; i < wordsOfLine.length && wordsOfLine[i] != ""; i++) {

                        word = wordsOfLine[i].trim();
                        if (Words.get(word) == null) {
                            wordData = new WordData(1, word);
                            Words.put(word, wordData);
                        } else {
                            wordData = Words.get(word);
                            wordData.increaseFrequency();
                            Words.put(word, wordData);
                        }
                    }
                }
                for (WordData s : Words.values()) {
                    System.out.println(s.getWord() + ": " + s.getFrequency());
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
}