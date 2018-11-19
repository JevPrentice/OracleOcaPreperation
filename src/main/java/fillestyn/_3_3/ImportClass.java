package fillestyn._3_3;

/* Invalid ambiguous import for Date
import java.util.Date;
import java.sql.Date;
-- */
// -- Both these are valid if you want to import Date
//import java.util.Date;
//import java.util.*;
// --
//-- You can’t import classes from a subpackage by using an asterisk in the import statement.
// -- e.g. java.* != java.util.Date

/*
Unlike in C or C++, importing a class doesn’t add to the size of a Java .class file. An
import statement enables Java to refer to the imported classes without embedding
their source code in the target .class file.
 */
//import RandomClassOnDefaultPackage; // <-- DEFAULT PACKAGE
/* --
Not defining a package means the class is in the default package
and classes in the default package can use each other without import statements

A class from a default package can’t be used in any named packaged class regardless
 */

 /*
You can import an individual static member of a class or all its static members by
using the import static statement.
 */
import static fillestyn._0.random.TestStatic.addTwoNumbers;
import static fillestyn._0.random.TestStatic.person;
// import static one._0.random.TestStatic.*; //-- Can also import all static members with wild card

/**
 * @author fillestyn66
 */
public class ImportClass {

    public void sayHisName() {
	person.sayMyName();
    }

    int addTwoNumbersAgain(int a, int b) {
	return addTwoNumbers(20, 30);
    }
}
