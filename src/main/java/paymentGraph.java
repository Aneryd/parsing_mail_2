import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class paymentGraph {
    public static Map<String, Integer> paymnet(String[] args) throws IOException {
        BufferedReader in = connectURL.connect(args);

        String inputLine;
        String answer = null;

        String[] ath = new String[10000];
        Integer number = 0;

        while((inputLine = in.readLine()) != null){

            StringBuilder from = new StringBuilder();
            StringBuilder author = new StringBuilder();

            if(inputLine.length() > 8) {
                for (int i = 0; i <= 7; i++) {
                    from.append(inputLine.charAt(i));
                }
            }

            if (from.toString().equals("Author: ")){

                for(int i=0; i<inputLine.length(); i++){
                    author.append(inputLine.charAt(i));
                }

                answer = author.toString().replace("Author: ", "");
                ath[number] = answer;
                number +=1;
            }
        }

        Map<String, Integer> counter = new HashMap<String, Integer>();

        for(String word : ath){
            Integer oldCount = counter.get(word);
            if (oldCount == null)
                oldCount = 0;
            counter.put(word, oldCount+1);

        }
        in.close();
        return counter;
    }
}
