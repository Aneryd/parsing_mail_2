import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class connectURL {
    public static BufferedReader connect(String[] args) throws IOException {
        URL url = new URL("https://www.py4e.com/code3/mbox.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        return in;
    }
}
