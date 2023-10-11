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
            GetPlayerInput("playerA", 0);
            GetPlayerInput("playerB", 1);

            if (playerInputs[0].equals(playerInputs[1])) {
                System.out.println("It's a tie!");
            } else if (playerInputs[0].equals("R") && playerInputs[1].equals("S")
            || playerInputs[0].equals("P") && playerInputs[1].equals("R")
            || playerInputs[0].equals("S") && playerInputs[1].equals("P")) {
                System.out.println("playerA wins!");
            } else {
                System.out.println("playerB wins!");
            }

            do {
                System.out.println("Would you like to play again? [Y\\N]");

                if (scanner.hasNextLine()) {
                    yn = scanner.nextLine().toUpperCase();

                    if (yn.equals("N")) {
                        gameOver = true;
                        verify = true;
                    } else if (yn.equals("Y")) {
                        verify = true;
                    } else {
                        System.out.printf("Invalid input: \"%s\", please try again.\n", scanner.nextLine());
                    }
                } else {
                    System.out.printf("Invalid input: \"%s\", please try again.\n", scanner.nextLine());
                }
            } while (!verify);
        } while (!gameOver);

    }

    private static void GetPlayerInput(String question, int outputIndex) {
        boolean verify = false;

        do {
            System.out.printf("%s, what is your move? [R/P/S]\n", question);

            if (scanner.hasNextLine()) {
                String move = scanner.nextLine().toUpperCase();

                if (move.equals("R") || move.equals("P") || move.equals("S")) {
                    playerInputs[outputIndex] = move;
                    verify = true;
                } else {
                    System.out.printf("Invalid input: \"%s\", please try again.\n", scanner.nextLine());
                }
            } else {
                System.out.printf("Invalid input: \"%s\", please try again.\n", scanner.nextLine());
            }
        } while (!verify);
    }
}