package code.examples.encapsulation;

/**
 *
 * @author jev
 * @since Sep 19, 2018
 */
public class DefiningConstructors {

    private static class Animal {

	private final int age;

	public Animal(final int age) {
	    super();
	    this.age = age;
	}

	public int getAge() {
	    return age;
	}
    }

    private static class Zebra extends Animal {

	public Zebra(int age) {
	    super(age); // Calls Animal constructor
	}

	public Zebra() {
	    this(4); // Calls Zebra int constructor
	}
    }

    /**
     * These 3 donkeys will work exactly the same after Java has compiled the source code.
     */
    private static class UnderstandingCompilerEnhancements {

	/**
	 * A default constructor, with a call to super() will be added.
	 */
	class Donkey_1 {
	}

	/**
	 * A call to super will be added to this constructor.
	 */
	class Donkey_2 {

	    public Donkey_2() {
	    }
	}

	/**
	 * No modifications needed by compiler.
	 */
	class Donkey_3 {

	    public Donkey_3() {
		super();
	    }
	}
    }

    /**
     * Be wary of any exam question in which the parent class defines a
     * constructor that takes arguments and doesn’t define a no-argument constructor,
     * be sure to check that the code compiles before answering a question about it.
     */
    private static class ParentWithoutNoArgumentConstructor {

	/**
	 * Mammal already has a constructor declared, so a default constructor will not be added by the compiler.
	 */
	private static class Mammal {

	    public Mammal(int age) {
	    }
	}

	/**
	 * Since Elephant extends Mammal and Mammal has a non default constructor, Elephant NEEDS to have a constructor
	 * that makes a correct call to Mammal's constructor using super(int);
	 */
	private static class Elephant extends Mammal {

	    public Elephant() {
		super(0);
	    }
	}
    }
}
