package byui.cit260.walkTheDog.control;

import byui.cit260.walkTheDog.model.Location;
import byui.cit260.walkTheDog.model.Map;
import byui.cit260.walkTheDog.enums.Scene;
import byui.cit260.walkTheDog.exceptions.MapControlException;
import byui.cit260.walkTheDog.model.Player;
import byui.cit260.walkTheDog.view.GameMenuView;
import java.io.PrintWriter;
import walkthedog.WalkTheDog;

/**
 *
 * @author Gab and Idel
 *
 */
public class MapControl {

    public static int rowCount = 3;
    public static int columCount = 3;
    protected final PrintWriter console = WalkTheDog.getOutFile();

    public static Map createMap() {

        // Create Map
        Map map = new Map(rowCount, columCount);
        // create sceans for the game
        Scene[] scenes = createScenes();
        // assign sceans to locations
        GameControl.assignScenesToLocations(map, scenes);

        return map;
    }

    private static Scene[] createScenes() {

        Scene[] scenes = new Scene[Scene.SceneType.values().length];

        // STARTING SCENE////
        Scene fountainScene = new Scene();
        fountainScene.setDescription(
                "\nWalk your dog!!!!!!");                                               //add description
        fountainScene.setMapSymbol(" fountain ");
        fountainScene.setBlocked(false);
        scenes[Scene.SceneType.fountain.ordinal()] = fountainScene;

        Scene duckpondScene = new Scene();
        duckpondScene.setDescription(
                "\nWalk your dog!!!!!!");                                               //add description
        duckpondScene.setMapSymbol(" duckpond ");
        duckpondScene.setBlocked(false);
        scenes[Scene.SceneType.duckpond.ordinal()] = duckpondScene;

        Scene statueScene = new Scene();
        statueScene.setDescription(
                "\nWalk your dog!!!!!!");                                               //add description
        statueScene.setMapSymbol("  statue  ");
        statueScene.setBlocked(false);
        scenes[Scene.SceneType.statue.ordinal()] = statueScene;

        Scene restroomsScene = new Scene();
        restroomsScene.setDescription(
                "\nWalk your dog!!!!!!");                                               //add description
        restroomsScene.setMapSymbol(" restrooms");
        restroomsScene.setBlocked(false);
        scenes[Scene.SceneType.restrooms.ordinal()] = restroomsScene;

        Scene dogparkScene = new Scene();
        dogparkScene.setDescription(
                "\nWalk your dog!!!!!!");                                               //add description
        dogparkScene.setMapSymbol(" dogpark  ");
        dogparkScene.setBlocked(false);
        scenes[Scene.SceneType.dogpark.ordinal()] = dogparkScene;

        Scene playgroundScene = new Scene();
        playgroundScene.setDescription(
                "\nWalk your dog!!!!!!");                                               //add description
        playgroundScene.setMapSymbol("playground");
        playgroundScene.setBlocked(false);
        scenes[Scene.SceneType.playground.ordinal()] = playgroundScene;

        return scenes;
    }

//    public int move (int fido, int location){                            
//        // not sure what goes here yet
//        return 0;
//    }
    public boolean validLocation(int fido, int location) {
        // not sure what goes here yet and none of this is right
        boolean valid = false;
        if (fido < location) {
            valid = true;
        }

        return valid;
    }

    public void visitSceanLocations(int row, int column, Player player, String hMR) throws MapControlException {

        if (row < 0 || column < 0) {
            throw new MapControlException("*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in ProgramControl.java ***"
                    + "\nin       public int fidoMood(Player player)"
                    + "\n if (points < 0)");
        }

        Location[][] locations = WalkTheDog.getCurrentGame().getMap().getLocations();
        this.console.print("moving to " + locations[row][column].getScene().getMapSymbol());

        GameMenuView gameMenu = new GameMenuView(player);
        gameMenu.display(hMR);

    }

    public void displayMap() {

        Location[][] locations = WalkTheDog.getCurrentGame().getMap().getLocations();

        this.console.println("     The Park\n");
        this.console.print("          ");

        for (int column = 0; column < columCount; column++) {
            this.console.print("     " + column + "     | ");
        }

        for (int row = 0; row < rowCount; row++) {
            this.console.print("\n      " + row);
            for (int column = 0; column < columCount; column++) {
                this.console.print(" | ");
                Location location = locations[row][column];
                if (!location.equals("")) {
                    this.console.print(locations[row][column].getScene().getMapSymbol());
                } else {
                    this.console.print("   x      ");                           // place map symbol here
                }
            }

            this.console.print(" |");
        }
    }   // END of public void displayMap()

}
