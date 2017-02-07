/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.walkTheDog.view;

import byui.cit260.walkTheDog.control.ProgramControl;
import byui.cit260.walkTheDog.exceptions.ExploringControlException;
import byui.cit260.walkTheDog.exceptions.ProgramControlException;
import byui.cit260.walkTheDog.model.Player;

/**
 *
 * @author Idel
 */
public class StatisticsMenuView extends View {

    public String hMR = "sMV";
    public Player player;

    public StatisticsMenuView(Player player) {

        super("\n"
                + "\n________________________________"
                + "\nStatistics Menu"
                + "\n________________________________"
                + "\n  S - Current Score"
                + "\n  M - Fido's Mood"
                + "\n  Q - Quit (Go Back) " // modified to Q so that it could be inherited 
                + "\n________________________________");

        this.player = player;
    }

    @Override
    public void doAction(char choice) {

        switch (choice) {

            /* Instructor: 
             * A better solution is to use the String uppercase() function to
             * always convert the choice into an upper case letter. That way
             * you do not need to check for both upper and lower case letters.
             */
            /* Idel:
             *  Will do this! Thank you. 
             */
            case 'S': // User chooses to display Life points
                this.lifePoint(player);
                break;
            case 's': // User chooses to display Life points
                this.lifePoint(player);
                break;
            case 'M': {
                try {
                    // user chooses to display fido's mood
                    this.generateFidoMood(player);
                } catch (ExploringControlException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                }
            }
            break;
            case 'm': {
                try {
                    // user chooses to display fido's mood
                    this.generateFidoMood(player);
                } catch (ExploringControlException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                }
            }
            break;
            case 'Q': // modified to Q so that it can be inherited
                this.back();
                break;
            case 'q': // modified to q so that it can be inherited
                this.back();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid Selection *** Try Again ***");
                break;
        }
    }

    /* Instructor: 
     * Create and call a stub functions in the appropriate 
     * Control Layer class for the action associated with each of these 
     * functions. The Control Layer is responsible for performaing all 
     * actions of the game.
     */
    /*Idel:
     * Will do thanks!
     */

    private void lifePoint(Player player) {     //display the player's Life Points
        ProgramControl display = new ProgramControl();
        try {
            this.console.println("Your current score is: " + display.playerLifePoints(player));
        } catch (ProgramControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }

    // fixed to return from Player player
    private void generateFidoMood(Player player) throws ExploringControlException {

        ProgramControl display = new ProgramControl();

        try {
            this.console.println("Fido mood is " + display.fidoMood(player));
        } catch (ProgramControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }

    private void back() {
        this.console.println("*** quitGame ***"
                + "\nSending player back to Main Menu");
        GameMenuView quittingGame = new GameMenuView(player);
        quittingGame.display(hMR);//program will go back to the previous menu 
    }

}
