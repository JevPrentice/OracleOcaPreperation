package fillestyn._1_3;

import fillestyn._0.random.Athlete;
import fillestyn._0.random.Person;

/**
 * Class declaration is made up of :
 * - Access modifiers
 * - Non-access modifiers
 * - Class name
 * - Name of the base class, if the class is extending another class
 * - All implemented interfaces, if the class is implementing any interfaces
 * - Class body (class fields/attributes, methods, constructors), included within a pair of curly braces, {}
 *
 * -- Compulsory --
 * -> Keyword class
 * -> Name of the class
 * -> Class body, marked by the opening and closing curly braces, {}
 *
 * -- Optional --
 * -> Access modifier, such as public
 * -> Non-access modifier, such as final
 * -> Keyword extends together with the name of the base class
 * -> Keyword implements together with the name
 * of the interfaces being implemented
 *
 * Building for class :
 * -> instance variables / instance variables
 * -> methods
 * -> constructors
 *
 * @author fillestyn66
 */
public final class Runner extends Person implements Athlete {

    public Runner() {
	// Constructor for Runner
    }

    @Override
    public void runFast() {
	// Do some fast running
    }
}
