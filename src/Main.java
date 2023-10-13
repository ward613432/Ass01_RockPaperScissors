import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            String playerA = GetPlayerInput("playerA, what is your move? [R/P/S]", "RPS");
            String playerB = GetPlayerInput("playerB, what is your move? [R/P/S]", "RPS");

            if (playerA.equals(playerB)) {
                System.out.println("It's a tie!");
            } else if (playerA.equals("R") && playerB.equals("S")
            || playerA.equals("P") && playerB.equals("R")
            || playerA.equals("S") && playerB.equals("P")) {
                System.out.println("playerA wins!");
            } else {
                System.out.println("playerB wins!");
            }

            if (GetPlayerInput("Would you like to play again? [Y/N]", "YN").equals("N")) {
                break;
            }
        }
    }

    private static String GetPlayerInput(String question, String answers) {
        do {
            System.out.println(question);
            if (scanner.hasNextLine()) {
                String move = scanner.nextLine().toUpperCase();

                if (answers.toUpperCase().contains(move)) {
                    return move;
                } else {
                    System.out.printf("Invalid input: \"%s\", please try again.\n", move);
                }
            }
        } while (true);
    }
}