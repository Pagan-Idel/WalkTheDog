package byui.cit260.walkTheDog.enums;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gab
 */
public class EventsScene implements Serializable {

    private int fixedEventScene;
    private boolean blocked;
    public String EventsSymbol;

    public EventsScene() {
    }

    public static enum EventSceneType {

        getsBellyRubbed,
        playsFetch,
        getsTreat,
        rollsOver,
        doesTrick,
        sniffsGround,
        licksPerson,
        getsScrachedBehindEars,
        stepInPoop,
        birdAttack,
        dogBitesSomeone,
        getsBitByOtherDog,
        sniffsOtherDogButt,
        licksSelf,
        chasesSquirrel,
        getsChokedByLeash;
    }

    EventsScene(String description) {
        this.EventsSymbol = description;
        fixedEventScene = 1;

    }

    public int getFixedEventScene() {
        return fixedEventScene;
    }

    public void setFixedEventScene(int fixedEventScene) {
        this.fixedEventScene = fixedEventScene;
    }

    public String getDescription() {
        return EventsSymbol;
    }

    public void setDescription(String description) {
        this.EventsSymbol = description;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public String getEventsSymbol() {
        return EventsSymbol;
    }

    public void setEventsSymbol(String st) {
        this.EventsSymbol = st;
    }

    public void setBlocked(boolean b) {
        this.blocked = b;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.fixedEventScene;
        hash = 97 * hash + Objects.hashCode(this.EventsSymbol);
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
        final EventsScene other = (EventsScene) obj;
        if (this.fixedEventScene != other.fixedEventScene) {
            return false;
        }
        if (!Objects.equals(this.EventsSymbol, other.EventsSymbol)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EventScene{" + "fixedEventScene=" + fixedEventScene + ", description=" + EventsSymbol + '}';
    }

}
