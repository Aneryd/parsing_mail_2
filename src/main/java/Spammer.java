import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

public class Spammer {
    public static void main(String args[]) throws IOException {
        URL url = new URL("https://www.py4e.com/code3/mbox.txt");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream())
        );

        String inputLine;

        String cnf = null;
        String prob;
        String res;

        Float[] cnf_arr = new Float[10000];
        Integer number_cnf = 0;

        Float[] prb_arr = new Float[10000];
        Integer number_prb = 0;

        String[] res_arr = new String[10000];
        Integer number_res = 0;

        while((inputLine = in.readLine()) != null){
            StringBuilder confidence = new StringBuilder();
            StringBuilder probability = new StringBuilder();
            StringBuilder result = new StringBuilder();

            StringBuilder line_cnf = new StringBuilder();
            StringBuilder line_prob = new StringBuilder();
            StringBuilder line_res = new StringBuilder();


            if(inputLine.length() > 21) {
                for (int i = 0; i <= 19; i++) {
                    confidence.append(inputLine.charAt(i));
                }
                for (int i = 0; i <= 20; i++) {
                    probability.append(inputLine.charAt(i));
                }
                for (int i = 0; i <= 15; i++) {
                    result.append(inputLine.charAt(i));
                }
//                System.out.println(result);

                if(confidence.toString().equals("X-DSPAM-Confidence: ")){
                    for(int i=0; i<inputLine.length(); i++){
                        line_cnf.append(inputLine.charAt(i));
                    }
                    cnf = line_cnf.toString().replace("X-DSPAM-Confidence: ", "");
                    cnf_arr[number_cnf] = Float.parseFloat(cnf);
                    number_cnf += 1;
                }
                if(probability.toString().equals("X-DSPAM-Probability: ")){
                    for(int i=0; i<inputLine.length(); i++){
                        line_prob.append(inputLine.charAt(i));
                    }
                    prob = line_prob.toString().replace("X-DSPAM-Probability: ", "");
                    prb_arr[number_prb] = Float.parseFloat(prob);
                    number_prb += 1;
                }
                if(result.toString().equals("X-DSPAM-Result: ")){
                    for(int i=0; i<inputLine.length(); i++){
                        line_res.append(inputLine.charAt(i));
                    }
                    res = line_res.toString().replace("X-DSPAM-Result: ", "");
                    res_arr[number_res] = res;
                    number_res += 1;
//                    System.out.println(res);
                }
            }
        }
        for(int i=0; i<cnf_arr.length; i++){
            if((cnf_arr[i] != null) && (prb_arr[i] != null) && (res_arr[i].equals("Innocent")))
            {
                if(cnf_arr[i] < 0.6){
                    System.out.println(cnf_arr[i]);
                }
            }
        }
        in.close();
    }
}
