package byui.cit260.walkTheDog.model;

import byui.cit260.walkTheDog.exceptions.EventsControlException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import walkthedog.WalkTheDog;

/**
 *
 * @authors and gab James
 */
public class Events implements Serializable {

    public int eventTypeInPark;
    public EventsType[][] eventTypes;
    int noOfRows;
    int noOfColums;
//    protected final PrintWriter console = WalkTheDog.getOutFile();

    public Events() {
    }

    

    public Events(int noOfRows, int noOfColums) throws EventsControlException {

        if (noOfRows < 1 || noOfColums < 1) {
            throw new EventsControlException ("Enter a Number greater than zero");
        }

        this.eventTypes = new EventsType[noOfRows][noOfColums];
        this.noOfRows = noOfRows;
        this.noOfColums = noOfColums;

        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfColums; column++) {
                EventsType eventType = new EventsType();                          // create and initilize the eventType objects instance
                eventType.setColumn(column);
                eventType.setRow(row);
                eventType.setVisited(false);
                eventTypes[row][column] = eventType;                            //assign the EventsType object to the current position in array
            }   // END for column loop
        }       // END for row loop

    }   // END     public Events(int noOfRows, int noOfColums) 

//    public PrintWriter getConsole() {
//        return console;
//    }
    
    public int getEventTypeInPark() {
        return eventTypeInPark;
    }

    public void setEventTypeInPark(int eventTypeInPark) {
        this.eventTypeInPark = eventTypeInPark;
    }

    public EventsType[][] getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(EventsType[][] eventTypes) {
        this.eventTypes = eventTypes;
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    public int getNoOfColums() {
        return noOfColums;
    }

    public void setNoOfColums(int noOfColums) {
        this.noOfColums = noOfColums;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.eventTypeInPark;
        hash = 97 * hash + Arrays.deepHashCode(this.eventTypes);
        hash = 97 * hash + this.noOfRows;
        hash = 97 * hash + this.noOfColums;
//        hash = 97 * hash + Objects.hashCode(this.console);
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
        final Events other = (Events) obj;
        if (this.eventTypeInPark != other.eventTypeInPark) {
            return false;
        }
        if (!Arrays.deepEquals(this.eventTypes, other.eventTypes)) {
            return false;
        }
        if (this.noOfRows != other.noOfRows) {
            return false;
        }
        if (this.noOfColums != other.noOfColums) {
            return false;
        }
//        if (!Objects.equals(this.console, other.console)) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return "Events{" + "eventTypeInPark=" + eventTypeInPark + ", eventTypes=" + eventTypes + ", noOfRows=" + noOfRows + ", noOfColums=" + noOfColums + '}';
    }

    private Exception EventsControlException(String enter_a_Number_greater_than_zero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
    
    
    
    
}   //End of public class Events implements Serializable
