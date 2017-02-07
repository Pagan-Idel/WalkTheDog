package byui.cit260.walkTheDog.view;

import byui.cit260.walkTheDog.control.GameControl;
import byui.cit260.walkTheDog.exceptions.EventsControlException;
import byui.cit260.walkTheDog.exceptions.GameControlException;
import byui.cit260.walkTheDog.model.Player;
import java.util.logging.Level;
import java.util.logging.Logger;
import walkthedog.WalkTheDog;

/**
 *
 * @author Idel and gab James
 */
public class MainMenuView extends View {

    public String hMR = "mMV";
    public Player player;


    public MainMenuView(Player player) {
        super("\n"
            + "\n___________________________"
            + "\nMain Menu"
            + "\n___________________________"
            + "\nN - New Game" 
            + "\nR - Resume saved game" 
            + "\nH - Help Menu"
            + "\nS - Save game " 
            + "\nQ - Exit "
            + "\n___________________________");
            
        this.player = player;
    }
    
    @Override
    public void doAction(char choice) {
        
        switch (choice){
            case 'N': // create and Start a new Game
                this.startNewGame();
                break;
            case 'R': // resume saved game
                this.startExistingGame();
                break;
            case 'H': {
            try {
                // display the Help Menu
                this.displayHelpMenu();
            } catch (EventsControlException ex) {
            ErrorView.display("\nMainMenView", ex.getMessage());
            }
        }
                break;
            case 'S': // save the current Game
                this.saveGame();
                break;
            case 'Q': // Exit the program
                this.quitGame();
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid Selection *** Try Again ***");
                break;
                }
    }
    
    private void startNewGame(){
        try {
            //        this.console.println("\n*** startNewGame function called ***"
//                + "in MainMenuView.java     startNewGame()");
            
            GameControl.createNewGame(WalkTheDog.getPlayer());
        } catch (EventsControlException ex) {
            ErrorView.display("\nMainMenView", ex.getMessage());
        }
        
        
        GameMenuView gameMenu = new GameMenuView(player);
        gameMenu.display(hMR);
    }   
     
    private void startExistingGame(){
//        this.console.println("\n*** startExistingGame function called ***"
//                + "in MainMenuView.java     startExistingGame()");
        // prompt for and get the nameof the file to save the game
        this.console.println("\n\nEnter the file path for the saved game.");
        
        String filePath = this.getInput();
        
        try {
            // start a saved game
            GameControl.getSavedGame(filePath);
            
        } catch (Exception ex) {
            ErrorView.display("\nmainMenuView", ex.getMessage());
        }
        
        // display the game menu
        GameMenuView gameMenu = new GameMenuView(player);
        gameMenu.display(hMR);
    }
    
    private void displayHelpMenu() throws EventsControlException{
        GameControl.createNewGame(WalkTheDog.getPlayer());
        
        HelpMenuView gameMenuHelp = new HelpMenuView();
        gameMenuHelp.displayHelpMenu(hMR,player);
        }
    
    public void saveGame(){
         this.console.println("\n*** saveGame function called ***");
        System.out.println("\n\nEnter the file path for file where the game "
         + "is to be saved.");
        
        String filePath = this.getInput();
        
        try {
            //save the game to the specified file
            GameControl.saveGame(WalkTheDog.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("\nMainMenView", ex.getMessage());
            
        }
        
    }

    private void quitGame() {
        this.console.println("\nThank you for playing!");
        StartProgramView startProgram = new StartProgramView();
        startProgram.startProgram();
    }

    public void youWin(Player player) {

        this.console.println("\nYou Win! Your score was " + player.getPlayerCurrentScore());
        GameControl newHighScore = new GameControl();
        try {
            if(newHighScore.userNewHighScore(player) == true){
                this.console.println("\nCongratulations! New High Score!"
                        + "\nThe new high score is " + player.getHighScore() + " points!");
            }
            
        } catch (GameControlException ex) {
             ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        MainMenuView mainMenu = new MainMenuView(player);
        mainMenu.display(hMR);
    }


}
