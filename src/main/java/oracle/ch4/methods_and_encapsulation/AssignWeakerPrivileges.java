package oracle.ch4.methods_and_encapsulation;

/**
 * A subclass cannot assign weaker access privileges when overriding a method
 * Public is the strongest access specifier 
 * Protected is the 2nd strongest access specifier
 * Default is the 3rd strongest access specifier
 * Private is the weakest access specifier 
 *
 * @author jev
 * @since Nov 20, 2018
 */
public class AssignWeakerPrivileges {

    private static class PublicAccess {

	public void m() {
	    System.out.println("A");
	}
    }

    private static class PublicAccessSubclass extends PublicAccess {

	/**
	 * m() in B cannot override jump() in A, attempting to assign weaker access privileges; was public
	 */
//	 void m() {}		 // default is <= public
//	 protected void m() {}   // protected is <= public
//	 private void m(){}	 // private is <= public
//	@Override
//	public void m() {	 // public is >= public.
//	}
    }

    private static class ProtectedAccess {

	protected void m() {
	}
    }

    private static class ProtectedAccessSubclass extends ProtectedAccess {

	//OK
	// public void m() {} // is >= protected
	// protected void m() {} // is >= protected
	// Not ok 
//	 void m(){} // Not ok 
	// private void m() {
    }

    private static class DefaultAccess {

	void m() {
	}
    }

    private static class DefaultAccessSubclass extends DefaultAccess {

	// OK
	//public void m() {}
	//protected void m() {}
	//void m() {}
	// NOT OK
	// private void m(){}
    }
}
