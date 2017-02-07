/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.walkTheDog.view;

import java.io.PrintWriter;
import walkthedog.WalkTheDog;

/**
 *
 * @author Idel
 */
public class ErrorView {

    private static final PrintWriter errorFile = WalkTheDog.getOutFile();
    private static final PrintWriter logFile = WalkTheDog.getLogFile();

    public static void display(String className, String errorMessage) {
        errorFile.println(""
                + "________________________________________________________"
                + "\n- ERROR - " + errorMessage
                + "\n_______________________________________________________");

        //log error
        logFile.println(className + " - " + errorMessage);

    }

}
