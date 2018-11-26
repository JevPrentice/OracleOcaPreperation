package fillestyn._4_3;

/*
You can characterize your classes, interfaces, methods, 
and variables with the following nonaccess modifiers 
(though not all are applicable to each Java entity):

Nonaccess Modifiers :
--> abstract
--> static
--> final
--> synchronized
--> native
--> strictfp
--> transient
--> volatile

Exam covers only three of these nonaccess modifiers: 
abstract , final , and static

abstract --> classes, interfaces (redundant), methods
final    --> classes, methods, variables
static   --> methods, variables
 */
public final class NonAccessModifiers {

    private final int ranNo = 25;
    // static private int no = count(); //Not allowed, 
    //static members cannot access non-static members in the class, but the reverse is true
    static private int no = staticCount(); // Allowed as member is now static

    final PersonK personK = new PersonK();
    //AbsPerson personK = new AbsPerson(); // -- Not allowed to instanciate an abstract class

    private int getStaticVariableFightLevel() {
	return Fighter.FIGHT_LEVEL;
    }

    private void checkStaicMethod() {
	AbsPerson.getAnswerTo2Plus2(); // -- Access static method directly from class declaration
	personK.getAnswerTo2Plus2(); // -- Access static through instance variable (Frowned apon, but allowed)
	// AbsPerson.getAnswerTo3Plus3(); // -- Irrespective of static the private scope still holds.
    }

    private void checkFinalVariables() {
	// ranNo = 13; //-- Wrong cannot assign a final primitive variable
	// personK = new PersonK(); //-- Cannot reassign what personK is pointing to
	personK.setName("Piet"); //-- But can change the contents of the object (But not the memory location)
    }

    private int count() {
	return 30;
    }

    private static int staticCount() {
	return 30;
    }

}

//class TestFinalInheritance extends NonAccessModifiers{} // Cannot extend a class that is final

/*
Note the abstract here is redundant (But still allowed)... 
An interface is always purely abstract and 
all methods declared in an interface is always public abstract methods
 */
abstract interface Fighter {

    int FIGHT_LEVEL = 10; // same as public static final int FIGHT_LEVEL  = 10;

    void punch();

    void kick(); // the compiler changes this to: 
    //public abstract void kick();     
//  void roundHouse(){int x = 0;} // Not allowed as methods are always abstract with no implementation      
}

/*
Note a non-abstract class has to implement the abstract methods unless
the class is abstract as well
 */
class PersonA implements Fighter {

    @Override
    public void punch() {
	System.out.println("PUNCH");
    }

    @Override
    public void kick() {
	System.out.println("KICK");
    }

}

/* ???? Things to do here would be to play with 
the amount of methods and etc.. ??? */
abstract class AbsPerson implements Fighter {

    /*
    Note Abstract class does not have to provide any implemetation for inherited
    abstract methods
     */

    public void sayName() {
	System.out.println("John Snow");
    }

    abstract public String getName(); // Notice the order or public abstract etc...
    //public abstract String getName(); // The order changes but is still valid.

    public final String getSurname() {
	return "Snow";
    }

    public static int getAnswerTo2Plus2() {
	return 2 + 2;
    }

    private static int getAnswerTo3Plus3() {
	return 3 + 3;
    }
}

/*
First non-abstract class has to implement all inherited abstract methods
 */
class PersonK extends AbsPerson {

    private String name = "John";

    @Override
    public String getName() {
	return name;
    }

    @Override
    public void punch() {
	System.out.println("PUNCH K");
    }

    @Override
    public void kick() {
	System.out.println("KICK K");
    }

    public void setName(String name) {
	this.name = name;
    }

    // public final String getSurname(){} // Cannot Override a final inherited method.
}
