package oracle.ch4.methods_and_encapsulation;

/**
 * Java access privileges: https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
 * private: Only accessible within the same class
 * default (package private) access: private and other classes in the same package protected: default access and child
 * classes
 * public: protected and classes in the other packages
 *
 * @author jev
 */
public class ApplyingAccessModifiers_Private {

    // Assuming these classes are inside different files but the same package pond.duck
    //package pond.duck;
    public class FatherDuck {

	private String noise = "quack";

	private void quack() {
	    System.out.println(noise);
	}

	private void makeNoise() {
	    quack();
	}
    }

    //package pond.duck;
    public class BadDuckling {

	public void makeNoise() {
	    FatherDuck duck = new FatherDuck();
	    // duck.quack(); // does not compile
	    // System.out.println(duck.noise); // does not compile
	}
    }
}
