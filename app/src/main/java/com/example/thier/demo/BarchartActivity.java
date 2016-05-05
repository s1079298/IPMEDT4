package com.example.thier.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarchartActivity extends AppCompatActivity {


    // barchart ProjectType
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);

        BarChart barChartPT = (BarChart) findViewById(R.id.chartProjectType);

        // HorizontalBarChart barChart= (HorizontalBarChart) findViewById(R.id.chart);

        ArrayList<BarEntry> entriesTP = new ArrayList<>();
        entriesTP.add(new BarEntry(4f, 0));
        entriesTP.add(new BarEntry(8f, 1));
        entriesTP.add(new BarEntry(6f, 2));
        entriesTP.add(new BarEntry(12f, 3));
        entriesTP.add(new BarEntry(18f, 4));
        entriesTP.add(new BarEntry(9f, 5));

        BarDataSet datasetTP = new BarDataSet(entriesTP, "# of Calls");

        ArrayList<String> labelsTP = new ArrayList<String>();
        labelsTP.add("January");
        labelsTP.add("February");
        labelsTP.add("March");
        labelsTP.add("April");
        labelsTP.add("May");
        labelsTP.add("June");

        BarData dataTP = new BarData(labelsTP, datasetTP);
        datasetTP.setColors(ColorTemplate.COLORFUL_COLORS);
        barChartPT.setData(dataTP);
        barChartPT.animateY(5000);



        // chart ontwikkelstrategie

        BarChart barChartOS = (BarChart) findViewById(R.id.chartstrategy);

        // HorizontalBarChart barChart= (HorizontalBarChart) findViewById(R.id.chart);

        ArrayList<BarEntry> entriesOS = new ArrayList<>();
        entriesOS.add(new BarEntry(4f, 0));
        entriesOS.add(new BarEntry(8f, 1));
        entriesOS.add(new BarEntry(6f, 2));
        entriesOS.add(new BarEntry(12f, 3));
        entriesOS.add(new BarEntry(18f, 4));
        entriesOS.add(new BarEntry(9f, 5));

        BarDataSet datasetOS = new BarDataSet(entriesOS, "# of Calls");

        ArrayList<String> labelsOS = new ArrayList<String>();
        labelsOS.add("January");
        labelsOS.add("February");
        labelsOS.add("March");
        labelsOS.add("April");
        labelsOS.add("May");
        labelsOS.add("June");

        BarData dataOS = new BarData(labelsOS, datasetOS);
        datasetOS.setColors(ColorTemplate.COLORFUL_COLORS);
        barChartOS.setData(dataOS);
        barChartOS.animateY(5000);






        // chart proces activiteiten
        BarChart barChartPA = (BarChart) findViewById(R.id.chartactivity);

        // HorizontalBarChart barChart= (HorizontalBarChart) findViewById(R.id.chart);

        ArrayList<BarEntry> entriesPA = new ArrayList<>();
        entriesPA.add(new BarEntry(4f, 0));
        entriesPA.add(new BarEntry(8f, 1));
        entriesPA.add(new BarEntry(6f, 2));
        entriesPA.add(new BarEntry(12f, 3));
        entriesPA.add(new BarEntry(18f, 4));
        entriesPA.add(new BarEntry(9f, 5));

        BarDataSet datasetPA = new BarDataSet(entriesPA, "# of Calls");

        ArrayList<String> labelsPA = new ArrayList<String>();
        labelsPA.add("January");
        labelsPA.add("February");
        labelsPA.add("March");
        labelsPA.add("April");
        labelsPA.add("May");
        labelsPA.add("June");

        BarData dataPA = new BarData(labelsPA, datasetPA);
        datasetPA.setColors(ColorTemplate.COLORFUL_COLORS);
        barChartPA.setData(dataOS);
        barChartPA.animateY(5000);




        /// chart CMM / CMMI
        BarChart barChartCM = (BarChart) findViewById(R.id.chartcmmLevel);

        // HorizontalBarChart barChart= (HorizontalBarChart) findViewById(R.id.chart);

        ArrayList<BarEntry> entriesCM = new ArrayList<>();
        entriesCM.add(new BarEntry(4f, 0));
        entriesCM.add(new BarEntry(8f, 1));
        entriesCM.add(new BarEntry(6f, 2));
        entriesCM.add(new BarEntry(12f, 3));
        entriesCM.add(new BarEntry(18f, 4));
        entriesCM.add(new BarEntry(9f, 5));

        BarDataSet datasetCM = new BarDataSet(entriesCM, "# of Calls");

        ArrayList<String> labelsCM = new ArrayList<String>();
        labelsCM.add("January");
        labelsCM.add("February");
        labelsCM.add("March");
        labelsCM.add("April");
        labelsCM.add("May");
        labelsCM.add("June");

        BarData dataCM = new BarData(labelsCM, datasetCM);
        datasetCM.setColors(ColorTemplate.COLORFUL_COLORS);
        barChartCM.setData(dataOS);
        barChartCM.animateY(5000);



    }
}
