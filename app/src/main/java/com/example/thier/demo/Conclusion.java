package com.example.thier.demo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.PercentFormatter;

import android.view.View.OnClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Wendy on 25-3-2016.
 */
public class Conclusion extends AppCompatActivity implements OnClickListener {

    Button button1;

    //url van json advise
    private String jsondata = "http://www.nieuwemaker.nl/madvise/index.php?view=JSON&action=advise";
    RequestQueue requestQueue;

    private static String TAG = Conclusion.class.getSimpleName();

    //Progress Dialog
    private ProgressDialog pDialog;

    //array voor lijst en items
    private static final String TAG_METHOD = "method";
    private static final String TAG_ENDSCORE = "endscore";

    JSONArray jsend = new JSONArray();

    private RelativeLayout mainLayout;
    private PieChart mChart;
    private String[] xData = {"", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piechart);
        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        mChart = new PieChart(this);

        // add pie chart to main layout
        mainLayout.addView(mChart);

        // configure pie chart
        mChart.setUsePercentValues(true);
        mChart.setDescription("Methodes");

        // enable hole and configure
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleRadius(45);

        // enable rotation of the chart by touch
        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);

        //set a chart value selected listener
        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                // display msg when value selected
                if (e == null)
                    return;

                Toast.makeText(Conclusion.this,
                        xData[e.getXIndex()] + " = " + e.getVal() + "%",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });


        Intent intent = getIntent();

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        // customize legends
        Legend l = mChart.getLegend();
        l.setPosition(LegendPosition.BELOW_CHART_CENTER);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);

        //project typen filters ophalen
        int value0 = getIntent().getIntExtra("value0", 0);
        int value1 = getIntent().getIntExtra("value1", 0);
        int value2 = getIntent().getIntExtra("value2", 0);
        int value3 = getIntent().getIntExtra("value3", 0);
        int value4 = getIntent().getIntExtra("value4", 0);
        int value5 = getIntent().getIntExtra("value5", 0);
        int value6 = getIntent().getIntExtra("value6", 0);
        int value7 = getIntent().getIntExtra("value7", 0);
        int value8 = getIntent().getIntExtra("value8", 0);
        int value9 = getIntent().getIntExtra("value9", 0);


        //extraint/double van de weight.class ophalen
        Intent FilterIntent = getIntent();
        double seekBar = getIntent().getDoubleExtra("s", 0);
        double seekBar2 = getIntent().getDoubleExtra("s2", 0);
        double seekBar3 = getIntent().getDoubleExtra("s3", 0);
        double seekBar4 = getIntent().getDoubleExtra("s4", 0);
        double seekBar5 = getIntent().getDoubleExtra("s5", 0);
        double seekBar6 = getIntent().getDoubleExtra("s6", 0);
        double seekBar7 = getIntent().getDoubleExtra("s7", 0);
        double seekBar8 = getIntent().getDoubleExtra("s8", 0);
        double seekBar9 = getIntent().getDoubleExtra("s9", 0);

        int weightBar = getIntent().getIntExtra("w", 0);
        int weightBar2 = getIntent().getIntExtra("w2", 0);
        int weightBar3 = getIntent().getIntExtra("w3", 0);
        int weightBar4 = getIntent().getIntExtra("w4", 0);
        int weightBar5 = getIntent().getIntExtra("w5", 0);
        int weightBar6 = getIntent().getIntExtra("w6", 0);
        int weightBar7 = getIntent().getIntExtra("w7", 0);
        int weightBar8 = getIntent().getIntExtra("w8", 0);
        int weightBar9 = getIntent().getIntExtra("w9", 0);

        //initialiseren 10 project typen
        JSONArray jproject = new JSONArray();
        jproject.put(value0);
        jproject.put(value1);
        jproject.put(value2);
        jproject.put(value3);
        jproject.put(value4);
        jproject.put(value5);
        jproject.put(value6);
        jproject.put(value7);
        jproject.put(value8);
        jproject.put(value9);

        //initialiseren 7 ontwikkel strategieën
        JSONArray jontwikkel = new JSONArray();
        jontwikkel.put(0);
        jontwikkel.put(0);
        jontwikkel.put(0);
        jontwikkel.put(0);
        jontwikkel.put(0);
        jontwikkel.put(0);
        jontwikkel.put(0);

        //initialiseren 10 proces activiteiten
        JSONArray jproces = new JSONArray();
        jproces.put(0);
        jproces.put(0);
        jproces.put(0);
        jproces.put(0);
        jproces.put(0);
        jproces.put(0);
        jproces.put(0);
        jproces.put(0);
        jproces.put(0);
        jproces.put(0);

        //initialiseren 5 CMMI/CMM levels
        JSONArray jcmmi = new JSONArray();
        jcmmi.put(0);
        jcmmi.put(0);
        jcmmi.put(0);
        jcmmi.put(0);
        jcmmi.put(0);

        //initialiseren 9 schalen
        JSONArray jschalen = new JSONArray();
        try {
            jschalen.put(seekBar / 4);
            jschalen.put(seekBar2 / 4);
            jschalen.put(seekBar3 / 4);
            jschalen.put(seekBar4 / 4);
            jschalen.put(seekBar5 / 4);
            jschalen.put(seekBar6 / 4);
            jschalen.put(seekBar7 / 4);
            jschalen.put(seekBar8 / 4);
            jschalen.put(seekBar9 / 4);
        } catch (JSONException e) {
            Log.d("Test", jschalen.toString());
        }


        //initialiseren schaalgewicht
        JSONArray jschaalgewicht = new JSONArray();
        jschaalgewicht.put(weightBar);
        jschaalgewicht.put(weightBar2);
        jschaalgewicht.put(weightBar3);
        jschaalgewicht.put(weightBar4);
        jschaalgewicht.put(weightBar5);
        jschaalgewicht.put(weightBar6);
        jschaalgewicht.put(weightBar7);
        jschaalgewicht.put(weightBar8);
        jschaalgewicht.put(weightBar9);

        //initialiseren 4 gewichten
        JSONArray jgewicht = new JSONArray();
        jgewicht.put(0);
        jgewicht.put(0);
        jgewicht.put(0);
        jgewicht.put(0);
        jgewicht.put(jschaalgewicht);


        this.jsend.put(jproject);
        this.jsend.put(jontwikkel);
        this.jsend.put(jproces);
        this.jsend.put(jcmmi);
        this.jsend.put(jschalen);
        this.jsend.put(jgewicht);


        Log.d("Testen verzenden", jsend.toString());


        makeJsonArrayRequest();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }



    private void makeJsonArrayRequest() {

        showpDialog();


        JsonArrayRequest req = new JsonArrayRequest(Request.Method.POST, jsondata,
                jsend.toString(), new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());


                try {
                    //initialiseren xvalue en yvalue van de piechart
                    ArrayList<Entry> yVals1 = new ArrayList<Entry>();
                    ArrayList<String> xVals = new ArrayList<String>();
                        for(int i = 0; i < 5; i++) {

                            JSONObject methods = (JSONObject) response.get(i);

                            //adden van strings to JSONObject methods
                            String method = methods.getString(TAG_METHOD);
                            String endscore = methods.getString(TAG_ENDSCORE);

                            //xvalue van piechart
                                xVals.add(method);

                            //endscore omzetten naar float
                            float testfloat = Float.parseFloat(endscore);

                            //yvalue van piechart
                                yVals1.add(new Entry(testfloat, i));

                           //creëeren van pie data
                            PieDataSet dataSet = new PieDataSet(yVals1, "");
                            dataSet.setSliceSpace(0);
                            dataSet.setSelectionShift(5);

                            // kleuren adden aan pie chart
                            ArrayList<Integer> colors = new ArrayList<Integer>();

                            for (int c : ColorTemplate.VORDIPLOM_COLORS)
                                colors.add(c);

                            for (int c : ColorTemplate.JOYFUL_COLORS)
                                colors.add(c);

                            for (int c : ColorTemplate.COLORFUL_COLORS)
                                colors.add(c);

                            for (int c : ColorTemplate.LIBERTY_COLORS)
                                colors.add(c);

                            for (int c : ColorTemplate.PASTEL_COLORS)
                                colors.add(c);

                            colors.add(ColorTemplate.getHoloBlue());
                            dataSet.setColors(colors);

                            // instantiate pie data object now
                            PieData data = new PieData(xVals, dataSet);

                            //laat percentage zien
                            data.setValueFormatter(new PercentFormatter());
                            data.setValueTextSize(15f);
                            data.setValueTextColor(Color.DKGRAY);

                            //piechart setdata
                            mChart.setData(data);

                            // undo all highlights
                            mChart.highlightValues(null);
                            mChart.setDescription(null);
                            // update pie chart
                            mChart.invalidate();
                        }
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
            //aan queue toevoegen
            JSONadapter.getInstance().addToRequestQueue(req);
    }

    @Override
    public void onClick(View v) {

    }

    public void filteren(View v){
        Intent i = new Intent(Conclusion.this, MultispinnerProjectTypen.class);

        startActivity(i);
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