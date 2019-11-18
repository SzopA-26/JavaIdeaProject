package PasswordValidator;

public class DigitValidator implements PasswordValidator {
    @Override
    public boolean validate(String password) {
        if (password.length() < 6) return false;
        int digitCount = 0;
        for (Character c : password.toCharArray())
            if (Character.isDigit(c)) digitCount++;
        return digitCount > 0;
    }
}
