/*
 * Project author: gab James.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.walkTheDog.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @authors Idel Pagan and gab James
 */
public class Game implements Serializable {
 
    private Player player;                        //this is the player
    public Map map;                              //this is the map
    private int idealLeashLength;                 //this is the distance from player to actor
    private int currentScore;                     //the users current game score
    private char didUserExplore;                  //did the user explore? y/n
    private int userExploreCounter;               //number of times the user did not explore and passed locations                      
    private int shortLeashNumberOfTurns;          //number of turns the leash is below 4
    public Events event;

    
    public Game() {
    }

    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getIdealLeashLength() {
        return idealLeashLength;
    }

    public void setIdealLeashLength(int idealLeashLength) {
        this.idealLeashLength = idealLeashLength;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public char getDidUserExplore() {
        return didUserExplore;
    }

    public void setDidUserExplore(char didUserExplore) {
        this.didUserExplore = didUserExplore;
    }

    public int getUserExploreCounter() {
        return userExploreCounter;
    }

    public void setUserExploreCounter(int userExploreCounter) {
        this.userExploreCounter = userExploreCounter;
    }

    public int getShortLeashNumberOfTurns() {
        return shortLeashNumberOfTurns;
    }

    public void setShortLeashNumberOfTurns(int shortLeashNumberOfTurns) {
        this.shortLeashNumberOfTurns = shortLeashNumberOfTurns;
    }

    public Events getEvent() {
        return event;
    }

    public void setEvent(Events event) {
        this.event = event;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.player);
        hash = 89 * hash + Objects.hashCode(this.map);
        hash = 89 * hash + this.idealLeashLength;
        hash = 89 * hash + this.currentScore;
        hash = 89 * hash + this.didUserExplore;
        hash = 89 * hash + this.userExploreCounter;
        hash = 89 * hash + this.shortLeashNumberOfTurns;
        hash = 89 * hash + Objects.hashCode(this.event);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (this.idealLeashLength != other.idealLeashLength) {
            return false;
        }
        if (this.currentScore != other.currentScore) {
            return false;
        }
        if (this.didUserExplore != other.didUserExplore) {
            return false;
        }
        if (this.userExploreCounter != other.userExploreCounter) {
            return false;
        }
        if (this.shortLeashNumberOfTurns != other.shortLeashNumberOfTurns) {
            return false;
        }
        if (!Objects.equals(this.event, other.event)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "player=" + player + ", map=" + map + ", idealLeashLength=" + idealLeashLength + ", currentScore=" + currentScore + ", didUserExplore=" + didUserExplore + ", userExploreCounter=" + userExploreCounter + ", shortLeashNumberOfTurns=" + shortLeashNumberOfTurns + ", event=" + event + '}';
    }
    
    
    
    
}