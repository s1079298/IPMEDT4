package com.example.thier.demo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import java.util.Arrays;

/**
 * Created by Wendy on 25-3-2016.
 */
public class Conclusion extends AppCompatActivity implements OnClickListener {
    //url van json advise
    private String jsondata = "http://www.nieuwemaker.nl/madvise/index.php?view=JSON&action=advise";
    RequestQueue requestQueue;

    final String DEFAULT = "N/A";

    private static String TAG = Conclusion.class.getSimpleName();

    //Progress Dialog
    private ProgressDialog pDialog;

    //array voor lijst en items
    private static final String TAG_METHOD = "method";
    private static final String TAG_ENDSCORE = "endscore";

    //JSonarray voor het verzenden van de data
    JSONArray jsendarray = new JSONArray();
    JSONArray jsendfilterschalen = new JSONArray();
    JSONArray jsendfilterschaalgewicht = new JSONArray();
    String jsend;

    JSONArray jproject = new JSONArray();
    JSONArray jontwikkel = new JSONArray();
    JSONArray jproces = new JSONArray();
    JSONArray jcmmi = new JSONArray();
    JSONArray jschalen = new JSONArray();
    JSONArray jschaalgewicht = new JSONArray();
    JSONArray jgewicht = new JSONArray();

    private RelativeLayout mainLayout;
    private PieChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piechart);
        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        mChart = new PieChart(this);

        // Piechart aan mainlayout toevoegen
        mainLayout.addView(mChart);

        // Piechart configureren
        mChart.setUsePercentValues(true);
        mChart.setDescription("Methodes");

        // Gat in piechart aanzetten en radius daarvan
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleRadius(45);

        // Piechart kan door aanraking gedraait worden
        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        // Legenda's costumizen
        Legend l = mChart.getLegend();
        l.setPosition(LegendPosition.BELOW_CHART_CENTER);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);

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
        jproject.put(0);
        jproject.put(0);
        jproject.put(0);
        jproject.put(0);
        jproject.put(0);
        jproject.put(0);
        jproject.put(0);
        jproject.put(0);
        jproject.put(0);
        jproject.put(0);

        //initialiseren 7 ontwikkel strategieën
        jontwikkel.put(0);
        jontwikkel.put(0);
        jontwikkel.put(0);
        jontwikkel.put(0);
        jontwikkel.put(0);
        jontwikkel.put(0);
        jontwikkel.put(0);

        //initialiseren 10 proces activiteiten
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
        jcmmi.put(0);
        jcmmi.put(0);
        jcmmi.put(0);
        jcmmi.put(0);
        jcmmi.put(0);

        //initialiseren 9 schalen
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
        jgewicht.put(0);
        jgewicht.put(0);
        jgewicht.put(0);
        jgewicht.put(0);
        jgewicht.put(jschaalgewicht);

        //verzenden van de data met json
        this.jsendarray.put(jproject);
        this.jsendarray.put(jontwikkel);
        this.jsendarray.put(jproces);
        this.jsendarray.put(jcmmi);
        this.jsendarray.put(jschalen);
        this.jsendarray.put(jgewicht);

        //verzenden van data als filters zijn toegepast
        this.jsendfilterschalen.put(jschalen);
        this.jsendfilterschaalgewicht.put(jschaalgewicht);

        makeJsonArrayRequest();
        requestQueue = Volley.newRequestQueue(getApplicationContext());

    }

    //json array request voor ophalen en doorsturen data + vullen piechart
    private void makeJsonArrayRequest() {

        showpDialog();

        //kijken waar intent vandaan komt om de goede data door te sturen
        Intent intent = getIntent();
        String previousActivity = intent.getStringExtra("FROM_ACTIVITY");

        //als previous activity van Weight afkomt, stuur de goede jsend string door voor ophalen data
        if(previousActivity.equals("A")){
            jsend = jsendarray.toString();
            SharedPreferences sharedprefA = getSharedPreferences("jsondataA", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedprefA.edit();
            edit.putString("jsendA", jsend);
            edit.apply();

            Log.d("ACTIVITY A JSEND", jsend);
        }

        //als previous activity van Multispinner afkomt, stuur goede jsend string door voor ophalen data
        if(previousActivity.equals("B")){
            SharedPreferences msharedpref = getSharedPreferences("jsondata", Context.MODE_PRIVATE);
            jsend = msharedpref.getString("jsend", DEFAULT);
            Log.d("ACTIVITY B JSEND", jsend);
        }

        //als previous activity van MainActivity afkomt, zorg voor de goede data van sharedpref
        if(previousActivity.equals("D")){
            SharedPreferences sharedMain = getSharedPreferences("jsonMain", Context.MODE_PRIVATE);
            jsend = sharedMain.getString("jsondata", DEFAULT);

            Log.d("ACTIVITY C JSEND", jsend);
        }

        Log.d("DOORGESTUURD JSONREQ", jsend);

        //Sharedpref voor de MainActivity, zodat deze de goede jsend string kan ophalen en doorsturen
        SharedPreferences jsondataConclusion = getSharedPreferences("jsondataConclusion", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = jsondataConclusion.edit();
        ed.putString("jsondata", jsend);
        ed.apply();

        JsonArrayRequest req = new JsonArrayRequest(Request.Method.POST, jsondata,
                jsend, new Response.Listener<JSONArray>() {


            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());

                try {
                    //initialiseren xvalue en yvalue van de piechart
                    ArrayList<Entry> yVals1 = new ArrayList<Entry>();
                    final ArrayList<String> xVals = new ArrayList<String>();

                    //laat alleen top 5 zien
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

                    //set a chart value selected listener
                    mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

                        @Override
                        public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                            // display msg when value selected
                            if (e == null){
                                return;
                            }
                            //zodra gebruiker op chart drukt, open barcharactivity voor dieper inzicht
                            Intent x = new Intent(Conclusion.this, BarchartActivity.class);

                            //sharedpreferences voor het doorsturen van de naam
                            SharedPreferences mSharedPreferences = getSharedPreferences("barChartData", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editormShared = mSharedPreferences.edit();

                            //xValues ophalen om als String door te kunnen sturen bij de if/else statements
                            String naamString = xVals.get(0);
                            String naamString2 = xVals.get(1);
                            String naamString3 = xVals.get(2);
                            String naamString4 = xVals.get(3);
                            String naamString5 = xVals.get(4);

                            //index krijgen van waar de gebruiker op klikt, en deze doorsturen naar BarCharActivity
                            if(e.getXIndex() == 0){
                                editormShared.putString("jsondata", naamString);
                            }
                            if(e.getXIndex() == 1){
                                editormShared.putString("jsondata", naamString2);
                                //editormShared.apply();
                            }
                            if(e.getXIndex() == 2){
                                editormShared.putString("jsondata", naamString3);
                                //editormShared.apply();
                            }
                            if(e.getXIndex() == 3){
                                editormShared.putString("jsondata", naamString4);
                                //editormShared.apply();
                            }
                            if(e.getXIndex() == 4){
                                editormShared.putString("jsondata", naamString5);
                                //editormShared.apply();
                            }
                            editormShared.apply();
                            startActivity(x);
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
            //aan queue toevoegen
            JSONadapter.getInstance().addToRequestQueue(req);
    }

    @Override
    public void onClick(View v) {
    }

    public void filterbutton(View v){
        //initialiseren sharedpreferences
        SharedPreferences sharedPreferences = getSharedPreferences("filterdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //strings opslaan in shared preferences voor schalen en schaalgewicht
        editor.putString("filterdataschalen", jsendfilterschalen.toString());
        editor.putString("filterdataschaalgewicht", jsendfilterschaalgewicht.toString());
        editor.apply();

        //intent initialiseren en starten
        Intent i = new Intent(Conclusion.this, Multispinner.class);
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