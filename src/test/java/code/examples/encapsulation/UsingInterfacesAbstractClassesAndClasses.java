package code.examples.encapsulation;

public class UsingInterfacesAbstractClassesAndClasses {

    private static interface Printable {

	public abstract void setMargin();

	public void setOrientation();
    }

    /**
     * Because Paper is abstract it does not need to implement the methods of Printable, but it can.
     */
    private static abstract class Paper implements Printable {

	@Override
	public void setMargin() {
	}
    }

    abstract class NewsPaper extends Paper {

	@Override
	public void setOrientation() {
	}
    }

    abstract class Magazine extends Paper {
    }

    /**
     * The first concrete implementation must implement everything that does not yet have an implementation.
     * ConcretePaperClass is using Paper's impl of setMargin();
     */
    class ConcretePaperClass extends Paper {

	@Override
	public void setOrientation() {
	    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
    }

}
