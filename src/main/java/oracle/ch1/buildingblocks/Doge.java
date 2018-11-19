package oracle.ch1.buildingblocks;

/**
 *
 * @author Jev
 */
public class Doge {

    String meme = "Wow!";

    {
	meme += "Much instance initializer blocks ";
    }

    public Doge() {
	meme += " so exciting";
    }

    public static void main(String[] args) {
	final Doge d = new Doge();
	System.out.println(d.meme);
    }

    {
	meme += " very confusing!";

    }
}
