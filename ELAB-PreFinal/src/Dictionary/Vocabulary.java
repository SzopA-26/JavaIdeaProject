package Dictionary;

public class Vocabulary {
    private String name;
    private String meaning;
    private String partOfSpeech;

    public Vocabulary(String name,
                      String partOfSpeech, String meaning) {
        this.name = name;
        this.meaning = meaning;
        this.partOfSpeech = partOfSpeech;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "\"" + name + "\"" + " [" + partOfSpeech + "] - " + meaning;
    }
}