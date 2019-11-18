package Dictionary;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, Vocabulary> dictionary;

    public Dictionary() {
        this.dictionary = new HashMap<>();
    }

    public void addWord(String word, Vocabulary vocabulary) {
        if (!dictionary.containsKey(word.toLowerCase()))
            dictionary.put(word.toLowerCase(), vocabulary);
    }

    public Vocabulary getVocabulary(String vocab) {
        return dictionary.get(vocab);
    }

    public HashMap<String, Vocabulary> getDictionary() {
        return dictionary;
    }

    public void deleteWord(String word) {
        if (dictionary.containsKey(word))
            dictionary.remove(word);
    }
}
