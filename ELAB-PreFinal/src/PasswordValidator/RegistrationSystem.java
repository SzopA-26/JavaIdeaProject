package PasswordValidator;

import java.util.ArrayList;

public class RegistrationSystem {
    private ArrayList<User> userList = new ArrayList<>();
    private PasswordValidator validator;

    public void setPasswordValidator(PasswordValidator validator) {
        this.validator = validator;
    }

    public boolean register(String username ,String password) {
        boolean validate = validator.validate(password);
        if (validate) userList.add(new User(username, password));
        return validate;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
}
