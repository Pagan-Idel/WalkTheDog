package byui.cit260.walkTheDog.control;

import byui.cit260.walkTheDog.exceptions.ProgramControlException;
import byui.cit260.walkTheDog.model.Player;
import byui.cit260.walkTheDog.view.ErrorView;
import byui.cit260.walkTheDog.view.UserExperienceView;
import java.io.PrintWriter;
import walkthedog.WalkTheDog;

/**
 *
 * @author Idel and gab James
 */
public class ProgramControl {

    protected final PrintWriter console = WalkTheDog.getOutFile();

    public static Player createPlayer(String name) {
        Player player = new Player();
        player.setName(name);
        WalkTheDog.setPlayer(player);
        return player;
    }

    public int playerLifePoints(Player player) throws ProgramControlException {

        int points = player.getPlayerCurrentScore();

        if (points < 0) {
            throw new ProgramControlException("\n*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in ProgramControl.java ***"
                    + "\nin       public int playerLifePoints(Player player)"
                    + "\n if (points < 0)");
        }

        return points;          //returns life points
    }

    public int fidoMood(Player player) throws ProgramControlException {

        int points = player.getGameFidoMood();

        if (points < 0) {
            throw new ProgramControlException("*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in ProgramControl.java ***"
                    + "\nin       public int fidoMood(Player player)"
                    + "\n if (points < 0)");
        }

        return points;          //returns life points
    }

    public int userExperienceInputCheck(char choice, Player player, String hMR) {

        char var = (char) choice;
        char YES = 'Y';
        char NO = 'N';
        char yes = 'y';
        char no = 'n';
        int playerSatisfaction = player.getPlayerSatisfaction();

        if (var == YES) {
            playerSatisfaction += 1;
        } else if (var == NO) {
            playerSatisfaction -= 1;
        } else if (var == yes) {
            playerSatisfaction += 1;
        } else if (var == no) {
            playerSatisfaction -= 1;
        } else {
            ErrorView.display(this.getClass().getName(), "\nInvalid entry - please try again");
            UserExperienceView question = new UserExperienceView(player);
            question.display(hMR);
        }
        return playerSatisfaction;
    }

    public int checkHighScore(int currentScore, int highScore) throws ProgramControlException {

        // check currentScore is real number
        if (currentScore < 0) {
            throw new ProgramControlException("\n*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in ProgramControl.java ***"
                    + "\nin       public int checkHighScore(int currentScore, int highScore)"
                    + "\n if(currentScore ");
        }
        if (highScore < 0) {
            throw new ProgramControlException("\n*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in ProgramControl.java ***"
                    + "\nin       public int checkHighScore(int currentScore, int highScore)"
                    + "\n if(highScore ");
        }

        if (currentScore > highScore) {
//            System.out.println("player High Score was increased in PROGRAMCONTROL/CHECKHIGHSCORE " + highScore);
            return currentScore;
        }

        return highScore;
    }

}
