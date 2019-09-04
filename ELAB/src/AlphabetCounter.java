//elab-source:AlphabetCounter.java

import java.util.ArrayList;

public class AlphabetCounter {
    private ArrayList<String> sentence;

    public AlphabetCounter() {
        this.sentence = new ArrayList<>();
    }

    public void addSentence(String sentence) {
        this.sentence.add(sentence);
    }

    public int countAlphabet(char ch) {
        int count = 0;
        for (String i : sentence) {
            for (char j : i.toLowerCase().toCharArray()) {
                if (Character.toLowerCase(ch) == j)
                    count++;
            }
        }
        return count;
    }
}
