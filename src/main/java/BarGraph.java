import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BarGraph {
    public static void main(String args[]) throws IOException {

        URL url = new URL("https://www.py4e.com/code3/mbox.txt");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream())
        );

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

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(Map.Entry<String, Integer> item : counter.entrySet()){
            if(item.getKey() != null)
                dataset.setValue(item.getValue(), item.getKey(), item.getKey());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Гистограмма отправленных писем",
                "Отправитель",
                "Кол-во отправленных писем",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartFrame chartfr = new ChartFrame("Отправленные письма", barChart, true);
        chartfr.setVisible(true);
        chartfr.setSize(1500, 800);

//        File chart = new File("BarChart.jpeg");
//        ChartUtils.saveChartAsJPEG(chart,barChart, 2000, 1500);

        in.close();
    }
}

