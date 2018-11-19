package fillestyn._4_2;

/*
Java defines four access modifiers:
-> public (least restrictive)
-> protected
-> default
-> private (most restrictive)

Classes/Interfaces  --> public,default
Attributes          --> public,protected,default,private
Methods             --> public,protected,default,private
Contructors         --> public,protected,default,private

Default Access Modifier - No keyword:
--------------------------------------
Default access modifier means we do not explicitly declare an access modifier for a class, field, method, etc.
A variable or method declared without any access control modifier is available to any other class in the same package. 
The fields in an interface are implicitly public static final and the methods in an interface are by default public.
* Dont confuse with the 'default' keyword in Java, which is something else.

Private Access Modifier - private:
--------------------------------------
Methods, Variables and Constructors that are declared private can only be accessed within the declared class itself.
Private access modifier is the most restrictive access level. Class and interfaces cannot be private.

Public Access Modifier - public:
--------------------------------------
A class, method, constructor, interface etc declared public can be accessed from any other class. 
Therefore fields, methods, blocks declared inside a public class can be accessed from any class belonging to the Java Universe.
However if the public class we are trying to access is in a different package, then the public class still need to be imported.

Protected Access Modifier - protected:
---------------------------------------
Variables, methods and constructors which are declared protected in a superclass can be accessed only 
by the subclasses in other package or any class within the package of the protected members' class.
The protected access modifier cannot be applied to class and interfaces. 
Methods, fields can be declared protected, however methods and fields in a interface cannot be declared protected.



Access Levels - Visility of variables
-------------------------------------------------------
Modifier	|Class	|Package    |Subclass   |World(Another Package)
----------------|-------|-----------|-----------|-----
public          |Y	|Y          |Y          |Y
protected	|Y	|Y          |Y          |N
no modifier	|Y	|Y          |N          |N
private         |Y	|N          |N          |N
-------------------------------------------------------
 */
import fillestyn._4_1_2.Book;
//import one._4_1_1.House; //-- Cannot import house from this package it has default scope.

/**
 * @author fillestyn66
 */
public class AccessModifiers extends Book {

    Book book = new Book(); // -- Can import Book as it is publc
    // House house = new House() // --Wrong default access

    AccessModifiers() {

    }

    protected void test() {
	// -- PUBLIC
	book.noOfBooks = 10; // Can access noOfBooks directly as it is declared public
	//book.authorName = "Piet"; // -- Cannot access authorName as it is protected
	// -- PROTECTED
	authorName = "Piet"; // -- Can access the protected field through inheritence
	// -- PRIVATE
	//book.costOfBook = 345.99; // -- Cannot access costOfBook as it has private scope
	System.out.println("COST OF BOOK : " + getCostOfBook()); // -- can access field though inherited getter with protected scope.
	// --- DEFAULT
	//book.tital = "The new Trials and Tribulations of the Karp"; // -- Cannot access with default scope
	//tital = "The new Trials and Tribulations of the Karp"; // -- Cannot access even with inheritance

    }
}
