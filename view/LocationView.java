/*
 * Project author: gab James.
 */
package byui.cit260.walkTheDog.view;

import byui.cit260.walkTheDog.control.MapControl;
import byui.cit260.walkTheDog.exceptions.MapControlException;
import byui.cit260.walkTheDog.model.Player;


/*
 * @author gab
 */
public class LocationView extends ViewForLocation {

    public String hMR = "LV";
    private Player player;

    public LocationView(Player player) {

        super("\n"
                + "\nWhich area of the Park would you"
                + "\nlike to go to next?"
                + "\n--------------------------------"
                + "\nLocation Menu"
                + "\n--------------------------------"
                + "\n"
                + "\n  1   - fountain"
                + "\n  2   - duckpond"
                + "\n  3   - statue"
                + "\n  4   - restrooms"
                + "\n  5   - dogpark"
                + "\n  6   - playground"
                + "\n  7   - restrooms"
                + "\n  8   - statue"
                + "\n  9   - fountain"
                + "\n  H   - Help Menu"
                + "\n  Q   - Return to Game menu"
                + "\n________________________________\n");

        this.player = player;

        MapControl seeMap = new MapControl();
        seeMap.displayMap();

    }

    private void displayHelpMenu() {
        HelpMenuView gameMenuHelp = new HelpMenuView();
        gameMenuHelp.displayHelpMenu(hMR, player);
    }

    private void quitGame() {
        this.console.println("\nSending player back to Game Menu\n");
        player.setGameDidUserExplore('y');
        GameMenuView quittingGame = new GameMenuView(player);
        quittingGame.display(hMR);
    }

    @Override
    public void doAction(char choice) {                                         // changed to display the location view

        int row = -1, column = -1;

        if (choice == '1') {
            row = 0;
            column = 0;
        } else if (choice == '2') {
            row = 0;
            column = 1;
        } else if (choice == '3') {
            row = 0;
            column = 2;
        } else if (choice == '4') {
            row = 1;
            column = 0;
        } else if (choice == '5') {
            row = 1;
            column = 1;
        } else if (choice == '6') {
            row = 1;
            column = 2;
        } else if (choice == '7') {
            row = 2;
            column = 0;
        } else if (choice == '8') {
            row = 2;
            column = 1;
        } else if (choice == '9') {
            row = 2;
            column = 2;
        } else if (choice == 'H') {
            this.displayHelpMenu();
        } else if (choice == 'Q') {
            this.quitGame();
        } else {
            ErrorView.display(this.getClass().getName(), "\n*** Invalid Selection in visitSceanL *** Try Again ***");
        }

        MapControl goTo = new MapControl();
        try {
            goTo.visitSceanLocations(row, column, player, hMR);
        } catch (MapControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

    }

}
