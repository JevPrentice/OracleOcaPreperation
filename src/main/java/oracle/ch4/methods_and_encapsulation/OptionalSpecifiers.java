package oracle.ch4.methods_and_encapsulation;

/**
 *
 * Optional Specifiers:
 * static - Used for class methods.
 * abstract - Used when not providing a method body.
 * final - Used when a method is not allowed to be overridden by a subclass.
 * synchronized - On the OCP but not the OCA exam.
 * native Not on the OCA or OCP exam. Used when interacting with code written in another language such as C++.
 * strictfp Not on the OCA or OCP exam. Used for making foating-point calculations portable.
 *
 * @author jev
 */
public class OptionalSpecifiers {

    public void walk1() {
    }

    public final void walk2() {
    }

    public static final void walk3() {
    }

    public final static void walk4() {
    }

    //public modifier void walk5() {} // DOES NOT COMPILE
    //public void final walk6() {} // DOES NOT COMPILE 
    final public void walk7() {
    }
}
