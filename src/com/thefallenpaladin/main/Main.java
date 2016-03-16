package com.thefallenpaladin.main;

/**
 * Created by Matthew on 3/15/2016.
 * Made in order to assist
 * P. E.N.A is v.0.1
 * an variable that starts with 'a' is an admin command
 */

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;

public class Main {

    //Input Variables
    Scanner userInput = new Scanner(System.in);

    //IDs
    String[] userPass = {"Pass1"};
    String[] adminPass = {"Command"};

    //Booleans
    boolean mAccess = false;
    boolean tAccess = false;
    boolean mattAcess = false; // not used.
    boolean nExiting = true;
    boolean firstTimeRun = true;
    boolean quiting = false; //TODO Get the program to quit when 'quit is typed.'

    //Ints

    //Double
    double enaCurrentVersion = 0.2;


    public static void main(String[] args) {
        Main main = new Main();
        main.password();
        while(true) {
            main.mLoop();
            if(main.quiting) {
                break;
            }
        }
    }

    public void password() { // A simple password method.
        int passTimesTried = 0;
        System.out.print("Password?: ");
        String passCheck = userInput.nextLine();
        while(passTimesTried < 1) {
            for(int i = 0; i < userPass.length; i++) {
                if(passCheck.equals(userPass[i])) { // Loop through the userInput until an acceptable password is entered
                    mAccess = true;
                    break;
                }
                else if(passCheck.equals(adminPass[i])) {
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
            System.out.println("Hello, My name is Ena.");
            System.out.println("How can I help you?");
            String command = userInput.nextLine();
            if(command.equals("quit")) {
                System.out.println("Thank you, and goodbye.");
            }
        }
        while(tAccess) {
            if(firstTimeRun) {
                System.out.println("Hello, My name is Ena.");
                System.out.println("Type \"help\" for help");
                System.out.println("I have detected that you are an admin. Welcome.");
                System.out.println("How can I help you?");
                firstTimeRun = false;
            } else {
                System.out.println("Anything else?: ");
            }
            String aCommand = userInput.nextLine().toLowerCase();
            if(aCommand.equals("quit")) {
                System.out.println("Thank you, and goodbye");
                quiting = true;
            }
            else if(aCommand.equals("open browser")) {
                if(Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI(
                                "http://www.google.com"
                        ));
                        System.out.println("Alright. Anything else?: ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if(aCommand.equals("check version")) {
                System.out.println("My current version is: " + enaCurrentVersion);
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
            }
        }
    }
}
