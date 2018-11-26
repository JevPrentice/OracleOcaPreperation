package oracle.ch2.operators;

/**
 * Decision-making structure, value is evaluated and program flow is directed to matching case statement. If no case
 * statement can be matched the 'default' block will execute if it is present.
 *
 * Supported data types: byte, Byte, short, Short, char, Character, int, Integer, enums and String
 * Un-supported data types: boolean, long, Long, double, Double
 *
 * The value used for a switch statement's catch MUST be a "compile time constant" like a literal value or a constant
 * variable (marked as final).
 *
 * The order of the case and default statements does not matter, only remember that when a break not present the switch
 * falls to the next case.
 *
 * Default only runs when none of the case matches, bear in mind default may fall through to other case statements.
 * Case statements can also fall through if there is no break;
 *
 * A return statement can also be used instead of a break; to exit a switch statement.
 *
 * @author jev
 * @since Nov 19, 2018
 */
public class SwitchStatement {

    public SwitchStatement() {
    }

    private void runSwitch(final int value) {
	System.out.println("Execute switch statement for: " + value);
	switch (value) { // OK because value is final.
	    default:
		System.out.println("default");
	    //break; // Omitting break causes the switch to "fall through" to the next case, output is: default\nzero.
	    case 0:
		System.out.println("zero");
		break; // Break is required to not fall through to the next case.
	    case 1:
		System.out.println("one");
		break;
	    case 2:
		System.out.println("two");
		break;
	    case 3:
		System.out.println("three");
		break;
	    case 4:
		System.out.println("four");
		return; // Return is also possible.
	    case 5:
		System.out.println("five");
		break;
	    // Not ok to have duplicate case values.
	    /*case 5:
		System.out.println("five - again");
		break;*/
	}
    }

    public static void main(final String[] args) {
	final SwitchStatement obj = new SwitchStatement();
	obj.runSwitch(1);
	obj.runSwitch(4);
	obj.runSwitch(99);
    }
}
