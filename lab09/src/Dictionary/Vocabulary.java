package Dictionary;

public class Vocabulary {
    private String word;
    private String partOfSpeech;
    private String meaning;
    private String example;

    public Vocabulary(String word, String partOfSpeech, String meaning) {
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.meaning = meaning;
        this.example = null;
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
        if (example == null) return "";
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String toString() {
        return "[" + partOfSpeech + "]\n" +
                "   - " + meaning + "\n" +
                getExample();

    }
}
