package oracle.ch4.methods_and_encapsulation;

/**
 * A method can throw more than one Exception
 *
 * @author jev
 */
public class OptionalExceptionList {

    public void zeroExceptions() {
    }

    public void oneException() throws IllegalArgumentException {
    }

    public void twoExceptions() throws
	    IllegalArgumentException, InterruptedException {
    }
}
