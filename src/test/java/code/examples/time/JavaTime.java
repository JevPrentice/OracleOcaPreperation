package code.examples.time;

import java.time.*;
import java.util.*;
import org.junit.Assert;
import org.junit.Test;

/* 
 *
 * Remember that not all the Java 8 date time classes have the same methods.
 *
 * Methods in LocalDate, LocalTime, and LocalDateTime:
 *				Can call on || Can call on || Can call on
 *				LocalDate?  || LocalTime?  || LocalDateTime?
 * plusYears/minusYears		Yes		    No		Yes
 * plusMonths/minusMonths	Yes		    No		Yes
 * plusWeeks/minusWeeks		Yes		    No		Yes
 * plusDays/minusDays		Yes		    No		Yes
 * plusHours/minusHours		No		    Yes		Yes
 * plusMinutes/minusMinutes	No		    Yes		Yes
 * plusSeconds/minusSeconds	No		    Yes		Yes
 * plusNanos/minusNanos		No		    Yes		Yes
 */
/**
 * Remember: Java 8 datetime classes are final and immutable.
 *
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
	final LocalDate d = LocalDate.of(2018, 10, 18);
	Assert.assertEquals("2018-10-18", d.toString());
	Assert.assertEquals(18, d.getDayOfMonth());
	Assert.assertEquals(10, d.getMonthValue());
	Assert.assertEquals("OCTOBER", d.getMonth().toString()); // Its all caps.
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

    @Test
    public void localDatePlus() {

	final LocalDate _12Oct1492_ = LocalDate.of(1492, Month.OCTOBER, 12);
	_12Oct1492_.plusDays(800); // Localdate is immutable, this does nothing.

	final LocalDate plusDays = _12Oct1492_.plusDays(800);

	Assert.assertEquals("1492-10-12", _12Oct1492_.toString());
	Assert.assertEquals("1494-12-21", plusDays.toString());

	// Careful, this is a LocalTime not LocalDate
	// LocalTime localDate = LocalTime.now().plusDays(800);
    }

    @Test
    public void loopPeriodWhileBefore() {
	final Period everyWeek = Period.ofWeeks(1);
	Assert.assertEquals("P7D", everyWeek.toString());
	final LocalDate start = LocalDate.now();
	final LocalDate end = start.plusYears(1);
	LocalDate i = start;
	while (i.isBefore(end)) {
	    System.out.println(i);
	    i = i.plus(everyWeek);
	}
    }

    public void workingWithDateAndTimes1() {

	/* Creating Dates and Times */
	System.out.println(LocalDate.now());
	System.out.println(LocalTime.now());
	System.out.println(LocalDateTime.now());

	LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
	LocalDate date2 = LocalDate.of(2015, 1, 20);

	LocalTime time1 = LocalTime.of(6, 15); // hour and minute
	LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
	LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds

	LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
	LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);

	/* DOES NOT COMPILE */
	//LocalDate d = new LocalDate(); // There is no public constructor for these classes, has factory methods.
	try {
	    LocalDate.of(2015, Month.JANUARY, 32);// throws DateTimeException 
	} catch (Exception e) {
	    e.printStackTrace(System.out);
	}

	/* Manipulating Dates and Times */
	Calendar c = Calendar.getInstance();
	c.set(2015, Calendar.JANUARY, 1);
	// c4.set(2015, 0, 1);
	Date jan = c.getTime();

	Calendar c2 = new GregorianCalendar(2016, 07, 24, 15, 38);
	Calendar c3 = new GregorianCalendar(2015, Calendar.JANUARY, 1);

	Date jan2 = c3.getTime();

	LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
	date = date.plusDays(2);
	date = date.plusWeeks(1);
	date = date.plusMonths(1);
	date = date.plusYears(5);
	System.out.println(date);

	LocalDate date3 = LocalDate.of(2020, Month.JANUARY, 20);
	LocalTime time = LocalTime.of(5, 15);
	LocalDateTime dateTime = LocalDateTime.of(date, time);
	dateTime = dateTime.minusDays(1);
	dateTime = dateTime.minusHours(10);
	dateTime = dateTime.minusSeconds(30);
	System.out.println(dateTime);

	LocalDate date4 = LocalDate.of(2020, Month.JANUARY, 20);
	LocalTime time4 = LocalTime.of(5, 15);
	LocalDateTime dateTime3 = LocalDateTime.of(date2, time)
		.minusDays(1).minusHours(10).minusSeconds(30);

	LocalDate date5 = LocalDate.of(2020, Month.JANUARY, 20);
	date.plusDays(10);
	System.out.println(date5);

	LocalDate date6 = LocalDate.of(2020, Month.JANUARY, 20);
	//date = date.plusMinutes(1); // DOES NOT COMPILE
    }
}
