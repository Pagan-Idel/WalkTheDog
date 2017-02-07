/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.walkTheDog.enums;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Idel
 */
public class Scene implements Serializable {

    private int fixedScene;
//    private String description;
    private boolean blocked;
    private double travelTime;
    public String MapSymbol;

    public double getTravelTime() {
        return travelTime;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public String getMapSymbol() {
        return MapSymbol;
    }

    public void setMapSymbol(String st) {
        this.MapSymbol = st;
    }

    public void setBlocked(boolean b) {
        this.blocked = b;
    }

    public void setTravelTime(double POSITIVE_INFINITY) {
        this.travelTime = POSITIVE_INFINITY;
    }

    public static enum SceneType {

        fountain, //("You found the water fountain, don't jump in the water!"),
        statue, //("You found the stature in the park, don't pee on it!"),
        playground, //("You found the playground, watch out for the kids!"),
        dogpark, //("You found the dog park, go play!"),
        restrooms, //("You found the restrooms, take a break!"),
        duckpond;               //("You found the duck pond, watch out for bird poop!");
    }

    Scene(String description) {
        this.MapSymbol = description;
        fixedScene = 1;

    }

    public int getFixedScene() {
        return fixedScene;
    }

    public void setFixedScene(int fixedScene) {
        this.fixedScene = fixedScene;
    }

    public String getDescription() {
        return MapSymbol;
    }

    public void setDescription(String description) {
        this.MapSymbol = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.fixedScene;
        hash = 97 * hash + Objects.hashCode(this.MapSymbol);
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
        final Scene other = (Scene) obj;
        if (this.fixedScene != other.fixedScene) {
            return false;
        }
        if (!Objects.equals(this.MapSymbol, other.MapSymbol)) {
            return false;
        }
        return true;
    }

    public Scene() {
    }

    @Override
    public String toString() {
        return "Scene{" + "fixedScene=" + fixedScene + ", description=" + MapSymbol + '}';
    }

}
