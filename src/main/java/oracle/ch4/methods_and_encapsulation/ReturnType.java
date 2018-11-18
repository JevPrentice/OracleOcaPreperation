package oracle.ch4.methods_and_encapsulation;

/**
 * A method must have a return type. If no value is returned, the return type is void. You cannot omit the return type.
 *
 * @author jev
 */
public class ReturnType {

    public void walk1() {
    }

    public void walk2() {
	return; // Unnecessary.
    }

    public String walk3() {
	return "";
    }

    //public String walk4() {} // DOES NOT COMPILE, no return value.
    //public walk5() {} // DOES NOT COMPILE, no return type.

    /*String walk6(int a) {
        if (a == 4) {
            return "";
        }
    } */ // DOES NOT COMPILE, does not always return
    int integerFunction() {
	return 9;
    }

    int longFunction() {
	//return 9L; // DOES NOT COMPILE
	return (int) 9L; //Cast the long to an int first
    }

    int integerExpanded() {
	int temp = 9;
	return temp;
    }

    int longExpanded() {
	//int temp = 9L; // DOES NOT COMPILE
	int temp = (int) 9L; // cast it
	return temp;
    }
}
