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
        entriesTP.add(new BarEntry(6f, 6));
        entriesTP.add(new BarEntry(12f, 7));
        entriesTP.add(new BarEntry(18f, 8));
        entriesTP.add(new BarEntry(9f, 9));

        BarDataSet datasetTP = new BarDataSet(entriesTP, "Methode richt zich op deze project typen");

        ArrayList<String> labelsTP = new ArrayList<String>();
        labelsTP.add("Commercieel");
        labelsTP.add("Data Warehouse");
        labelsTP.add("Emergency release");
        labelsTP.add("Integratie");
        labelsTP.add("OO ontwikkeling");
        labelsTP.add("Procedureel");
        labelsTP.add("Onderhoud");
        labelsTP.add("Outsourced");
        labelsTP.add("Uitfasering");
        labelsTP.add("Bedrijfs-kritisch");

        BarData dataTP = new BarData(labelsTP, datasetTP);
        datasetTP.setColors(ColorTemplate.JOYFUL_COLORS);
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
        entriesOS.add(new BarEntry(9f, 6));

        BarDataSet datasetOS = new BarDataSet(entriesOS, "Methode richt zich op deze strategieën");

        ArrayList<String> labelsOS = new ArrayList<String>();
        labelsOS.add("Code and Fix");
        labelsOS.add("Waterval");
        labelsOS.add("Agile");
        labelsOS.add("Spiraal");
        labelsOS.add("Extreme Prog.");
        labelsOS.add("Prototyping");
        labelsOS.add("Rapid App Design");

        BarData dataOS = new BarData(labelsOS, datasetOS);
        datasetOS.setColors(ColorTemplate.JOYFUL_COLORS);
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
        entriesPA.add(new BarEntry(6f, 6));
        entriesPA.add(new BarEntry(12f, 7));
        entriesPA.add(new BarEntry(18f, 8));
        entriesPA.add(new BarEntry(9f, 9));

        BarDataSet datasetPA = new BarDataSet(entriesPA, "Methode richt zich op deze activiteiten");

        ArrayList<String> labelsPA = new ArrayList<String>();
        labelsPA.add("Req. definitie");
        labelsPA.add("Project afbakening");
        labelsPA.add("Detail ontwerp");
        labelsPA.add("Req. specificeren");
        labelsPA.add("Ontwikkelen");
        labelsPA.add("Integratie");
        labelsPA.add("Installatie");
        labelsPA.add("Testen");
        labelsPA.add("Training");
        labelsPA.add("Implementatie");

        BarData dataPA = new BarData(labelsPA, datasetPA);
        datasetPA.setColors(ColorTemplate.JOYFUL_COLORS);
        barChartPA.setData(dataPA);
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

        BarDataSet datasetCM = new BarDataSet(entriesCM, "Methode wordt veel gebruikt met deze CMMI levels");

        ArrayList<String> labelsCM = new ArrayList<String>();
        labelsCM.add("Level 1");
        labelsCM.add("Level 2");
        labelsCM.add("Level 3");
        labelsCM.add("Level 4");
        labelsCM.add("Level 5");

        BarData dataCM = new BarData(labelsCM, datasetCM);
        datasetCM.setColors(ColorTemplate.JOYFUL_COLORS);
        barChartCM.setData(dataCM);
        barChartCM.animateY(5000);
    }
}
