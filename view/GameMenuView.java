/*
 * Project author: gab James.
 * 
 * 
 */
package byui.cit260.walkTheDog.view;

import byui.cit260.walkTheDog.control.MapControl;
import byui.cit260.walkTheDog.control.ExploringControl;
import static byui.cit260.walkTheDog.control.EventsControl.eVcolumCount;
import static byui.cit260.walkTheDog.control.EventsControl.eVrowCount;
import byui.cit260.walkTheDog.control.GameControl;
import byui.cit260.walkTheDog.control.MiniGameControl;
import byui.cit260.walkTheDog.control.ProgramControl;
import byui.cit260.walkTheDog.exceptions.EventsControlException;
import byui.cit260.walkTheDog.exceptions.ExploringControlException;
import byui.cit260.walkTheDog.exceptions.GameControlException;
import byui.cit260.walkTheDog.exceptions.MiniGameControlException;
import byui.cit260.walkTheDog.exceptions.PrintControlException;
import byui.cit260.walkTheDog.exceptions.ProgramControlException;
import byui.cit260.walkTheDog.model.EventsType;
import byui.cit260.walkTheDog.model.Game;
import byui.cit260.walkTheDog.model.Player;
import walkthedog.WalkTheDog;

/**
 *
 * @author gab James
 */
public class GameMenuView extends View {

    public String hMR = "gMV";
    public Player player;


    public GameMenuView(Player players) {

        super("\n"
                + "\n________________________________"
                + "\n"
                + "\nGame Menu"
                + "\n________________________________"
                + "\n"
                + "\n  M   - Move to new location"
                + "\n  E   - Explore location"
                //            + "\n  L   - Estimate leash length"
                + "\n  P   - Play Mini Game"
                + "\n  D   - Display Map"
                + "\n  T   - Game Statistics"
                + "\n  A   - Things in the Park"
                + "\n  V   - Print Map"
                + "\n  H   - Help Menu "
                + "\n  S   - Save game "
                + "\n  Q   - Quit Game without saving"
                + "\n________________________________\n");

        this.player = players;

        this.console.println("\n\nYour current statistics:\n"
//                + player + "\n"
                + "\n"
                + "Your current score is: " + player.getPlayerCurrentScore()
//                + player.getGameDidUserExplore() + "\t=  gameDidUserExplore\n"
//                + player.getGameUserExploreCounter() + "\t=  gameUserExploreCounter\n"
                + "\nFido's mood is now: "+player.getGameFidoMood()
                + "\nNumber of turns: "+player.getWinLose() + " out of 11"
//                + player.getGameIdealLeashLength() + "\t=  gameIdealLeashLength\n"
//                + player.getPlayerLeashLenght() + "\t=  playerLeashLenght\n"
                + "\nYou satisfation level is currently: " +player.getPlayerSatisfaction()
        );
        

    }

    @Override
    public void doAction(char choice) {
        
        

        if (player.playerCurrentScore <= 0) {
            this.console.println("\n\nYour Score is Zero, you loose");
            choice = 'Q';
        }
        ProgramControl check = new ProgramControl();
        try {
            // Check for new High Score
            player.setHighScore(check.checkHighScore(player.getPlayerCurrentScore(), player.getHighScore()));
//            System.err.println("GMV line 90 - High Score returned as "+(check.checkHighScore(player.getPlayerCurrentScore(), player.getHighScore())));
//            System.err.println("\ngame.getHighScore is now = "+player.getHighScore()+"\n");
        } catch (ProgramControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

        switch (choice) {
            case 'M':
                // User moves to location 1
                //    this.displayMap();
                this.visitSceanL();
                break;
            case 'D': // User Displays Map
                this.displayMap();
                break;
            case 'E':
                // User chooses to Explore
                this.userExplore();

                break;
//            case 'L': // User Estimates Leash Length needed
//                this.userLeashLength();
//                break;
            case 'P': // User plays Mini game
                this.createMiniGame(player);   //this needs to be fixed
                break;
            case 'T': // User views userStatistics
                this.userStatistics();
                break;
            case 'A': // User views userStatistics
                this.displayActors();
                break;
            case 'H': // display the Help Menu
                this.displayHelpMenu();
                break;
            case 'V':
                this.printAMap();
                break;
            case 'S': // save the current Game
                this.saveGame();
                break;
            case 'Q': // Exit the game (no save)
                this.quitGame();
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid Selection *** Try Again ***");
                break;
        }
    }

    private void visitSceanL() {
//        this.console.println("*** Move Location function called ***"
//                + "\n Location Menu will be called");

        ExploringControl check = new ExploringControl();
//        Game game = new Game();

        try {
            check.didUserExplore(player);
        } catch (ExploringControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        try {
            check.shortLeash(player);
        } catch (ExploringControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        
        GameControl look = new GameControl();
        try {
            look.didPlayerWin(player);
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        
        player.setGameDidUserExplore('n');                                      // change char gameDidUserExplore back to NO
        player.setPlayedMiniGame('n');
        try {
            player.setWinLose(look.playerWinLose(player.getWinLose()));
        } catch (GameControlException ex) {
             ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

        UserExperienceView question = new UserExperienceView(player);
        question.display(hMR);

    }

    public void userExplore() {
        ExploringControl explore = new ExploringControl();                         // calls random number generator
        try {
            explore.userExploreControl(player);
        } catch (ExploringControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

    }
//
//    private void userLeashLength() {
////        this.console.println("*** userLeashLength function called ***");
//        LeashLengthView leash = new LeashLengthView();
//        player.setPlayerLeashLenght(leash.displayLeashLengthInput());
//
//        ExploringControl check = new ExploringControl();
//        try {
//            check.shortLeash(player);
//        } catch (ExploringControlException ex) {
//            ErrorView.display(this.getClass().getName(), ex.getMessage());
//        }
//    }       // END userLeashLength()

    private void displayHelpMenu() {
        HelpMenuView gameMenuHelp = new HelpMenuView();
        gameMenuHelp.displayHelpMenu(hMR, player);
    }

    private void userStatistics() {
        StatisticsMenuView gameStatistics = new StatisticsMenuView(player);
        gameStatistics.display(hMR);
    }

    private void displayActors() {
//        EventsControl gameEvents = new EventsControl();
        try {
            this.displayEvents();
        } catch (EventsControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }

        public void displayEvents() throws EventsControlException {

        EventsType[][] eventTypes = WalkTheDog.getCurrentGame().getEvent().getEventTypes();

        if (eventTypes == null) {
            throw new EventsControlException("*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in EventsControl.java ***"
                    + "\nin       public void displayEvents() if (eventTypes == null)");
        } else {
            this.console.println("     Events in The Park\n");
            this.console.print("          ");
            this.console.println("     The Park is full of different Events\n"
                    + "They are:           Good (good dog!!!)    and             Bad (bad dog!!!)");

            for (int row = 0; row < eVrowCount; row++) {
                int z = row + 1;
                this.console.print("      " + z);
                for (int column = 0; column < eVcolumCount; column++) {
                    this.console.print(" | ");
                    EventsType eventType = eventTypes[row][column];
                    if (!eventType.equals("")) {
                        this.console.print(eventTypes[row][column].getEventScene().getEventsSymbol());
                    } else {
                        this.console.print("   x      ");                           // place event symbol here
                    }
                }
                this.console.print(" |\n");
            }
        }
    }   // END of public void displayEvents()

    
    
    
    private void saveGame() {
        MainMenuView savedGame = new MainMenuView(player);
        savedGame.saveGame();

    }

    private void quitGame() {
        this.console.println("\nQuiting Game\nSending player back to Main Menu");
        MainMenuView quittingGame = new MainMenuView(player);
        quittingGame.display(hMR);
    }

    private void displayMap() {
        MapControl seeMap = new MapControl();
        seeMap.displayMap();
    }

    private void createMiniGame(Player player) {
        MiniGameControl miniGame = new MiniGameControl();
        try {
            miniGame.createMiniGame(player);   //this needs to be fixed
        } catch (MiniGameControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }

    private void printAMap() {

        try {
            PrintView printTheMap = new PrintView();
            printTheMap.printMap();

            this.console.println("\nfile was saved.\n");
        } catch (PrintControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

    }

}
