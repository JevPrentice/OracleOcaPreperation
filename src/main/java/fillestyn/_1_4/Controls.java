package fillestyn._1_4;

/**
 *
 * If you define a public class or an interface in a class, its name should match the name
 * of the Java source code file. Also, a source code file can’t define more than one public
 * class or interface.
 *
 * When you use a package or import statement
 * Java files, both the package and import statements apply to all of the
 * classes and interfaces defined in that source code file.
 *
 * Basic declaration of interface with 3 abstract methods only allows declaration of:
 * -> Constants
 * -> Abstract Methods
 *
 * @author fillestyn66
 */
public interface Controls {

    int VOLUME_LEVEL = 0; //constant, the compiler adds final static for interfaces

    public static final int BASS = 10; //also a constant

    void changeChannel(int changeVolume);

    void increaseVolume();

    public abstract void decreaseVolume(); // the compiler adds public abstract for interfaces

}

/**
 * Incorrect class as there is already another public class and the name of this class
 * does not match the name of the file
 *
 * @author fillestyn66
 */
// public class IncorrectClass {}

/*
Allowed to have multiple interfaces/classes in one file
and order is irrelevant
 */
interface RandomInterface {

    //int RANDOM_CONSTANT; //-- This is incorrect. 
    //-- It is a constant so you can not assign a value later --
    int CORRECT_CONSTANT = 29;
}

class RandomClassWithInterface implements RandomInterface {
}

class Piet {
}
