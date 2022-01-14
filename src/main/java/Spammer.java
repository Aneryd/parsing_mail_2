import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

public class Spammer {
    public static void main(String args[]) throws IOException {
        String[] answer = paymentSpamm.payment(args);
        for(int i=0; i<answer.length; i++){
            if(answer[i] != null){
                System.out.println(answer[i]);
            }
        }
    }
}
