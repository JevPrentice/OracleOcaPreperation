package fillestyn._2_1;

/**
 * This main method should comply with the following rules:
 * -> The method must be marked as a public method.
 * -> The method must be marked as a static method.
 * -> The name of the method must be main .
 * -> The return type of this method must be void .
 * -> The method must accept a method argument of a String array or a variable argument of type String.
 *
 * @author fillestyn66
 */
public class ExecutableHelloExam {

    //----- If this is run on the commandline -->    java ExecutableHelloExam One Two
    public static void main(String args[]) {
	System.out.println("Hello exam");
	System.out.println(args[0]);// Prints --> One
	System.out.println(args[1]);// Prints --> Two
    }

    // public static void main(String... args){} //-- Valid Declaration --
    // public static void main(String[] args){} //-- Valid Declaration --
    // public static void main(String args...){} // -- Incorrect --
    // -- Valid 
    // public static void main(String[] arguments){}
    // public static void main(String[] HelloWorld){}
    // -- public and static is interchangeable
    // public static void main(String[] args){}
    //static public void main(String[] args){}
    // --
    /**
     * Example to illustrate varArgs
     *
     * @param strings
     */
    private void varArgs(String... strings) {
	for (String string : strings) {
	    System.out.println("value : " + string);
	}
    }

    private void testVarArgs() {
	varArgs("Good Times", "Not so Good Times");
	varArgs(new String[]{"A", "B", "C"});
    }
}
