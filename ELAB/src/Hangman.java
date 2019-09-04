//elab-source:Hangman.java

public class Hangman implements GuessingGame {
    private String ans;
    private char[] guess;
    private int life;
    private boolean isWin;
    private boolean isLose;
    private boolean inputError;

    @Override
    public void setAnswer(String ans) {
        this.ans = ans.toLowerCase();
        life = 6;
        isWin = false;
        isLose = false;
        guess = new char[ans.length()];
        for (int i=0;i<ans.length();i++)
            guess[i] = '_';
        inputError = false;
    }

    @Override
    public void guess(String s) {
        if (s.length() == 1) {
            inputError = false;
            boolean incorrect = true;
            for (int i=0;i<ans.length();i++) {
                if (ans.charAt(i) == s.charAt(0) && guess[i] == '_') {
                    guess[i] = ans.charAt(i);
                    incorrect = false;
                }
            } if (incorrect) life--;
            if (life <= 0) isLose = true;
            if (getGuess().equals(ans)) isWin = true;
        } else inputError = true;
    }

    @Override
    public String getOutput() {
        if (inputError)
            return "One character only";
        String out = "";
        for (int i=0;i<guess.length;i++)
            out += guess[i]+" ";
        return out;
    }

    @Override
    public boolean isWon() {
        return isWin;
    }

    @Override
    public boolean isLost() {
        return isLose;
    }

    private String getGuess() {
        String g = "";
        for (char i : guess)
            g += i;
        return g;
    }

}
