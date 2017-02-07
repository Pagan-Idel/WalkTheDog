/*
 * Project author: gab James.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.walkTheDog.view;

import byui.cit260.walkTheDog.control.ProgramControl;
import byui.cit260.walkTheDog.model.Player;

/**
 *
 * @author gab
 */
public class UserExperienceView extends View {

    public Player player;
    public String hMR = "uEV";

    public UserExperienceView(Player players) {
        super(
                "\nBefore you leave, did you enjoy your"
                + "\nexperience in this location Y/N?");

        this.player = players;

    }

    @Override
    public void doAction(char choice) {

        int start = player.getPlayerSatisfaction();

        do {
            this.userExperienceInput(choice);

        } while (player.getPlayerSatisfaction() == start);

        this.console.println("\nPlayer Satisfaction is now: " + player.getPlayerSatisfaction());

        LocationView changeLocations = new LocationView(player);                // send user to Location view menu
        changeLocations.display(hMR);

    }

    public void userExperienceInput(char choice) {

        ProgramControl check = new ProgramControl();                            // Control class is in ProgramControl.java
        player.setPlayerSatisfaction(check.userExperienceInputCheck(choice, player, hMR));
    }

}
