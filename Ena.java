//Because Science
/**
 * Created by Matthew && HerbGlitch on 3/15/2016.
 * Made in order to assist
 * E.N.A is v.0.1
 * an variable that starts with 'a' is an admin command
 */

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;

public class Ena {

    /**BTW got quitting working */
    //Input Variables //nice
    private Scanner userInput = new Scanner(System.in);

    //IDs //got them working
    String[] userName = {"basicUser1"};
    String[] aUserName = {"thefallepaladin", "madamson8"};
    String[] userPass = {"Pass1"};
    String[] adminPass = {"Command", "ninja242424"};

    //Booleans
    boolean mAccess = false;
    boolean tAccess = false;
    boolean mAccess2 = false;
    boolean tAccess2 = false;
    boolean mattAcess = false; // WOW... REAL MATURE
    boolean nExiting = true; //what is this for?
    boolean firstTimeRun = true;
    boolean StartoutExplain = false;// same as firstTimeRun, except for mAccess

    //Ints //Why no ints?

    //Double
    double enaCurrentVersion = 0.4; //TODO Update if you create a substantial update

    //Static Variables
    private static int User_number = 0;

    //Class
    Calculator calc = new Calculator();
    EnaGames enaGames = new EnaGames();

    public static void main(String[] args) {
        User_number++;
        //Todo find out if this works
        if(User_number < 5) {
            //System.out.println(User_number);
            Ena ena = new Ena();
            ena.password();
            ena.mLoop();
        }
        else{
            System.out.println("You have too many Instances of Me open, please close one to open another");
        }
    }

    public void password() { // A simple password method.
        int passTimesTried = 0;
//        System.out.print("Username?: "); //Beginning of username enter //TODO!!!!!!!!!!
//        String userCheck = userInput.nextLine();
//        while (passTimesTried < 1) {
//            for(int i = 0; i < userName.length; i++) {
//                if(userCheck.equals(userName[i])) {
//                    mAccess2 = true;
//                    break;
//                }
//            }
//            for(int i = 0; i < aUserName.length; i++) {
//                if(userCheck.equals(userPass[i])) {
//                    tAccess2 = true;
//                    break;
//                }
//            }
//        }

        System.out.print("Password?: "); //Beginning of password enter
        String passCheck = userInput.nextLine();
        while(passTimesTried < 1) {
            for(int i = 0; i < userPass.length; i++) {
                if(passCheck.equals(userPass[i])) { // Loop through the userInput until an acceptable password is entered
                    mAccess = true;
                    break;
                }
            }
            for (int i = 0; i < adminPass.length; i++) {
                if(passCheck.equals(adminPass[i])) {
                    tAccess = true;
                    break;
                }
            }
            if(mAccess || tAccess) {
                break;
            }
            System.out.println("Incorrect");
            passTimesTried += 1;
        }
    }

    public void mLoop() { // This is the main loop

        while(mAccess) {

            if(StartoutExplain) {
                System.out.println("Hello, My name is Ena.");
                StartoutExplain = false;
            }
            System.out.println("How can I help you: ");
            String command = userInput.nextLine();
            if(command.equals("quit")) {
                System.out.println("Thank you, and goodbye.");
                mAccess = false;
                break;
            }
        }
        while(tAccess) {
            if(firstTimeRun) {
                System.out.println("Hello, My name is Ena.");
                System.out.println("Type \"help\" for help");
                System.out.println("I have detected that you are an admin. Welcome.");
                System.out.println("How can I help you: ");
                firstTimeRun = false;
            } else {
                System.out.println("Anything else?: ");
            }
            String aCommand = userInput.nextLine().toLowerCase();
            if(aCommand.equals("quit")) {
                System.out.println("Thank you, and goodbye");
                tAccess = false;
                break;
            }
            else if(aCommand.equals("open browser")) {
                if(Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI(
                                "http://www.google.com"
                        ));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if(aCommand.equals("check version")) {
                System.out.println("My current version is: " + enaCurrentVersion);
            } else if(aCommand.equals("calculator") || aCommand.equals("calculator add") ||
                    aCommand.equals("calculator times") || aCommand.equals("calculator subtract") ||
                    aCommand.equals("calculator divide")){
                calc.calculatorPerformed(aCommand);
            }
            else if(aCommand.equals("credits")) {
                System.out.println("Huge thanks to the main programmers,\n" +
                        "Matthew Adamson and Heber Brau\n" +
                        "It wouldn't have been possible without them");
            }
            else if(aCommand.equals("help")) {
                System.out.println("Here is what I can do: ");
                System.out.println("Type \"Quit\" to quit.");
                System.out.println("Type \"Open Browser\" To open the default browser.");
                System.out.println("Type \"check version\" to check your current version. ");
                System.out.println("Type \"credits\" To view the credits.");
                System.out.println("Type \"Calculator\" To access the calculator");
                System.out.println("Type \"Hangman\" to play Hangman");
                System.out.println("Type \"rps\" to play Rock Paper Scissors");
            } else if(aCommand.equals("rps")) {
                enaGames.RockPaperScissors();
            }
            else if(aCommand.equals("hangman")) {
                enaGames.Hangman();
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}