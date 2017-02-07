/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.walkTheDog.control;

import byui.cit260.walkTheDog.enums.EventsScene;
import byui.cit260.walkTheDog.model.EventsType;
import byui.cit260.walkTheDog.model.Game;
import byui.cit260.walkTheDog.model.Location;
import byui.cit260.walkTheDog.model.Events;
import byui.cit260.walkTheDog.model.Map;
import byui.cit260.walkTheDog.model.Player;
import byui.cit260.walkTheDog.enums.Scene;
import byui.cit260.walkTheDog.exceptions.EventsControlException;
import byui.cit260.walkTheDog.exceptions.GameControlException;
import byui.cit260.walkTheDog.view.MainMenuView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import walkthedog.WalkTheDog;


/**
 *
 * @author Idel
 */
public class GameControl {

    public static void createNewGame(Player player) throws EventsControlException {
        ExploringControl numbernumber = new ExploringControl();

//        this.console.println("\n*** createNewGame stub function called ***"
//                + "GameControl.java     createNewGame(Player player)");
        Game game = new Game();                 //create new game
        WalkTheDog.setCurrentGame(game);        //save in WalkTheDog.java

        game.setPlayer(player);                 //save the player in the game

        Map map = MapControl.createMap();       //this creates and initializes a new map
        game.setMap(map);

        Events events = EventsControl.createEvents();       //this creates and initializes a new events
        game.setEvent(events);

//        Fido fido = FidoControl.createFido();
//        game.setFido(fido);
        Player variable = game.getPlayer();
        variable.setPlayedMiniGame('n');
        variable.setGameDidUserExplore('n');
        variable.setGameFidoMood(5);
        variable.setPlayerCurrentScore(2 + numbernumber.randomNumberGenerator16_0to15());
        variable.setGameUserExploreCounter(0);
        variable.setPlayerLeashLenght(numbernumber.randomNumberGenerator16_0to15());
        variable.setGameNumberOfTurns(0);
        variable.setGameIdealLeashLength(numbernumber.randomIdealLeashGenerator());
        variable.setPlayerSatisfaction(5);
        variable.setWinLose(0);

    }

    static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();

        //start point
        locations[0][0].setScene(scenes[Scene.SceneType.fountain.ordinal()]);
        locations[0][1].setScene(scenes[Scene.SceneType.duckpond.ordinal()]);
        locations[0][2].setScene(scenes[Scene.SceneType.statue.ordinal()]);
        locations[1][0].setScene(scenes[Scene.SceneType.restrooms.ordinal()]);
        locations[1][1].setScene(scenes[Scene.SceneType.dogpark.ordinal()]);
        locations[1][2].setScene(scenes[Scene.SceneType.playground.ordinal()]);
        locations[2][0].setScene(scenes[Scene.SceneType.restrooms.ordinal()]);
        locations[2][1].setScene(scenes[Scene.SceneType.statue.ordinal()]);
        locations[2][2].setScene(scenes[Scene.SceneType.fountain.ordinal()]);

    }

    static void assignEventScenesToEventTypes(Events events, EventsScene[] scenes) {
        EventsType[][] eventType = events.getEventTypes();

        //start point
        eventType[0][1].setEventScene(scenes[EventsScene.EventSceneType.getsChokedByLeash.ordinal()]);
        eventType[1][1].setEventScene(scenes[EventsScene.EventSceneType.stepInPoop.ordinal()]);
        eventType[2][1].setEventScene(scenes[EventsScene.EventSceneType.birdAttack.ordinal()]);
        eventType[3][1].setEventScene(scenes[EventsScene.EventSceneType.dogBitesSomeone.ordinal()]);
        eventType[4][1].setEventScene(scenes[EventsScene.EventSceneType.getsBitByOtherDog.ordinal()]);
        eventType[5][1].setEventScene(scenes[EventsScene.EventSceneType.sniffsOtherDogButt.ordinal()]);
        eventType[6][1].setEventScene(scenes[EventsScene.EventSceneType.licksSelf.ordinal()]);
        eventType[7][1].setEventScene(scenes[EventsScene.EventSceneType.chasesSquirrel.ordinal()]);
        eventType[0][0].setEventScene(scenes[EventsScene.EventSceneType.getsBellyRubbed.ordinal()]);
        eventType[1][0].setEventScene(scenes[EventsScene.EventSceneType.playsFetch.ordinal()]);
        eventType[2][0].setEventScene(scenes[EventsScene.EventSceneType.getsTreat.ordinal()]);
        eventType[3][0].setEventScene(scenes[EventsScene.EventSceneType.rollsOver.ordinal()]);
        eventType[4][0].setEventScene(scenes[EventsScene.EventSceneType.doesTrick.ordinal()]);
        eventType[5][0].setEventScene(scenes[EventsScene.EventSceneType.sniffsGround.ordinal()]);
        eventType[6][0].setEventScene(scenes[EventsScene.EventSceneType.licksPerson.ordinal()]);
        eventType[7][0].setEventScene(scenes[EventsScene.EventSceneType.getsScrachedBehindEars.ordinal()]);

    }

    public static void saveGame(Game game, String filepath) throws GameControlException {

        try (FileOutputStream fops = new FileOutputStream(filepath); /* zInstructor:
                 * Please indent code in a block
                 */ ObjectOutputStream saveFile = new ObjectOutputStream(fops)) {

            saveFile.writeObject(game); //write the game object out to file
            saveFile.close();
        } catch (IOException e) {

            throw new GameControlException(e.getMessage());

        }
    }

    public static void getSavedGame(String filePath)
            throws GameControlException {
        Game game = null;

        try (FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream output = new ObjectInputStream(fips);

            game = (Game) output.readObject(); // read the game object from file
            output.close();
        } catch (FileNotFoundException fnfe) {
            throw new GameControlException(fnfe.getMessage());

        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
        // close the output file

        WalkTheDog.setCurrentGame(game); // save in WalkTheDog

    }

    public int playerWinLose(int bob)
            throws GameControlException {

        if (bob < 0) {      // test for good leashlenght
            throw new GameControlException("*** Our appologies, something went wrong. ***");
        }
        
        return bob+=1;             //bob is our favorite player
    }

    public void didPlayerWin(Player player)
    throws GameControlException {
        
        
        int bob = player.getWinLose();
        if(bob < 0){
           throw new GameControlException("*** Our appologies, something went wrong. ***");
        }
        
        if(bob > 10){
            MainMenuView win = new MainMenuView(player);
            win.youWin(player);
        }
    }

    public boolean userNewHighScore(Player player) 
            throws GameControlException {
         
        if(player.getPlayerCurrentScore() < 0){
           throw new GameControlException("*** Our appologies, something went wrong. ***");
        }
         if(player.getHighScore() < 0){
           throw new GameControlException("*** Our appologies, something went wrong. ***");
        }
        
         if (player.getPlayerCurrentScore() > player.getHighScore() || player.getPlayerCurrentScore() == player.getHighScore()){
            
             player.setHighScore(player.getPlayerCurrentScore());
             
            return true;
         }
         
        return false;
    }
}
