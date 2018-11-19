package code.examples.array;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class SplitSingleElement {

    public SplitSingleElement() {
    }

    @Test
    public void method() {
	final String value = "One";
	final List<String> list = Arrays.asList(value.split(","));
	Assert.assertEquals("[One]", list.toString());
    }
}
