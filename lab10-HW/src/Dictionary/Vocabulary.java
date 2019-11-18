package Dictionary;

import java.io.Serializable;

public class Vocabulary implements Serializable {
    private String word;
    private String partOfSpeech;
    private String meaning;
    private String example;

    public Vocabulary(String word, String partOfSpeech, String meaning, String example) {
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.meaning = meaning;
        this.example = example;
    }

    public String getWord() {
        return word;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getExample() {
        return example;
    }
}
