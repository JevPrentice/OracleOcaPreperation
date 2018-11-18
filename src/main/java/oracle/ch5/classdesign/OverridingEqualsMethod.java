package oracle.ch5.classdesign;

import java.util.ArrayList;

/**
 *
 * @author jevprentice
 */
public class OverridingEqualsMethod {

    public static void main(String[] args) throws Throwable {

	final ArrayList<String> list = new ArrayList<>();

	final Obj o1 = new Obj();
	o1.i = 1;
	final Obj o2 = new Obj();
	o2.i = 1;

	System.out.println(o1 == o2);
	System.out.println(o1.equals(o2));

	boolean x = false;
	if (x == true) {
	    System.out.println("x == true");
	} else {
	    System.out.println("x == false");
	}

    }

}

class Obj extends Object {

    int i;

    @Override
    public boolean equals(Object obj) {
	if (obj instanceof Obj) {
	    Obj b = (Obj) obj;
	    return (i == b.i);
	} else {
	    return false;
	}
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 23 * hash + this.i;
	return hash;
    }
}
