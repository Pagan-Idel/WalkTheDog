
/*
 * Project author: gab James.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.walkTheDog.model;

import byui.cit260.walkTheDog.view.ErrorView;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @authors Idel Pagan and gab James
 */
public class Map implements Serializable {

    public int locationInPark;
    public Location[][] locations;
    int noOfRows;
    int noOfColums;

    public Map() {

    }


    public Map(int noOfRows, int noOfColums) {

        if (noOfRows < 1 || noOfColums < 1) {
            ErrorView.display(this.getClass().getName(), "The Location Number must be greater than zero");
            return;
        }

        this.noOfRows = noOfRows;
        this.noOfColums = noOfColums;

        this.locations = new Location[noOfRows][noOfColums];

        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfColums; column++) {
                // create and initilize the location objects instance
                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setVisited(false);

                //assign the Location object to the current position in array
                locations[row][column] = location;
            }
        }

    }

    public int getLocationInPark() {
        return locationInPark;
    }

    public void setLocationInPark(int locationInPark) {
        this.locationInPark = locationInPark;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
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
        hash = 29 * hash + this.locationInPark;
        hash = 29 * hash + Arrays.deepHashCode(this.locations);
        hash = 29 * hash + this.noOfRows;
        hash = 29 * hash + this.noOfColums;
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
        final Map other = (Map) obj;
        if (this.locationInPark != other.locationInPark) {
            return false;
        }
        if (!Arrays.deepEquals(this.locations, other.locations)) {
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
        return "Map{" + "locationInPark=" + locationInPark + ", locations=" + locations + ", noOfRows=" + noOfRows + ", noOfColums=" + noOfColums + '}';
    }


    
    
    
    
    
    
    
}
