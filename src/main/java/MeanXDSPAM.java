import java.io.IOException;


public class MeanXDSPAM {
    public static void main(String args[]) throws IOException {
        Float answer_xds = paymentXDSPAM.payment(args);
        System.out.println("Среднее значение X-DSPAM-Probability = " + answer_xds.toString());
    }
}
