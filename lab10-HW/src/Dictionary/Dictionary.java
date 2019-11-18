package Dictionary;

import java.io.Serializable;
import java.util.HashMap;

public class Dictionary implements Serializable {
    private HashMap<String ,Vocabulary> dictionary = new HashMap<>();

    public String format(MyFormatter format) {
        return format.format(dictionary);
    }

    public HashMap<String, Vocabulary> getDictionary() {
        return dictionary;
    }

    public void addWord(Vocabulary vocabulary) {
        dictionary.remove(vocabulary.getWord().toLowerCase());
        dictionary.put(vocabulary.getWord().toLowerCase(), vocabulary);
    }

    public Vocabulary getWord(String word) {
        return dictionary.get(word.toLowerCase());
    }
}