/*
 * Project author: gab James.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.walkTheDog.exceptions;

/**
 *
 * @author gab
 */
public class GameControlException extends Exception {

    public GameControlException() {
    }

    public GameControlException(String string) {
        super(string);
    }

    public GameControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public GameControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public GameControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
