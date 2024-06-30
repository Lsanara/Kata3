package Kata3;

import java.io.File;
import java.util.List;
import java.util.Map;

public class kata3 {
    public static void main(String[] args) {
        Histogram<String> histogram = new Histogram<String>();
        OrganizationLoader loader = new TsvFileOrganizationLoader(new File("dataset.tsv"));
        List<Organization> organizations = loader.load();
        Map<String,Integer> barchart = new CountryOrganizationprocessor().process(organizations);
        int count = 0;
        for (String key:barchart.keySet()){
            for(int i = 0;i<barchart.get(key);i++){
                histogram.increment(key);
            }
            count++;
            if(count>5){
                break;
            }
        }
        HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM DISPLAY",histogram);
        histogramDisplay.execute();
    }
}

