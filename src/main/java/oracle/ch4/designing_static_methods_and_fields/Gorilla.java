package oracle.ch4.designing_static_methods_and_fields;

/**
 * @author jev
 */
public class Gorilla {

    public static int count;

    public static void addGorilla() {
	count++;
    }

    public void babyGorilla() {
	count++;
    }

    public void announceBabies() {
	addGorilla();
	babyGorilla();
    }

    public static void announceBabiesToEveryone() {
	addGorilla();
	//babyGorilla(); // DOES NOT COMPILE - because a static method cannot call an instance method
    }

    public int total;
    //public static average  = total / count; // DOES NOT COMPILE - because a static variable is trying to use an instance variable.

}
