import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;
        int roundsPlayed = 0;
        final int maxRounds = 3;

        while (roundsPlayed < maxRounds) {
            System.out.println("\n<-------->");
            System.out.println("Round " + (roundsPlayed + 1) + "/" + maxRounds);
            System.out.println("<-------->\n");
            if (playRound(random, scanner)) {
                roundsWon++;
            }
            roundsPlayed++;

            if (roundsPlayed < maxRounds) {
                System.out.print("\nDo you want to play another round? (yes/no): ");
                String playAgain = scanner.next().trim().toLowerCase();
                if (!playAgain.equals("yes")) {
                    break;
                }
            }
        }
        System.out.println("\n<------------------------------------->");
        System.out.println("Game Over! You won " + roundsWon + " out of " + roundsPlayed + " rounds.");
        System.out.println("<------------------------------------->\n");
    }

    private static boolean playRound(Random random, Scanner scanner) {
        int targetNumber = random.nextInt(100) + 1;
        int attempts = 0;
        final int maxAttempts = 5;

        System.out.println("Guess the number between 1 and 100.\n");
        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": ");
            int guess = scanner.nextInt();
            if (guess > 100 || guess < 1) {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
                continue;
            }
            attempts++;

            if (guess < targetNumber) {
                System.out.println("Too low.");
            } else if (guess > targetNumber) {
                System.out.println("Too high.");
            } else {
                System.out.println("\nCongratulations! You guessed the number in " + attempts + " attempts.");
                return true;
            }
        }

        System.out
                .println("\nSorry, you've used all " + maxAttempts + " attempts. The number was " + targetNumber + ".");
        return false;
    }
}
