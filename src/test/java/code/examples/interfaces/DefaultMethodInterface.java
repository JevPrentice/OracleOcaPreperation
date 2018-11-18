package code.examples.interfaces;

import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class DefaultMethodInterface {

    public DefaultMethodInterface() {
    }

    private static interface MyInterface {

	default void m() { // Default method on interface.
	    System.out.println("MyInterface");
	}
    }

    private static abstract class MyAbstractClass implements MyInterface {

	@Override
	public void m() {
	    MyInterface.super.m(); // Overrides default method.
	}

	/*void m() {} // Cannot apply weaker access privileges, m is already public */
    }

    private static class MyClass extends MyAbstractClass {
	// Uses MyAbstractClass's impl
    }

    private static class MyOtherClass implements MyInterface {
    }

    private static interface InterfaceA {

	default void defaultMethod() {
	    System.out.println("Interface A default method");
	}
    }

    private static interface InterfaceB {

	default void defaultMethod() {
	    System.out.println("Interface B default method");
	}
    }

    private class ImplBoth implements InterfaceA, InterfaceB {

	@Override
	public void defaultMethod() {
	    System.out.println("Impl overridden method");
	    // If this class is to implement InterfaceA and InterfaceB, it MUST also override the shared method.
	}
    }

    private class ImplA implements InterfaceA {
    }

    private class ImplB implements InterfaceB {
    }

    @Test
    public void method() {

	final MyClass myClass = new MyClass();
	myClass.m();
	final MyOtherClass myOtherClass = new MyOtherClass();
	myOtherClass.m();

	new ImplA() {
	}.defaultMethod();

	new ImplB() {
	}.defaultMethod();

	final ImplBoth impl = new ImplBoth();
	impl.defaultMethod();
	
	// https://dzone.com/articles/interface-default-methods-java
    }
}
