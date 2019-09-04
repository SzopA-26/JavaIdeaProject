//elab-source:WordMatch.java

public class WordMatch implements GuessingGame{
    private String ans;
    private int match;
    private boolean win;
    @Override
    public void setAnswer(String ans) {
        this.ans = ans;
    }

    @Override
    public void guess(String s) {
        if (s.length() != ans.length())
            match = -1;
        else {
            match = 0;
            for (int i=0;i<ans.length();i++) {
                if (Character.toLowerCase(ans.charAt(i)) == Character.toLowerCase(s.charAt(i)))
                    match++;
            } if (match == ans.length())
                win = true;
        }
    }

    @Override
    public String getOutput() {
        if (match < 0) return "Length not match";
        return "Match " + match;
    }

    @Override
    public boolean isWon() {
        return win;
    }

    @Override
    public boolean isLost() {
        return false;
    }
}
