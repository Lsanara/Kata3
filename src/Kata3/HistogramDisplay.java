package Kata3;

import java.awt.Dimension;
import javax.swing.JPanel;

import Kata3.Histogram;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class HistogramDisplay extends ApplicationFrame {
    private final Histogram<String> histogram;

    public HistogramDisplay(String title,Histogram<String> histogram){
        super(title);
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    public void execute(){
        setVisible(true);
    }
    public JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createPanel(createDataSet()));
    }
    private JFreeChartcreateChart(DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart("Histograma","","",dataset,PlotOrientation.VERTICAL,false,false,rootPaneCheckingEnabled);
        return chart;
    }
    private DefaultCategoryDataset createDataSet(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(String key : this.histogram.keySet()){
            dataset.addValue(this.histogram.get(key),"",key);
        }
        return dataset;
    }
}
