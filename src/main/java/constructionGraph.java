import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.Map;

public class constructionGraph {
    public static void comstuction(Map<String, Integer> counter){
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
    }
}
