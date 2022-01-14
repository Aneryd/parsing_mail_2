import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class MeanXDSPAM {
    public static void main(String args[]) throws IOException {
        xdspam();
    }

    public static void xdspam() throws IOException {
        URL url = new URL("https://www.py4e.com/code3/mbox.txt");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream())
        );

        String inputLine;
        Float xdspam_len=0f;
        Float xdspam_sum=0f;
        Float answer_xds = 0f;
        while((inputLine = in.readLine()) != null){
            StringBuilder xd = new StringBuilder();
            StringBuilder xds = new StringBuilder();
            if(inputLine.length() > 26){
                for (int i=0; i<=19; i++){
                    xd.append(inputLine.charAt(i));
                }
                for(int i=20; i<=26; i++){
                    xds.append(inputLine.charAt(i));
                }
                if(xd.toString().equals("X-DSPAM-Probability:")){
                    xdspam_len += 1;
                    xdspam_sum += Float.valueOf(xds.toString());
                }
            }
        }
        answer_xds = xdspam_sum / xdspam_len;
        System.out.println("Среднее значение X-DSPAM-Probability = " + answer_xds.toString());
        in.close();
    }
}
