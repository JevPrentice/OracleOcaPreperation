package code.examples.generics;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class PolymorphismAndGenerics {

    private static abstract class Animal {
    }

    private static class Dog extends Animal {
    }

    private static class Cat extends Animal {
    }

    public PolymorphismAndGenerics() {
    }

    @Test
    public void method() {
	final Dog dog = new Dog();
	final Animal animal = new Dog(); // Normal polymorphism, a dog is always an animal
	/*final Dog c = new Animal() {};*/ // An animal is not always a dog, e.g cat.

	final List<Animal> animalList = new ArrayList<>();
	final List<Dog> dogList = new ArrayList<>();

	//Parameterized types are not polymorphic, this means ArrayList<Animal> is not super type of ArrayList<Dog>
	//final List<Animal> list = new ArrayList<Dog>(); // Normal polymorphism does not apply for generics.
	//list.add(0, new Dog());
    }
}
