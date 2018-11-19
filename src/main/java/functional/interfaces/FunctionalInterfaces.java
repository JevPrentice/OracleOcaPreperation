package functional.interfaces;

import java.io.IOException;
import java.util.Collection;
import java.util.function.Consumer;

/**
 *
 * @author Jev
 */
class Person {

    private String name;

    public Person() {
	name = "asd";
    }

    public String getName() {
	return name;
    }

}

@FunctionalInterface
interface ThrowingConsumer<T> extends Consumer<T> {

    @Override
    default void accept(final T elem) {
	try {
	    acceptThrows(elem);
	} catch (final Exception e) {
	    // Implement your own exception handling logic here..
	    // For example:
	    System.out.println("handling an exception...");
	    // Or ...
	    throw new RuntimeException(e);
	}
    }

    void acceptThrows(T elem) throws IOException;

}

public class FunctionalInterfaces {

    final Consumer<Object> consumer = aps -> {
	try {

	    // maybe some other code here...
	    throw new Exception("asdas");
	} catch (final Exception ex) {
	    System.out.println("handling an exception...");
	}
    };

    public FunctionalInterfaces() {
	//Stream.of("1", "2", "3").forEach(consumer);
	final Collection<Person> people = null;

	people.stream().forEach(consumer);

	final ThrowingConsumer<Person> throwingConsumer = aps -> {
	    // maybe some other code here...
	    throw new IOException("asdas");
	};

	people.stream().forEach(throwingConsumer);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	FunctionalInterfaces functionalInterfaces = new FunctionalInterfaces();
    }

}
