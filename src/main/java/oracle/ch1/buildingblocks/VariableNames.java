package oracle.ch1.buildingblocks;

/**
 *
 * @author Jev
 */
public class VariableNames {

    public static void main(String[] args) {
	int x, z = 1;
	System.out.println("z=" + z);

	int $1;

	int $_1$ = -(5);
	$_1$ -= -$_1$++ * -(--$_1$);
	System.out.println("$_1$=" + $_1$);
    }
}
