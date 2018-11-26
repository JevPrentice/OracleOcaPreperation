package code.examples;

/**
 * Deadlock describes a situation where two or more threads are blocked forever, waiting for each other. Deadlocks can
 * occur in Java when the synchronized keyword causes the executing thread to block while waiting to get the lock,
 * associated with the specified object. Since the thread might already hold locks associated with other objects, two
 * threads could each be waiting for the other to release a lock. In such case, they will end up waiting forever.
 * 
 * cd .../workspace/OracleOcaPreperation
 * java -cp target/classes/ code.examples.DeadlockScenario
 *
 * @author jev
 * @since Nov 19, 2018
 */
public class DeadlockScenario {

    final Object obj1 = new Object() {
	@Override
	public String toString() {
	    return "Object 1";
	}
    };

    final Object obj2 = new Object() {
	@Override
	public String toString() {
	    return "Object 2";
	}
    };

    final Thread t1 = new Thread(() -> {

	final String label = "t1";

	while (true) {
	    synchronized (obj1) {
		synchronized (obj2) {
		    System.out.println(label + ": " + obj1.toString() + " - " + obj2.toString());
		}
	    }
	}

    });

    final Thread t2 = new Thread(() -> {
	final String label = "t2";
	while (true) {
	    synchronized (obj1) {
		synchronized (obj2) {
		    System.out.println(label + ": " + obj1.toString() + " - " + obj2.toString());
		}
	    }
	}

    });

    public static void main(String a[]) {
	final DeadlockScenario deadlockScenario = new DeadlockScenario();
	deadlockScenario.t1.start();
	deadlockScenario.t2.start();
    }
}
