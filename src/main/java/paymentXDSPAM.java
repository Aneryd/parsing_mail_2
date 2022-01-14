import java.io.BufferedReader;
import java.io.IOException;

public class paymentXDSPAM {
    public static Float payment(String[] args) throws IOException {
        BufferedReader in = connectURL.connect(args);

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
        in.close();

        return answer_xds;
    }
}
