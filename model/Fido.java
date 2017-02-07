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
public class Fido implements Serializable {

    // class instance variables
//    private String name;        
    private String templerment;
    private String mood;
    private int leashLength;
    private int numberOfTurns;

    public Fido() {
    }

    public String getTemplerment() {
        return templerment;
    }

    public void setTemplerment(String templerment) {
        this.templerment = templerment;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public int getLeashLength() {
        return leashLength;
    }

    public void setLeashLength(int leashLength) {
        this.leashLength = leashLength;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.templerment);
        hash = 37 * hash + Objects.hashCode(this.mood);
        hash = 37 * hash + this.leashLength;
        hash = 37 * hash + this.numberOfTurns;
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
        final Fido other = (Fido) obj;
        if (!Objects.equals(this.templerment, other.templerment)) {
            return false;
        }
        if (!Objects.equals(this.mood, other.mood)) {
            return false;
        }
        if (this.leashLength != other.leashLength) {
            return false;
        }
        if (this.numberOfTurns != other.numberOfTurns) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fido{" + "templerment=" + templerment + ", mood=" + mood + ", leashLength=" + leashLength + ", numberOfTurns=" + numberOfTurns + '}';
    }


    
    
    
    
    
    
}
