/*
 * Project author: gab James.
 */
package byui.cit260.walkTheDog.view;

import byui.cit260.walkTheDog.interfaces.ViewLocationInterface;
import java.io.BufferedReader;
import java.io.PrintWriter;
import walkthedog.WalkTheDog;


/*
 * @author gab
 */
public abstract class ViewForLocation implements ViewLocationInterface {

    private final String promtMessage;
    protected final BufferedReader keyboard = WalkTheDog.getInFile();
    protected final PrintWriter console = WalkTheDog.getOutFile();

    public ViewForLocation(String promtMessage) {
        this.promtMessage = promtMessage;
    }

    @Override
    public void display(String hMR) {
        String value;
        char selection = ' ';

        do {
            this.console.println(this.promtMessage);                              //display promt message
            value = this.getInput();                                            // get the user selection
            value = value.toUpperCase();
            selection = value.charAt(0);                                        // converts getInput to char

            this.doAction(selection);

        } while (!value.equals("Q") || !value.equals("q"));

    }

    @Override
    public String getInput() {
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

    @Override
    public void doAction(char selection) {

    }

}
