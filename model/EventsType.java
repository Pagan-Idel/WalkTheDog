package byui.cit260.walkTheDog.model;

import byui.cit260.walkTheDog.enums.EventsScene;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gab
 */
public class EventsType implements Serializable {

    private int row;
    private int column;
    private boolean visited;
    private String explore;
    private String randomEvent;
    private String actorRandomEvent;
    private EventsScene eventScene;

    public EventsType() {
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

    public EventsScene getEventScene() {
        return eventScene;
    }

    public void setEventScene(EventsScene eventScene) {
        this.eventScene = eventScene;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.row;
        hash = 11 * hash + this.column;
        hash = 11 * hash + (this.visited ? 1 : 0);
        hash = 11 * hash + Objects.hashCode(this.explore);
        hash = 11 * hash + Objects.hashCode(this.randomEvent);
        hash = 11 * hash + Objects.hashCode(this.actorRandomEvent);
        hash = 11 * hash + Objects.hashCode(this.eventScene);
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
        final EventsType other = (EventsType) obj;
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
        if (!Objects.equals(this.eventScene, other.eventScene)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EventsType{" + "row=" + row + ", column=" + column + ", visited=" + visited + ", explore=" + explore + ", randomEvent=" + randomEvent + ", actorRandomEvent=" + actorRandomEvent + ", eventScene=" + eventScene + '}';
    }


}
