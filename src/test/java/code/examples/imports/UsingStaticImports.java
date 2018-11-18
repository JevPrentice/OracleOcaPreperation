package code.examples.imports;

import java.util.Arrays;
import org.junit.Test;

import static java.util.Arrays.asList;

/**
 *
 * @author jev
 * @since Sep 3, 2018
 */
public class UsingStaticImports {

    public UsingStaticImports() {
    }

    @Test
    public void test() {
	Arrays.asList("one"); // -> import java.util.Arrays;
	asList("one"); // -> import static java.util.Arrays.asList;
    }
}
