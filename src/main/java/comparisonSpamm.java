public class comparisonSpamm {
    public static String[] coparison(Float[] cnf_arr, Float[] prb_arr, String[] res_arr, String[] mail_arr){
        String[] answer = new String[10000];
        Integer number_answer = 0;
        for(int i=0; i<cnf_arr.length; i++){
            if((cnf_arr[i] != null) && (prb_arr[i] != null) && (res_arr[i].equals("Innocent")))
            {
                if(cnf_arr[i] < 0.6 && mail_arr[i] != null){
//                    System.out.println(cnf_arr[i]);
//                    System.out.println(mail_arr[i]);
                    answer[number_answer] = mail_arr[i];
                    number_answer += 1;
                }
            }
        }
        return answer;
    }
}

