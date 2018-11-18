package code.examples.encapsulation;

/**
 * https://stackoverflow.com/questions/17510152/why-cant-we-assign-weaker-privilege-in-subclass
 * https://en.wikipedia.org/wiki/Liskov_substitution_principle
 * http://java2career.com/2015/05/error-weaker-access-privileges.html
 * The point is that polymorphism in Java (and other programming languages) relies on you being able to treat an
 * instance of a subclass as if it was an instance of the superclass. But if the method is restricted in the subclass,
 * you find that the compiler cannot figure out whether the access rules allow a method to be called ...
 *
 * Polymorphism in Java relies on you being able to treat an instance of a subclass as if it was an instance
 * of the superclass. But if the method is restricted in the subclass, you find that the compiler cannot
 * figure out whether the access rules allow a method to be called.
 *
 *
 * @author jev
 * @since Aug 26, 2018
 */
abstract class Player {

    protected void play() {
    }

    abstract void run();

}

class FootballPlayer extends Player {

    @Override
    void run() { // Its ok to change run from public to protected
	// Must override.
    }

    @Override
    protected void play() {
	super.play();
	// Can override.
    }

    // Player.play is already protected, cannot assign weaker privliges.
    //void play() {super.play();} // Not ok, to change play from protected to public.
}
