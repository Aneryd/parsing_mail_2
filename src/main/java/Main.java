import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("1: XDSPAM\n" + "2:BarGraph\n" + "3:Spammer");
        Scanner scanner = new Scanner(System.in);
        Integer number = Integer.valueOf(scanner.nextLine());

        if (number == 1){
            MeanXDSPAM.main(args);
        }
        else if (number == 2){
            BarGraph.main(args);
        }
        else if (number == 3){
            Spammer.main(args);
        }
        else{
            System.out.println("ERROR");
        }
    }
}
