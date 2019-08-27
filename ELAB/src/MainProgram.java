// elab-source: MainProgram.java
// elab-mainclass: MainProgram

import java.util.Scanner;
public class MainProgram {
    public static void main(String[] args) {
        // initialize MailBox object


        System.out.println("Welcome to Comsi Condominium");
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Please select menu [I] = insert mail ; [C] = check total mail ; [G] = get mail ; [E] = exit");
            String command = sc.next();
            if(command.toLowerCase().charAt(0) == 'i'){
                System.out.println("Please enter [roomNumber numberOfMail] e.g. 14019 5");

                //do something

            }else if(command.toLowerCase().charAt(0) == 'c'){
                System.out.println("Please enter [roomNumber] e.g. 14019");

                // do something

                // if (something) {
                System.out.println("Total Mail in Your MailBox :  " );
                // }

                // do something
            }else if (command.toLowerCase().charAt(0) == 'g'){
                System.out.println("Please enter [roomNumber] e.g. 14019");

                // do something

            }else if(command.toLowerCase().charAt(0 )== 'e'){
                break;
            }
        }
    }

}

