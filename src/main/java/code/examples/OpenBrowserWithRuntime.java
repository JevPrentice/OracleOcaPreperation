package code.examples;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author jev
 * @since Nov 6, 2018
 */
public class OpenBrowserWithRuntime {

    public static void main(final String[] args) throws URISyntaxException, IOException {
	Runtime.getRuntime().exec("open " + new URI("https://google.com"));
    }
}
