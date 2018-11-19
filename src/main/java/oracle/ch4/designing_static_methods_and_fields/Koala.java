package oracle.ch4.designing_static_methods_and_fields;

/**
 * Static methods don’t require an instance of the class. They are shared among
 * all users of the class. You can think of statics as being a member of the
 * single class object that exist independently of any instances of that class.
 *
 * Does Each Class Have Its Own Copy of the Code? Each class has a copy of the
 * instance variables. There is only one copy of the code for the instance
 * methods. Each instance of the class can call it as many times as it would
 * like. However, each call of an instance method (or any method) gets space on
 * the stack for method parameters and local variables. The same thing happens
 * for static methods. There is one copy of the code. Parameters and local
 * variables go on the stack. Just remember that only data gets its “own copy.”
 * There is no need to duplicate copies of the code itself.
 *
 * @author jev
 */
public class Koala {

    public static int count = 0; // static variable 

    public static void main(String[] args) {// static method
	System.out.println(count);
    }
}
