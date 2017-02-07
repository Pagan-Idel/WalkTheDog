/*
 * Project author: gab James.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.walkTheDog.view;

import byui.cit260.walkTheDog.interfaces.ViewInterface;
import java.io.IOException;
import java.io.PrintWriter;
import walkthedog.WalkTheDog;
import java.io.BufferedReader;

/**
 *
 * @author gab
 */
public abstract class View implements ViewInterface {

    private final String promtMessage;
    protected final BufferedReader keyboard = WalkTheDog.getInFile();
    protected final PrintWriter console = WalkTheDog.getOutFile();

    public View(String promtMessage) {
        this.promtMessage = promtMessage;
    }

    @Override
    public void display(String hMR) {
        String value;
        char selection = ' ';

        do {

            this.console.println(this.promtMessage);  //display promt message
            value = this.getInput();        // get the user selection
            value = value.trim();
            value = value.toUpperCase();
            selection = value.charAt(0);
            this.doAction(selection);

        } while (!value.equals("Q"));

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

                // get the value entered from the keyboard
                selection = this.keyboard.readLine();

                //selection = keyboard.nextLine();
                selection = selection.trim();
                selection = selection.toUpperCase();

                if (selection.length() < 1) { //blank value entered
                    ErrorView.display(this.getClass().getName(), "\n*** Invalid Selection *** Try again");
                    continue;

                }
                break;
            }
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        return selection;  // return the name

    }

    @Override
    public void doAction(char selection) {

    }

}
