/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.walkTheDog.exceptions;

/**
 *
 * @author Idel
 */
public class TestControlException extends Exception {

    public TestControlException() {
    }

    public TestControlException(String message) {
        super(message);
    }

    public TestControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestControlException(Throwable cause) {
        super(cause);
    }

    public TestControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
