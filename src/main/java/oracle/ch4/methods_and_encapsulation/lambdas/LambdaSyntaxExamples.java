package oracle.ch4.methods_and_encapsulation.lambdas;

import java.util.*;

/**
 *
 * @author jevprentice
 */
public class LambdaSyntaxExamples {

    public static void main(String[] args) {
	List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

	for (final Integer n : list) {
	    System.out.println(n);
	}

	for (final Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
	    final Integer n = iterator.next();
	    System.out.println(n);
	}

	list.forEach(n -> System.out.println(n));

	list.forEach(System.out::println);

	//Iterate list
	list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
	for (Integer n : list) {
	    int x = n * n;
	    System.out.println(x);
	}

	//Stream list
	list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
	list.stream().map((x) -> x * x).forEach(System.out::println);
	list.stream().map((x) -> x * x).forEach((x) -> System.err.println(x));
    }
}
