package code.examples;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jev
 */
public class SimpleThread {

    public SimpleThread() {
    }

    private static class MyRunnable implements Runnable {

	@Override
	public void run() {
	    try {
		System.out.println("Sleeping in my runnable");
		Thread.sleep(5000);
		System.out.println("Woke up in my runnable");
	    } catch (final InterruptedException ex) {
		Logger.getLogger(SimpleThread.MyRunnable.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    public void method() {
	final Thread t1 = new Thread() {
	    @Override
	    public void run() {
		try {
		    System.out.println("Sleeping in anonymous thread");
		    Thread.sleep(5000);
		    System.out.println("Woke up in anonymous thread");
		} catch (final InterruptedException ex) {
		    Logger.getLogger(SimpleThread.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	};
	final Thread t2 = new Thread(new MyRunnable());
	final Thread t3 = new Thread(() -> {
	    try {
		System.out.println("Sleeping in lambda");
		Thread.sleep(5000);
		System.out.println("Woke up in lambda");
	    } catch (final InterruptedException ex) {
		Logger.getLogger(SimpleThread.class.getName()).log(Level.SEVERE, null, ex);
	    }
	});

	t1.start();
	t2.start();
	t3.start();

	try {
	    t1.join();
	    t2.join();
	    t3.join();
	} catch (final InterruptedException ex) {
	    Logger.getLogger(SimpleThread.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public static void main(final String[] args) {
	new SimpleThread().method();
    }
}
