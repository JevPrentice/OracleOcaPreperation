package oracle.ch4.methods_and_encapsulation;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jev
 */
public class WorkingWithVarargs {
    // A vararg parameter must be the last element in a method’s parameter list.
    // This implies you are only allowed to have one vararg parameter per method.

    //public void walk1(int... nums) {}
    //public void walk2(int start, int... nums) {}
    //public void walk3(int... nums, int start) { } // DOES NOT COMPILE
    //public void walk4(int... start, int... nums) { } // DOES NOT COMPILE

    /*
     *   walk1() is a valid method declaration with one vararg parameter.
     *	 walk2() is a valid method declaration with one int parameter and one vararg parameter. 
     *   walk3() and walk4() do not compile because they have a vararg parameter in a position that is not the last one.
     */
    public static void walk(int start, int... nums) {

	final int numsLength = (nums != null) ? nums.length : 0;
	final String numsString = Arrays.toString(nums);
	System.out.println(String.format("Walk start=%s, nums=%s, length=%s", start, numsString, numsLength));

	//Dangerous to use asList on varargs, lookout for primitive vs wrapper types like int[] / Integer[]
	List<int[]> asList = Arrays.asList(nums);
	for (int[] is : asList) {
	    System.out.println(Arrays.toString(is)); // Outputs null when nums is null.
	}
    }

    public static void main(String[] args) {
	walk(1);
	walk(1, 2);
	walk(1, 2, 3);
	walk(1, new int[]{4, 5});
	walk(1, null);
    }
}
