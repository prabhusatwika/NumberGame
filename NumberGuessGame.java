import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int Score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int GuessedNum = random.nextInt(100) + 1; 
            int attemptsTaken = 0;
            int attemptsLeft = 6; 
            boolean guessedCorrectly = false;

            System.out.println("\nA random number is chosen between 1 and 100. Can you guess it?");
            System.out.println("You have " + attemptsLeft + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attemptsTaken++;
                attemptsLeft--;

                if (userGuess == GuessedNum) {
                    System.out.println("Correct! You guessed the number in " + attemptsTaken + " attempts.");
                    Score =Score + (10 - attemptsTaken); // Higher score for fewer attempts
                    guessedCorrectly = true;
                    break;
                } else if (userGuess > GuessedNum) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("all attempts completed! The correct number was: " + GuessedNum);
                }
            }

            System.out.println("\nYour current score: " + Score);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing! Your final score is: " +Score);
        sc.close();
    }
}
