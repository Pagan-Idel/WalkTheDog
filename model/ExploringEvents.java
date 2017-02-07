/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.walkTheDog.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Idel
 */
public class ExploringEvents implements Serializable {

    private int row;
    private int column;
    private boolean visited;
    private String eventName;
    private String evenDescription;
    private String criteria;
    public String[][] exploringEvents;
    private int noOfRows;
    private int noOfColums;

    public ExploringEvents() {
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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEvenDescription() {
        return evenDescription;
    }

    public void setEvenDescription(String evenDescription) {
        this.evenDescription = evenDescription;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String[][] getExploringEvents() {
        return exploringEvents;
    }

    public void setExploringEvents(String[][] exploringEvents) {
        this.exploringEvents = exploringEvents;
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
        int hash = 3;
        hash = 67 * hash + this.row;
        hash = 67 * hash + this.column;
        hash = 67 * hash + (this.visited ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.eventName);
        hash = 67 * hash + Objects.hashCode(this.evenDescription);
        hash = 67 * hash + Objects.hashCode(this.criteria);
        hash = 67 * hash + Arrays.deepHashCode(this.exploringEvents);
        hash = 67 * hash + this.noOfRows;
        hash = 67 * hash + this.noOfColums;
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
        final ExploringEvents other = (ExploringEvents) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        if (!Objects.equals(this.eventName, other.eventName)) {
            return false;
        }
        if (!Objects.equals(this.evenDescription, other.evenDescription)) {
            return false;
        }
        if (!Objects.equals(this.criteria, other.criteria)) {
            return false;
        }
        if (!Arrays.deepEquals(this.exploringEvents, other.exploringEvents)) {
            return false;
        }
        if (this.noOfRows != other.noOfRows) {
            return false;
        }
        if (this.noOfColums != other.noOfColums) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExploringEvents{" + "row=" + row + ", column=" + column + ", visited=" + visited + ", eventName=" + eventName + ", evenDescription=" + evenDescription + ", criteria=" + criteria + ", exploringEvents=" + exploringEvents + ", noOfRows=" + noOfRows + ", noOfColums=" + noOfColums + '}';
    }


    
    
    
    
    
    
}
