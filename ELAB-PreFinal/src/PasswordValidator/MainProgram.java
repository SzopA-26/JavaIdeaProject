package PasswordValidator;

public class MainProgram {
    public static void main(String[] args) {
        RegistrationSystem regis = new RegistrationSystem();

        regis.setPasswordValidator(new SimpleValidator());
        System.out.println(regis.register("kwan", "abcd")); // print true

        regis.setPasswordValidator(new DigitValidator());
        System.out.println(regis.register("kwan", "abcd")); // print false
        System.out.println(regis.register("kwan", "abcd11"));// print true

    }
}
