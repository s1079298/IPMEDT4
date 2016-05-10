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

    private static final String TAG_NAME = "name";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_PT = "projectType";
    private static final String TAG_STRATEGY = "strategy";
    private static final String TAG_ACTIVITY = "activity";
    private static final String TAG_CMM = "cmmLevel";
    private static final String TAG_SLIDERS = "sliders";
    private static final String TAG_ENDSCORE = "endscore";

    private ArrayList<String> labelsPT = new ArrayList<String>();

    JSONArray jsend = new JSONArray();
    private LinearLayout barLayout;
    private BarChart barChartPT;

    //Progress Dialog
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        barLayout = (LinearLayout) findViewById(R.id.barLayout);
        setContentView(R.layout.activity_barchart);

        barChartPT = new BarChart(this);

        Intent x = getIntent();
        //ophalen sharedpref van conclusion klasse
        SharedPreferences sharedPreferences = getSharedPreferences("barChartData", Context.MODE_PRIVATE);
        //ophalen jsonurl voor ophalen data
//        String jsondata = sharedPreferences.getString("jsondata", "http://nieuwemaker.nl/madvise/index.php?action=method&data=" + DEFAULT);

        //titel voor gebruik in barchart activity
        String titel = sharedPreferences.getString("jsondata", DEFAULT);

        //Vul de titel met de, door gebruiker gekozen, methode
        TextView textName = (TextView) findViewById(R.id.titelViewPT);
        textName.setText(titel);

//        //aanmaken BarChart voor Projecttype
//        BarChart barChartPT = (BarChart) findViewById(R.id.chartProjectType);
//
//        ArrayList<BarEntry> entriesTP = new ArrayList<>();
//        entriesTP.add(new BarEntry(4f, 0));
//        entriesTP.add(new BarEntry(8f, 1));
//        entriesTP.add(new BarEntry(6f, 2));
//        entriesTP.add(new BarEntry(12f, 3));
//        entriesTP.add(new BarEntry(18f, 4));
//        entriesTP.add(new BarEntry(9f, 5));
//        entriesTP.add(new BarEntry(6f, 6));
//        entriesTP.add(new BarEntry(12f, 7));
//        entriesTP.add(new BarEntry(18f, 8));
//        entriesTP.add(new BarEntry(9f, 9));
//
//        BarDataSet datasetTP = new BarDataSet(entriesTP, "Methode richt zich op deze project typen");
//
//        ArrayList<String> labelsTP = new ArrayList<String>();
//        labelsTP.add("Commercieel");
//        labelsTP.add("Data Warehouse");
//        labelsTP.add("Emergency release");
//        labelsTP.add("Integratie");
//        labelsTP.add("OO ontwikkeling");
//        labelsTP.add("Procedureel");
//        labelsTP.add("Onderhoud");
//        labelsTP.add("Outsourced");
//        labelsTP.add("Uitfasering");
//        labelsTP.add("Bedrijfs-kritisch");
//
//        BarData dataTP = new BarData(labelsTP, datasetTP);
//        datasetTP.setColors(ColorTemplate.JOYFUL_COLORS);
//        barChartPT.setData(dataTP);
//        barChartPT.animateY(5000);

        // chart ontwikkelstrategie

        BarChart barChartOS = (BarChart) findViewById(R.id.chartstrategy);

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

//        this.jsend.put(entriesTP);
        this.jsend.put(entriesOS);
        this.jsend.put(entriesPA);
        this.jsend.put(entriesCM);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        makeJsonArrayRequest();
        requestQueue = Volley.newRequestQueue(getApplicationContext());



    }

    //json array request voor ophalen en doorsturen data + vullen piechart
    private void makeJsonArrayRequest() {

        SharedPreferences sharedPreferences = getSharedPreferences("barChartData", Context.MODE_PRIVATE);

        //ophalen jsonurl voor ophalen data
        String jsondata = sharedPreferences.getString("jsondata", DEFAULT);
        String jsondataURL = "http://nieuwemaker.nl/madvise/index.php?action=method&data=" + jsondata;
        Log.d("Testen verzenden", jsondataURL);

        //toast text om te kijken of het lukt om data op te halen
        if(jsondataURL.equals(DEFAULT)){
            Toast.makeText(this, "No data was found", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Data loaded successfully", Toast.LENGTH_LONG).show();
        }

        showpDialog();

        JsonArrayRequest req = new JsonArrayRequest(jsondataURL,
                new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());

                try {
                    //initialiseren xvalue en yvalue van de piechart
                    ArrayList<BarEntry> entriesPT = new ArrayList<>();

                    for(int i = 0; i < response.length(); i++) {
//                        JSONObject jsonObject = response.getJSONObject(i);
                        JSONArray jsonArray = response.getJSONArray(i);
                        //JSONArray jArray = jsonObject.getJSONArray("name");

                        labelsPT.add(jsonArray.toString());
                        Log.d("Test voor BarChart", jsonArray.toString());
//
//                        //adden van strings to JSONObject methods
//                        String name = methods.getString(TAG_NAME);
//                        String description = methods.getString(TAG_DESCRIPTION);
//                        String projectType = methods.getString(TAG_PT);
//                        String strategy = methods.getString(TAG_STRATEGY);
//                        String activity = methods.getString(TAG_ACTIVITY);
//                        String cmmLevel = methods.getString(TAG_CMM);
//                        String sliders = methods.getString(TAG_SLIDERS);
//                        String endscore = methods.getString(TAG_ENDSCORE);
//                        Log.d("Dit komt eruit", "\n" + name + "\t\t" + description + "\t\t\t"
//                                + projectType + "\t\t\t\t" + strategy + "\t\t\t\t" + activity
//                                + "\t\t\t\t" + cmmLevel + "\t\t\t\t" + sliders + "\t\t\t\t" + "\n");

//                        //endscore omzetten naar float
//                        float testfloat = Float.parseFloat(projectType);
//                        Log.d("Testfloat BARCHART", projectType);
//
//                        //yvalue van barchart
//                        entriesPT.add(new BarEntry(testfloat, i));
//
//                        //aanmaken BarChart voor Projecttype
//                        BarDataSet datasetTP = new BarDataSet(entriesPT, "Methode richt zich op deze project typen");
//                        labelsPT.add("Commercieel");
//                        labelsPT.add("Data Warehouse");
//                        labelsPT.add("Emergency release");
//                        labelsPT.add("Integratie");
//                        labelsPT.add("OO ontwikkeling");
//                        labelsPT.add("Procedureel");
//                        labelsPT.add("Onderhoud");
//                        labelsPT.add("Outsourced");
//                        labelsPT.add("Uitfasering");
//                        labelsPT.add("Bedrijfs-kritisch");
//
//                        BarData dataPT = new BarData(labelsPT, datasetTP);
//                        datasetTP.setColors(ColorTemplate.JOYFUL_COLORS);
//
//                        //creëeren van barchart data
//                        BarDataSet dataSetPT = new BarDataSet(entriesPT, "Methode richt zich op deze project typen");
//                        dataSetPT.setColors(ColorTemplate.JOYFUL_COLORS);
//
//                        //piechart setdata
//                        barChartPT.setData(dataPT);
//                        barChartPT.animateY(5000);
//
//                        // undo all highlights
//                        barChartPT.highlightValues(null);
//                        barChartPT.setDescription(null);
//
//                        // update pie chart
//                        barChartPT.invalidate();
                    }

                    //set a chart value selected listener
                    barChartPT.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

                        @Override
                        public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                            // display msg when value selected
                            if (e == null)
                                return;
                        }
                        @Override
                        public void onNothingSelected() {
                        }
                    });

                } catch(JSONException e){
                    // JSON error handlen
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
                hidepDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                hidepDialog();
            }
        });
        Log.d("opsturen json", "opsturen");

        labelsPT = new ArrayList<>();
        //aan queue toevoegen
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
