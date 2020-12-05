package kata5.view;

import kata5.model.Histograma;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{

    private final Histograma<String> histograma;
    
    public HistogramDisplay(String title, Histograma<String> histograma) {
        super(title);
        this.histograma=histograma;
        this.setContentPane (createPanel());
        this.pack();
        this.execute();
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        return chartPanel;      
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart(
                "JFreeChart Histogram", 
                "email domains", 
                "nº emails", 
                dataSet, 
                PlotOrientation.VERTICAL, 
                false, 
                false, 
                rootPaneCheckingEnabled);
        
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        int other = 0;
        for (String key : histograma.keySet()) {
            if(histograma.get(key)>1)
                dataSet.addValue(histograma.get(key), "", key);
            else 
                other++;
        }
        dataSet.addValue(other, "", "other");
        return dataSet;
    }
    
    public void execute(){
        this.setVisible(true);
    }
    
}