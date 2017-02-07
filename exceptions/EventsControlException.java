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
public class EventsControlException extends Exception {

    public EventsControlException() {
    }

    public EventsControlException(String string) {
        super(string);
    }

    public EventsControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public EventsControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public EventsControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
