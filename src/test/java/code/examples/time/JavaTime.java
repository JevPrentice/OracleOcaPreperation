package code.examples.time;

import java.time.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Remember: Java 8 datetime classes are final and immutable.
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class JavaTime {

    public JavaTime() {
    }

    /**
     * {@link Period#toString()}
     */
    @Test
    public void periodToString() {
	final Period p1 = Period.of(0, 0, 0);
	Assert.assertEquals("P0D", p1.toString());

	final Period p2 = Period.of(01, 02, 03);
	Assert.assertEquals("P1Y2M3D", p2.toString());

	final Period p3 = Period.of(1, 0, 0);
	Assert.assertEquals("P1Y", p3.toString());

	final Period p4 = Period.of(0, 1, 0);
	Assert.assertEquals("P1M", p4.toString());

	final Period p5 = Period.of(0, 0, 1);
	Assert.assertEquals("P1D", p5.toString());
    }

    /**
     * {@link LocalDate#toString()}
     */
    @Test
    public void localDateString() {
	Assert.assertEquals("2018-10-18", LocalDate.of(2018, 10, 18).toString());
    }

    /**
     * {@link LocalDateTime#toString()}
     */
    @Test
    public void localDateTimeString() {
	Assert.assertEquals("2018-10-18T18:55", LocalDateTime.of(2018, 10, 18, 18, 55, 000).toString());
    }

    /**
     * {@link LocalTime#toString()}
     */
    @Test
    public void localTimeString() {
	Assert.assertEquals("18:55", LocalTime.of(18, 55, 000).toString());
    }

    /**
     * {@link LocalTime#toString()}
     */
    @Test
    public void localDateTimeNowString() {
	Assert.assertEquals(23, LocalDateTime.now().toString().length()); // 2018-11-18T18:57:04.452
    }
}
