/*
 * To change this license header, choose License Headers in Project Properties.
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
public class Player implements Serializable {

    private String name;
    public int playerCurrentScore;
    public char gameDidUserExplore;
    public int gameUserExploreCounter;
    public int playerLeashLenght;
    public int gameNumberOfTurns;
    public int gameFidoMood;
    public int gameIdealLeashLength;
    public int playerSatisfaction;
    public char playedMiniGame;
    public int winLose;
    public int highScore;
    

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerCurrentScore() {
        return playerCurrentScore;
    }

    public void setPlayerCurrentScore(int playerCurrentScore) {
        this.playerCurrentScore = playerCurrentScore;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public char getGameDidUserExplore() {
        return gameDidUserExplore;
    }

    public void setGameDidUserExplore(char gameDidUserExplore) {
        this.gameDidUserExplore = gameDidUserExplore;
    }

    public int getGameUserExploreCounter() {
        return gameUserExploreCounter;
    }

    public void setGameUserExploreCounter(int gameUserExploreCounter) {
        this.gameUserExploreCounter = gameUserExploreCounter;
    }

    public int getPlayerLeashLenght() {
        return playerLeashLenght;
    }

    public void setPlayerLeashLenght(int playerLeashLenght) {
        this.playerLeashLenght = playerLeashLenght;
    }

    public int getGameNumberOfTurns() {
        return gameNumberOfTurns;
    }

    public void setGameNumberOfTurns(int gameNumberOfTurns) {
        this.gameNumberOfTurns = gameNumberOfTurns;
    }

    public int getGameFidoMood() {
        return gameFidoMood;
    }

    public void setGameFidoMood(int gameFidoMood) {
        this.gameFidoMood = gameFidoMood;
    }

    public int getGameIdealLeashLength() {
        return gameIdealLeashLength;
    }

    public void setGameIdealLeashLength(int gameIdealLeashLength) {
        this.gameIdealLeashLength = gameIdealLeashLength;
    }

    public int getPlayerSatisfaction() {
        return playerSatisfaction;
    }

    public void setPlayerSatisfaction(int playerSatisfaction) {
        this.playerSatisfaction = playerSatisfaction;
    }

    public char getPlayedMiniGame() {
        return playedMiniGame;
    }

    public void setPlayedMiniGame(char playedMiniGame) {
        this.playedMiniGame = playedMiniGame;
    }

    public int getWinLose() {
        return winLose;
    }

    public void setWinLose(int winLose) {
        this.winLose = winLose;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + this.playerCurrentScore;
        hash = 37 * hash + this.gameDidUserExplore;
        hash = 37 * hash + this.gameUserExploreCounter;
        hash = 37 * hash + this.playerLeashLenght;
        hash = 37 * hash + this.gameNumberOfTurns;
        hash = 37 * hash + this.gameFidoMood;
        hash = 37 * hash + this.gameIdealLeashLength;
        hash = 37 * hash + this.playerSatisfaction;
        hash = 37 * hash + this.playedMiniGame;
        hash = 37 * hash + this.winLose;
        hash = 37 * hash + this.highScore;
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.playerCurrentScore != other.playerCurrentScore) {
            return false;
        }
        if (this.gameDidUserExplore != other.gameDidUserExplore) {
            return false;
        }
        if (this.gameUserExploreCounter != other.gameUserExploreCounter) {
            return false;
        }
        if (this.playerLeashLenght != other.playerLeashLenght) {
            return false;
        }
        if (this.gameNumberOfTurns != other.gameNumberOfTurns) {
            return false;
        }
        if (this.gameFidoMood != other.gameFidoMood) {
            return false;
        }
        if (this.gameIdealLeashLength != other.gameIdealLeashLength) {
            return false;
        }
        if (this.playerSatisfaction != other.playerSatisfaction) {
            return false;
        }
        if (this.playedMiniGame != other.playedMiniGame) {
            return false;
        }
        if (this.winLose != other.winLose) {
            return false;
        }
        if (this.highScore != other.highScore) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", playerCurrentScore=" + playerCurrentScore + ", gameDidUserExplore=" + gameDidUserExplore + ", gameUserExploreCounter=" + gameUserExploreCounter + ", playerLeashLenght=" + playerLeashLenght + ", gameNumberOfTurns=" + gameNumberOfTurns + ", gameFidoMood=" + gameFidoMood + ", gameIdealLeashLength=" + gameIdealLeashLength + ", playerSatisfaction=" + playerSatisfaction + ", playedMiniGame=" + playedMiniGame + ", winLose=" + winLose + ", highScore=" + highScore + '}';
    }


   
    
    
    
    
}
