package code.examples;

/**
 *
 * @author jev
 * @since Nov 22, 2018
 */
public class LabeledCodeBlock {

    public static void main(final String[] args) {
	int i = 3;

	MY_LABEL:
	{
	    System.out.println("Inside block");
	    i++;
	    if (i == 4)
		break MY_LABEL;
	    System.out.println("unreachable");
	}

	System.out.println("Outside block");
    }
}
