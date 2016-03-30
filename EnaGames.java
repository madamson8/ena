import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

/**
 * Created by Matthew on 3/22/2016.
 */
public class EnaGames {

    //Create a simple hangman game.
    private Scanner userInput = new Scanner(System.in);
    String[] hangmanWords = {"Hello", "Awesome", "Purple","Additives","King","Monarchy","Democracy","Republic","Presidents"};
    public int randomWord = ThreadLocalRandom.current().nextInt(hangmanWords.length);
    int compAnswer = ThreadLocalRandom.current().nextInt(3+1);

    public void Hangman() {
        String[] manHang = {"  ____________  "
                         +"\n  |          |  "
                         +"\n             |  "
                         +"\n             |  "
                         +"\n             |  "
                         +"\n             |  "
                         +"\n             |  "
                         +"\n  --------------"
                         +"\n Letters Missed: ",
                            "  ____________  "
                         +"\n  |          |  "
                         +"\n  0          |  "
                         +"\n             |  "
                         +"\n             |  "
                         +"\n             |  "
                         +"\n             |  "
                         +"\n  --------------",
                           "  ____________  "
                        +"\n  |          |  "
                        +"\n  0          |  "
                        +"\n /           |  "
                        +"\n             |  "
                        +"\n             |  "
                        +"\n             |  "
                        +"\n  --------------",
                           "  ____________  "
                        +"\n  |          |  "
                        +"\n  0          |  "
                        +"\n /|          |  "
                        +"\n             |  "
                        +"\n             |  "
                        +"\n             |  "
                        +"\n  --------------",
                           "  ____________  "
                        +"\n  |          |  "
                        +"\n  0          |  "
                        +"\n /|\\         |  "
                        +"\n             |  "
                        +"\n             |  "
                        +"\n             |  "
                        +"\n  --------------",
                           "  ____________  "
                        +"\n  |          |  "
                        +"\n  0          |  "
                        +"\n /|\\         |  "
                        +"\n /           |  "
                        +"\n             |  "
                        +"\n             |  "
                        +"\n  --------------",
                           "  ____________  "
                        +"\n  |          |  "
                        +"\n  0          |  "
                        +"\n /|\\         |  "
                        +"\n / \\         |  "
                        +"\n             |  "
                        +"\n             |  "
                        +"\n  --------------"};
        System.out.println(" H A N G M A N  ");
        boolean hasGessed = false;
        while(!hasGessed) {
            System.out.println("What word do you think it is?: ");
            String wordGuess = userInput.nextLine();
            if(wordGuess.equals(hangmanWords[randomWord])) {
                System.out.println("You got it!");
                hasGessed = true;
            } else {
                System.out.println("Try again.");
            }
        }
    }
    public void RockPaperScissors() { //TODO Get it so that it gets a random number every time that you play a new game of rps
        boolean playerWon = false; //TODO in the same run.
        boolean compWon = false;
        System.out.println("Rock, Paper, or Scissors?");
        String rpsCheck = userInput.nextLine().toLowerCase();
        int answer = 0;
        switch (rpsCheck) {
            case "rock":
                answer = 1;
                break;
            case "paper":
                answer = 2;
                break;
            case "scissors":
                answer = 3;
                break;
            default:
                System.out.println("Invalid.");
                break;
        }
        if(compAnswer == 0) {
            compAnswer = 1;
        }
        if(compAnswer ==  answer) { //1 is rock, 2 is paper, 3 is scissors
            System.out.println("Tie.");
        } else if(compAnswer == 1 && answer == 2) {
            System.out.println("You won!");
            playerWon = true;
        } else if(compAnswer == 2 && answer == 1) {
            System.out.println("You lose.");
            compWon = true;
        } else if(compAnswer == 1 && answer == 3) {
            System.out.println("You lose.");
            compWon = true;
        } else if(compAnswer == 3 && answer == 1) {
            System.out.println("You won!");
            playerWon = true;
        } else if(compAnswer == 2 && answer == 3) {
            System.out.println("You won!");
            playerWon = true;
        } else if(compAnswer == 3 && answer == 2) {
            System.out.println("You lose.");
            compWon = true;
        }
    }
}