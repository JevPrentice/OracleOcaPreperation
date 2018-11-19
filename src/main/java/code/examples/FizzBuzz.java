package code.examples;

import java.util.Objects;
import java.util.Optional;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * For a range of values print out...
 * Multiple of 3: fizz.
 * Multiple of 5: fizz.
 * Multiple of 3 and 5: fizzbuzz.
 * Otherwise skip.
 *
 * @author Jev
 */
public class FizzBuzz {

    private static class FizzBuzzStrategyFactory implements IntFunction<Optional<Supplier<String>>> {

	private static abstract class AbstractFizzBuzzFactory implements Supplier<String> {

	    private final int i;
	    private final String type;

	    public AbstractFizzBuzzFactory(final int i, final String type) {
		this.i = i;
		this.type = Objects.requireNonNull(type);
	    }

	    @Override
	    public String get() {
		return i + ": " + type;
	    }
	}

	private static class FizzFactory extends AbstractFizzBuzzFactory {

	    public static final String TYPE = "fizz";

	    public FizzFactory(final int i) {
		super(i, TYPE);
	    }
	}

	private static class BuzzFactory extends AbstractFizzBuzzFactory {

	    public static final String TYPE = "buzz";

	    public BuzzFactory(final int i) {
		super(i, TYPE);
	    }
	}

	private static class FizzBuzzFactory extends AbstractFizzBuzzFactory {

	    public static final String TYPE = "fizzbuzz";

	    public FizzBuzzFactory(final int i) {
		super(i, TYPE);
	    }
	}

	private FizzBuzzStrategyFactory() {
	}

	private static boolean isMultiple(final int a, final int b) {
	    return a % b == 0;
	}

	@Override
	public Optional<Supplier<String>> apply(final int i) {
	    final boolean three = isMultiple(i, 3);
	    final boolean five = isMultiple(i, 5);
	    if (three && five) {
		return Optional.of(new FizzBuzzFactory(i));
	    } else if (three) {
		return Optional.of(new FizzFactory(i));
	    } else if (five) {
		return Optional.of(new BuzzFactory(i));
	    } else {
		return Optional.empty();
	    }
	}
    }

    /**
     * @param args The command line arguments
     */
    public static void main(final String[] args) {
	final IntFunction<Optional<Supplier<String>>> mapper = new FizzBuzzStrategyFactory();
	IntStream.range(1, 100)
		.mapToObj(mapper)
		.filter(Optional::isPresent)
		.map(Optional::get)
		.map(Supplier::get)
		.forEachOrdered(System.out::println);
    }
}
