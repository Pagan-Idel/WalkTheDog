/*
 * Project author: gab James.
 */
package byui.cit260.walkTheDog.view;

import static byui.cit260.walkTheDog.control.MapControl.columCount;
import static byui.cit260.walkTheDog.control.MapControl.rowCount;
import byui.cit260.walkTheDog.exceptions.PrintControlException;
import byui.cit260.walkTheDog.model.Location;
import java.io.*;
import walkthedog.WalkTheDog;

/**
 *
 * @author gab
 */
public class PrintView {

    protected final BufferedReader keyboard = WalkTheDog.getInFile();
    protected final PrintWriter console = WalkTheDog.getOutFile();

    public void printMap() throws PrintControlException {

        Location[][] locations = WalkTheDog.getCurrentGame().getMap().getLocations();

        this.console.println("\nPlease enter the file path where the file will be saved.");

        String filePath = this.getInput();

        /* zInstructor: 
         * When you print text to a file you must use a character stream
         * (e.g., PrintWriter) and not a byte stream. A byte steam writes
         * raw binary data to the file. A character stream prints human
         * readable text as characters to the file. This is why you can
         * not read the report.
         */
        try (FileWriter filePathOut = new FileWriter(filePath)) {
            filePathOut.write(System.getProperty("line.separator") + "A Map of The Park" + System.getProperty("line.separator") + System.getProperty("line.separator"));
            filePathOut.write(System.getProperty("line.separator") + "          ");

            for (int column = 0; column < columCount; column++) {
                filePathOut.write("     " + column + "     | ");
            }

            for (int row = 0; row < rowCount; row++) {
                filePathOut.write(System.getProperty("line.separator") + "      " + row);

                for (int column = 0; column < columCount; column++) {
                    filePathOut.write(" | ");
                    Location location = locations[row][column];
                    if (!location.equals("")) {
                        filePathOut.write(locations[row][column].getScene().getMapSymbol());
                    } else {
                        filePathOut.write("   x      ");
                    }
                }
                filePathOut.write(" |");
            }
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

    }

    public String getInput() {
        //Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String selection = null;
        try {
            //while a valid name has not been retrived
            while (!valid) {

                //promt for players name
                this.console.println("\t\nEnter your selection below: ");

                selection = this.keyboard.readLine();
                selection = selection.trim();
                selection = selection.toUpperCase();

                if (selection.length() < 1) {                                        //check for blank value entered returns error message
                    ErrorView.display(this.getClass().getName(), "\n*** Invalid Selection *** Try again");
                    continue;
                }
                break;
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading inputL " + e.getMessage());
        }
        return selection;                                                       // return the name

    }

}
