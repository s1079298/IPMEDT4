package com.example.thier.demo;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.PercentFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BarchartActivity extends AppCompatActivity {

    public static final String DEFAULT = "N/A";
    RequestQueue requestQueue;
    private static String TAG = BarchartActivity.class.getSimpleName();
    String jsondataURL;

    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_PT = "projectType";
    private static final String TAG_STRATEGY = "strategy";
    private static final String TAG_ACTIVITY = "activity";
    private static final String TAG_CMM = "cmmLevel";
    private static final String TAG_SLIDERS = "sliders";

    //Progress Dialog
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);

        //ophalen sharedpref van conclusion klasse
        SharedPreferences sharedPreferences = getSharedPreferences("barChartData", Context.MODE_PRIVATE);

        //titel voor gebruik in barchart activity
        String titel = sharedPreferences.getString("jsondata", DEFAULT);

        //Vul de titel met de, door gebruiker gekozen, methode
        TextView textName = (TextView) findViewById(R.id.titelViewPT);
        textName.setText(titel);

        //progress dialog initialisatie
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        //methode aanroepen voor json request en volley gebruik
        makeJsonObjectRequest();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    //json object request voor inladen data
    private void makeJsonObjectRequest() {

        showpDialog();
        //ophalen jsonurl voor ophalen data vanuit sharedpref
        SharedPreferences sharedPreferences = getSharedPreferences("barChartData", Context.MODE_PRIVATE);
        String jsondata = sharedPreferences.getString("jsondata", DEFAULT);

        //if Code and Fix of Crystal Clear, ervoor zorgen dat spaties niet meegerekend worden
        //aangezien hij anders de link afbreekt
        if(jsondata.equals("Code and Fix")){
            jsondataURL = "http://nieuwemaker.nl/madvise/index.php?action=method&data=Code%20and%20Fix";
        } else if(jsondata.equals("Crystal Clear")){
            jsondataURL = "http://nieuwemaker.nl/madvise/index.php?action=method&data=Crystal%20Clear";
        } else {
            jsondataURL = "http://nieuwemaker.nl/madvise/index.php?action=method&data=" + jsondata;
        }
        Log.d("Testen jsonObject", jsondataURL);

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
                jsondataURL, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    // Parsing json object response
                    // response will be a json object
                    String description = response.getString(TAG_DESCRIPTION);

                    //inladen van description in textview
                    TextView descrip = (TextView) findViewById(R.id.textViewdescription);
                    descrip.setText(description);

                    //inladen van de JSONArrays voor de barcharts
                    JSONArray projectType = response.getJSONArray(TAG_PT);
                    JSONArray strategy = response.getJSONArray(TAG_STRATEGY);
                    JSONArray activity = response.getJSONArray(TAG_ACTIVITY);
                    JSONArray cmmLevel = response.getJSONArray(TAG_CMM);
                    JSONArray sliders = response.getJSONArray(TAG_SLIDERS);

                    //aanmaken van de project types barchart
                    BarChart barChartPT = (BarChart) findViewById(R.id.chartProjectType);

                    //parsing double to ints, gezien hij anders niet de waarden in barchart in kan laden
                    double DPT0 = (projectType.getDouble(0) * 100 );
                    int PT0 = (int)DPT0;
                    double DPT1 = (projectType.getDouble(1) * 100 );
                    int PT1 = (int)DPT1;
                    double DPT2 = (projectType.getDouble(2) * 100 );
                    int PT2 = (int)DPT2;
                    double DPT3 = (projectType.getDouble(3) * 100 );
                    int PT3 = (int)DPT3;
                    double DPT4 = (projectType.getDouble(4) * 100 );
                    int PT4 = (int)DPT4;
                    double DPT5 = (projectType.getDouble(5) * 100 );
                    int PT5 = (int)DPT5;
                    double DPT6 = (projectType.getDouble(6) * 100 );
                    int PT6 = (int)DPT6;
                    double DPT7 = (projectType.getDouble(7) * 100 );
                    int PT7 = (int)DPT7;
                    double DPT8 = (projectType.getDouble(8) * 100 );
                    int PT8 = (int)DPT8;
                    double DPT9 = (projectType.getDouble(9) * 100 );
                    int PT9 = (int)DPT9;

                    //entries voor project types barchart
                    ArrayList<BarEntry> entriesPT = new ArrayList<BarEntry>();
                    entriesPT.add(new BarEntry(PT0, 0));
                    entriesPT.add(new BarEntry(PT1, 1));
                    entriesPT.add(new BarEntry(PT2, 2));
                    entriesPT.add(new BarEntry(PT3, 3));
                    entriesPT.add(new BarEntry(PT4, 4));
                    entriesPT.add(new BarEntry(PT5, 5));
                    entriesPT.add(new BarEntry(PT6, 6));
                    entriesPT.add(new BarEntry(PT7, 7));
                    entriesPT.add(new BarEntry(PT8, 8));
                    entriesPT.add(new BarEntry(PT9, 9));

                    BarDataSet datasetTP = new BarDataSet(entriesPT, "Methode richt zich op deze project typen");

                    ArrayList<String> labelsPT = new ArrayList<String>();
                    labelsPT.add("Commercieel");
                    labelsPT.add("Data Warehouse");
                    labelsPT.add("Emergency release");
                    labelsPT.add("Integratie");
                    labelsPT.add("OO ontwikkeling");
                    labelsPT.add("Procedureel");
                    labelsPT.add("Onderhoud");
                    labelsPT.add("Outsourced");
                    labelsPT.add("Uitfasering");
                    labelsPT.add("Bedrijfs-kritisch");

                    BarData dataTP = new BarData(labelsPT, datasetTP);
                    datasetTP.setColors(ColorTemplate.JOYFUL_COLORS);
                    barChartPT.setData(dataTP);
                    barChartPT.animateY(5000);

                    //barchart ontwikkelstrategie
                    BarChart barChartOS = (BarChart) findViewById(R.id.chartstrategy);

                    //doubles omzetten naar ints voor gebruik in barchart
                    double DOS0 = (strategy.getDouble(0) * 100 );
                    int OS0 = (int)DOS0;
                    double DOS1 = (strategy.getDouble(1) * 100 );
                    int OS1 = (int)DOS1;
                    double DOS2 = (strategy.getDouble(2) * 100 );
                    int OS2 = (int)DOS2;
                    double DOS3 = (strategy.getDouble(3) * 100 );
                    int OS3 = (int)DOS3;
                    double DOS4 = (strategy.getDouble(4) * 100 );
                    int OS4 = (int)DOS4;
                    double DOS5 = (strategy.getDouble(5) * 100 );
                    int OS5 = (int)DOS5;
                    double DOS6 = (strategy.getDouble(6) * 100 );
                    int OS6 = (int)DOS6;

                    //entries in de barchart voor ontwikkel strategieen
                    ArrayList<BarEntry> entriesOS = new ArrayList<>();
                    entriesOS.add(new BarEntry(OS0, 0));
                    entriesOS.add(new BarEntry(OS1, 1));
                    entriesOS.add(new BarEntry(OS2, 2));
                    entriesOS.add(new BarEntry(OS3, 3));
                    entriesOS.add(new BarEntry(OS4, 4));
                    entriesOS.add(new BarEntry(OS5, 5));
                    entriesOS.add(new BarEntry(OS6, 6));

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

                    //doubles naar ints voor proces activiteiten
                    double DPA0 = (activity.getDouble(0) * 100 );
                    int PA0 = (int)DPA0;
                    double DPA1 = (activity.getDouble(1) * 100 );
                    int PA1 = (int)DPA1;
                    double DPA2 = (activity.getDouble(2) * 100 );
                    int PA2 = (int)DPA2;
                    double DPA3 = (activity.getDouble(3) * 100 );
                    int PA3 = (int)DPA3;
                    double DPA4 = (activity.getDouble(4) * 100 );
                    int PA4 = (int)DPA4;
                    double DPA5 = (activity.getDouble(5) * 100 );
                    int PA5 = (int)DPA5;
                    double DPA6 = (activity.getDouble(6) * 100 );
                    int PA6 = (int)DPA6;
                    double DPA7 = (activity.getDouble(7) * 100 );
                    int PA7 = (int)DPA7;
                    double DPA8 = (activity.getDouble(8) * 100 );
                    int PA8 = (int)DPA8;
                    double DPA9 = (activity.getDouble(9) * 100 );
                    int PA9 = (int)DPA9;

                    //entries voor de proces activiteiten barchart
                    ArrayList<BarEntry> entriesPA = new ArrayList<>();
                    entriesPA.add(new BarEntry(PA0, 0));
                    entriesPA.add(new BarEntry(PA1, 1));
                    entriesPA.add(new BarEntry(PA2, 2));
                    entriesPA.add(new BarEntry(PA3, 3));
                    entriesPA.add(new BarEntry(PA4, 4));
                    entriesPA.add(new BarEntry(PA5, 5));
                    entriesPA.add(new BarEntry(PA6, 6));
                    entriesPA.add(new BarEntry(PA7, 7));
                    entriesPA.add(new BarEntry(PA8, 8));
                    entriesPA.add(new BarEntry(PA9, 9));

                    BarDataSet datasetPA = new BarDataSet(entriesPA, "Methode richt zich op deze activiteiten");

                    //labels toevoegen voor proces activiteiten barchart
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

                    //double naar int voor cmmi levels barchart
                    double DCM0 = (activity.getDouble(0) * 100 );
                    int CM0 = (int)DCM0;
                    double DCM1 = (activity.getDouble(1) * 100 );
                    int CM1 = (int)DCM1;
                    double DCM2 = (activity.getDouble(2) * 100 );
                    int CM2 = (int)DCM2;
                    double DCM3 = (activity.getDouble(3) * 100 );
                    int CM3 = (int)DCM3;
                    double DCM4 = (activity.getDouble(4) * 100 );
                    int CM4 = (int)DCM4;

                    //entries cmmi barchart
                    ArrayList<BarEntry> entriesCM = new ArrayList<>();
                    entriesCM.add(new BarEntry(CM0, 0));
                    entriesCM.add(new BarEntry(CM1, 1));
                    entriesCM.add(new BarEntry(CM2, 2));
                    entriesCM.add(new BarEntry(CM3, 3));
                    entriesCM.add(new BarEntry(CM4, 4));

                    BarDataSet datasetCM = new BarDataSet(entriesCM, "Methode wordt veel gebruikt met deze CMMI levels");

                    //add labels voor cmmi in barchart
                    ArrayList<String> labelsCM = new ArrayList<String>();
                    labelsCM.add("Level 1");
                    labelsCM.add("Level 2");
                    labelsCM.add("Level 3");
                    labelsCM.add("Level 4");
                    labelsCM.add("Level 5");

                    //set data voor cmmi barchart
                    BarData dataCM = new BarData(labelsCM, datasetCM);
                    datasetCM.setColors(ColorTemplate.JOYFUL_COLORS);
                    barChartCM.setData(dataCM);
                    barChartCM.animateY(5000);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        "No data available", Toast.LENGTH_SHORT).show();
                hidepDialog();
            }
        });

        // Adding request to request queue
        JSONadapter.getInstance().addToRequestQueue(req);
    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
