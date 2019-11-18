import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CommandSystem commandSystem = new CommandSystem();
        while (true) {
            commandSystem.execute(sc.nextLine());
            if (commandSystem.getCommand().equals("exit"))
                break;
            if (commandSystem.getOutput() != null)
                System.out.println(commandSystem.getOutput());
        }
    }
}
