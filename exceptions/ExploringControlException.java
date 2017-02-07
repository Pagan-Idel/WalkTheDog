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
public class ExploringControlException extends Exception {

    public ExploringControlException() {
    }

    public ExploringControlException(String string) {
        super(string);
    }

    public ExploringControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ExploringControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ExploringControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
