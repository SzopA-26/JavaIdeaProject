package Dictionary;

import java.util.ArrayList;

public class Dictionary {
    ArrayList<Vocabulary> vocabList = new ArrayList<>();

    public void add(Vocabulary vocabulary) {
        vocabList.add(vocabulary);
    }

    public String search(String vocab) {
        for (Vocabulary vocabulary : vocabList) {
            if (vocabulary.getName().equals(vocab))
                return vocabulary.toString();
        } return "Not found \"" + vocab + "\" in Dictionary.Dictionary";
    }

    public int getSize() {
        return vocabList.size();
    }
}
