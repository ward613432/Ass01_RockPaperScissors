import java.util.Scanner;

public class Main {
    static String[] playerInputs = new String[2];
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        boolean gameOver = false;
        boolean verify = false;
        String yn = "";

        do {
            playerInputs[0] = GetPlayerInput("playerA, what is your move? [R/P/S]", "RPS");
            playerInputs[1] = GetPlayerInput("playerB, what is your move? [R/P/S]", "RPS");

            if (playerInputs[0].equals(playerInputs[1])) {
                System.out.println("It's a tie!");
            } else if (playerInputs[0].equals("R") && playerInputs[1].equals("S")
            || playerInputs[0].equals("P") && playerInputs[1].equals("R")
            || playerInputs[0].equals("S") && playerInputs[1].equals("P")) {
                System.out.println("playerA wins!");
            } else {
                System.out.println("playerB wins!");
            }

            yn = GetPlayerInput("Would you like to play again? [Y/N]", "YN");
            if (yn.equals("N")) {
                gameOver = true;
            }
        } while (!gameOver);

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