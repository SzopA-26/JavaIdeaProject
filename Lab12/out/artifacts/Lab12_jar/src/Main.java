import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Athlete> athletes = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            try {
                File file = new File(args[i]);
                FileReader fileReader = new FileReader(file);
                BufferedReader buffer = new BufferedReader(fileReader);
                String name = buffer.readLine();
                athletes.add(new Athlete(name));
                String line;
                for (int j = 0; j < 3; j++) {
                    BowlingScores bowlingScores = new BowlingScores();
                    while ((line = buffer.readLine()) != null && bowlingScores.getRound() < 10) {
                        if (line.contains(",")) {
                            int score1 = Integer.parseInt(line.split(",")[0]);
                            int score2 = Integer.parseInt(line.split(",")[1]);
                            bowlingScores.addScores(score1, score2);
                        } else {
                            bowlingScores.addScores(10, 0);
                        }
                    }
                    athletes.get(i).addScores(bowlingScores);
                }
            } catch (FileNotFoundException e) {
                System.err.println("File " + args[i] + "not found.");
            } catch (IOException e) {
                System.err.println("Read file error.");
            }

        }

        while (true) {
            System.out.println("Please enter input (E,A,B,C):");
            Scanner sc = new Scanner(System.in);
            char input = sc.next().charAt(0);
            Point point;
            if (input == 'E') {
                System.out.println("Exit program.");
                return;
            } else if (input == 'A') {
                point = new HighScore();
            } else if (input == 'B') {
                System.out.println("Please input weight scores:");
                point = new WeightScore(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            } else if (input == 'C') {
                point = new StrikeScore();
            } else {
                System.out.println("Input error.");
                continue;
            }

            athletes.sort(new SortPlayerPoint(point));
            for (Athlete athlete : athletes) {
                System.out.println(athlete.getName() + " " + point.getPoint(athlete));
            }
        }
    }
}
