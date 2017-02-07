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
public class MiniGameControlException extends Exception {

    public MiniGameControlException() {
    }

    public MiniGameControlException(String string) {
        super(string);
    }

    public MiniGameControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public MiniGameControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public MiniGameControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
