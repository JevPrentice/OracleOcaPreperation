package oracle.ch1.imports;

// Both of these lines result in an ambiguous import.
import java.sql.Date;

/**
 *
 * @author Jev
 */
public class JavaSqlAndUtilDates {

    public static void main(String m[]) {
	Date d; // This is a Java SQL date because the sql package appears first.

	java.sql.Date sqlDate;
	java.util.Date utilDate;
    }
}
