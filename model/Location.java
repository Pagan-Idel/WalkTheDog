/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.walkTheDog.model;

import byui.cit260.walkTheDog.enums.Scene;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Idel
 */
public class Location implements Serializable {

    private int row;
    private int column;
    private boolean visited;
    private String explore;
    private String randomEvent;
    private String actorRandomEvent;
    private Scene scene;
    private ArrayList<Actor> actors;

    public Location() {
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getExplore() {
        return explore;
    }

    public void setExplore(String explore) {
        this.explore = explore;
    }

    public String getRandomEvent() {
        return randomEvent;
    }

    public void setRandomEvent(String randomEvent) {
        this.randomEvent = randomEvent;
    }

    public String getActorRandomEvent() {
        return actorRandomEvent;
    }

    public void setActorRandomEvent(String actorRandomEvent) {
        this.actorRandomEvent = actorRandomEvent;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.row;
        hash = 67 * hash + this.column;
        hash = 67 * hash + (this.visited ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.explore);
        hash = 67 * hash + Objects.hashCode(this.randomEvent);
        hash = 67 * hash + Objects.hashCode(this.actorRandomEvent);
        hash = 67 * hash + Objects.hashCode(this.scene);
        hash = 67 * hash + Objects.hashCode(this.actors);
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
        final Location other = (Location) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        if (!Objects.equals(this.explore, other.explore)) {
            return false;
        }
        if (!Objects.equals(this.randomEvent, other.randomEvent)) {
            return false;
        }
        if (!Objects.equals(this.actorRandomEvent, other.actorRandomEvent)) {
            return false;
        }
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        if (!Objects.equals(this.actors, other.actors)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", visited=" + visited + ", explore=" + explore + ", randomEvent=" + randomEvent + ", actorRandomEvent=" + actorRandomEvent + ", scene=" + scene + ", actors=" + actors + '}';
    }


    
    
    
}
