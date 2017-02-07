package byui.cit260.walkTheDog.view;

import byui.cit260.walkTheDog.model.Player;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import walkthedog.WalkTheDog;

public class HelpMenuView {

    public String hMR = " ";
    public Player player;
    protected final BufferedReader keyboard = WalkTheDog.getInFile();
    protected final PrintWriter console = WalkTheDog.getOutFile();

    /*    public int playerSatisfaction;
     public int playerLeashLenght;
     public int gameIdealLeashLength;
     public int gameNumberOfTurns;
     public int gameFidoMood;
     public int gameUserExploreCounter;
     public char gameDidUserExplore;
     public int playerCurrentScore;   
     */
    private final String HELPMENU = "\n"
            + "\n___________________________"
            + "\nHelp Menu"
            + "\n___________________________"
            + "\n"
            + "\nGetting Help\n"
            + "\nUse the following menu for Help\n"
            + "\nG - What is the Goal of the game?"
            + "\nM - How to move"
            + "\nL - Leash Lenght control"
            + "\nF - Fido's attitude"
            + "\nS - Save or Resume saved game"
            + "\nQ - Quit Help Menu"
            + "\n\n___________________________";

    public void displayHelpMenu(String returnTO, Player player) {

        this.hMR = returnTO;
        this.player = player;

        char selection = ' ';
        do {

            this.console.println(HELPMENU); // display the main menu

            String input = this.getInput(); // get first charecter of string
            selection = input.charAt(0);
            this.doAction(selection);

        } while (selection != 'Q' || selection != 'q'); // a selection is not "Exit"
    }

    public String getInput() {
        boolean valid = false;
        String playersInput = null;

        try {
            while (!valid) {

                this.console.println("Enter a Help Menu choice below:");

                playersInput = this.keyboard.readLine();
                playersInput = playersInput.trim();

                if (playersInput.length() < 1) {
                    ErrorView.display(this.getClass().getName(),
                            "Invalid entry - space is not an option");
                    continue;
                }
                break;
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(),
                    "Error reading inputL " + e.getMessage());
        }
        return playersInput;
    }

    public void doAction(char choice) {

        switch (choice) {
            case 'G': // goal of Game
                this.goalGameHelp();
                break;
            case 'g': // goal of Game
                this.goalGameHelp();
                break;
            case 'M': // How to move
                this.moveGameHelp();
                break;
            case 'm': // How to move
                this.moveGameHelp();
                break;
            case 'L': // eash Lenght control
                this.leashControlHelp();
                break;
            case 'l': // eash Lenght control
                this.leashControlHelp();
                break;
            case 'F': // Fido's attitude
                this.fidoAttitudeHelp();
                break;
            case 'f': // Fido's attitude
                this.fidoAttitudeHelp();
                break;
            case 'S': // Save or Resume saved game
                this.saveResumeGameHelp();
                break;
            case 's': // Save or Resume saved game
                this.saveResumeGameHelp();
                break;
            case 'Q': // Exit the program
                this.helpQuitAndReturn(hMR);
            case 'q': // Exit the program
                this.helpQuitAndReturn(hMR);
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid Selection *** Try Again ***");
                break;
        }
    }

    private void goalGameHelp() {
//        this.console.println("*** goalGameHelp function called ***");
        this.console.println(
                "\nIt seems your dog is too excited, he needs to be controlled! "
                + "\nThe goal of the game is to get out of the park, without your "
                + "\ndog turning into a bad dog. Keep the leash too short for too "
                + "\nlong and your dog will become increasingly annoyed. The more "
                + "\naggravated your dog becomes the more likely it will bite an "
                + "\nadult, a child, or another dog, ending your game immediately! "
                + "\nWatch out for “landmines” too, because there are irresponsible "
                + "\ndog owners in the park as well. ");

    }

    private void moveGameHelp() {
//        this.console.println("*** moveGameHelp function called ***");
        this.console.println(
                "\nTo move location select M in the game menu and select which location"
                + " you would like to move to!");
    }

    private void leashControlHelp() {
//        this.console.println("*** leashControlHelp function called ***");
        this.console.println(
                "\nRetract or extend your Dog’s leash in order to avoid these "
                + "\nincidents! If incidents happen, say bye-bye to some of your "
                + "\nlife-points! Explore the park to find the exit quickly but "
                + "\ndon’t leave too hastily; your dog needs it’s exercise. Have a "
                + "\ngreat time but be careful so you and your dog don’t get "
                + "\nkicked out of the park! ");
    }

    private void fidoAttitudeHelp() {
//        this.console.println("*** fidoAttitudeHelp function called ***");
        this.console.println(
                "\nFido has a great attitude as long as it can run and play. The "
                + "\nplayer keeps the leash too short (less than 4 feet) for too "
                + "\nmany moves in a row. The computer calculates a negative random "
                + "\nevent (bark, bite, mark owner, pull against leash). If a random "
                + "\nevent is triggered the players pet generates a negative random "
                + "\nevent the counter is decreased to minimum (10%), if a negative "
                + "\nevent in not triggered the computer increases the chance by 10% "
                + "\nfor each move the leash is too short.");
    }

    private void saveResumeGameHelp() {
//        this.console.println("*** saveResumeGameHelp function called ***");
        this.console.println(
                "\nTo save a game, select S in the Game Menu or Main Menu"
                + " and enter a complete file path. \nExample: G:\filename.txt");
    }

    public void helpQuitAndReturn(String returnTO) {

        MainMenuView mmvGame = new MainMenuView(player);
        GameMenuView gmvGame = new GameMenuView(player);
        StatisticsMenuView smvGame = new StatisticsMenuView(player);
        LocationView lvGame = new LocationView(player);

        switch (returnTO) {
            case "gMV":
                this.console.println("\n\nYou chose Quit\nSending Player back to Game Menu");
                hMR = " ";
                gmvGame.display(hMR);
                break;
            case "mMV":
                this.console.println("\n\nYou chose Quit\nSending Player back to Main Menu");
                hMR = " ";
                mmvGame.display(hMR);
                break;
            case "sMV":
                this.console.println("\n\nYou chose Quit\nSending Player back to Statistics Menu");
                hMR = " ";
                smvGame.display(hMR);
                break;
            case "LV":
                this.console.println("\n\nYou chose Quit\nSending Player back to Location Menu");
                hMR = " ";
                lvGame.display(hMR);
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nOur apologies, there was an error in\n"
                        + "helpQuitAndReturn(String returnTO)\n"
                        + "\nSending Player back to Main Menu\n"
                        + returnTO + " returnTO");
                hMR = " ";
                mmvGame.display(hMR);
                break;
        }

    }
}
