package code.examples;

import java.util.Map.Entry;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;

/**
 * Uses Collectors.partitioningBy to split an array into two segments. For each segment a simple strategy is provided.
 *
 * @author jev
 * @since Nov 7, 2018
 */
public class PartitionAndProcessStream {

    private static class TrueProcessor implements Runnable {

	private final List<Integer> values;

	public TrueProcessor(final List<Integer> values) {
	    this.values = Objects.requireNonNull(values);
	}

	@Override
	public void run() {
	    System.out.println("True:" + values);
	}

    }

    private static class FalseProcessor implements Runnable {

	private final List<Integer> values;

	public FalseProcessor(final List<Integer> values) {
	    this.values = Objects.requireNonNull(values);
	}

	@Override
	public void run() {
	    System.out.println("False:" + values);
	}
    }

    public static void main(final String[] args) {
	final Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

	final Predicate<Integer> predicate = i -> i % 2 == 0;
	final Collector<Integer, ?, Map<Boolean, List<Integer>>> collector = Collectors.partitioningBy(predicate);
	final Function<Entry<Boolean, List<Integer>>, Runnable> mapper
		= (final Entry<Boolean, List<Integer>> entry) -> {
		    return entry.getKey() ? new TrueProcessor(entry.getValue()) : new FalseProcessor(entry.getValue());
		    /*if (entry.getKey())
			return (Runnable) () -> {
			    System.out.println("True:" + entry.getValue());
			};
		    else
			return (Runnable) () -> {
			    System.out.println("False:" + entry.getValue());
			};*/
		};

	final Stream<Entry<Boolean, List<Integer>>> stream = Stream.of(array).collect(collector).entrySet().stream();

	stream
		//.filter(Entry::getKey)
		.map(mapper)
		.forEach(Runnable::run);
    }
}
