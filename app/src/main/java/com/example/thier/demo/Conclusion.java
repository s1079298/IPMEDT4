package com.example.thier.demo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wendy on 25-3-2016.
 */
public class Conclusion extends AppCompatActivity {

    private String jsondata = "http://www.nieuwemaker.nl/madvise/index.php?view=JSON&action=advise";
    RequestQueue requestQueue;

    private static String TAG = Conclusion.class.getSimpleName();

    //Progress Dialog
    private ProgressDialog pDialog;

    //temporary string to show the parsed response
    private String jsonResponse;


    private ListView mListView;
    private com.example.thier.demo.ListAdapter mAdapter;
    private List<Method> fullMethod = new ArrayList<>();

    //array voor lijst en items
    private static final String TAG_METHOD = "method";
    private static final String TAG_SCORE = "score";
    private static final String TAG_ENDSCORE = "endscore";
    private static final String TAG_WEIGHT = "weight";

    JSONArray jsend = new JSONArray();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.method_layout);

        Intent intent = getIntent();

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        //initialiseren 10 project typen
        JSONArray jproject = new JSONArray();
        jproject.put(1);
        jproject.put(1);
        jproject.put(1);
        jproject.put(1);
        jproject.put(1);
        jproject.put(1);
        jproject.put(1);
        jproject.put(1);
        jproject.put(1);
        jproject.put(1);

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
        jschalen.put(1);
        jschalen.put(1);
        jschalen.put(1);
        jschalen.put(1);
        jschalen.put(1);
        jschalen.put(1);
        jschalen.put(1);
        jschalen.put(1);
        jschalen.put(1);

        //initialiseren schaalgewicht
        JSONArray jschaalgewicht = new JSONArray();
        jschaalgewicht.put(1);
        jschaalgewicht.put(1);
        jschaalgewicht.put(1);
        jschaalgewicht.put(1);
        jschaalgewicht.put(1);
        jschaalgewicht.put(1);
        jschaalgewicht.put(1);
        jschaalgewicht.put(1);
        jschaalgewicht.put(1);

        //initialiseren 4 gewichten
        JSONArray jgewicht = new JSONArray();
        jgewicht.put(1);
        jgewicht.put(1);
        jgewicht.put(1);
        jgewicht.put(1);
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
                    public void onResponse(JSONArray response)
                    {
                        Log.d(TAG, response.toString());

                        try {

                            //jsonResponse = "";

                            for (int i = 0; i < response.length(); i++) {

                                JSONObject methodlist = (JSONObject) response.get(i);
                                //methodlist.put("test", jsend);
                                String method = methodlist.getString(TAG_METHOD);
                                JSONArray scorearray = methodlist.getJSONArray(TAG_SCORE);
                                String score = methodlist.getString(TAG_SCORE);


                                Log.d("Test", scorearray.toString());

                                String weight = methodlist.getString(TAG_WEIGHT);
                                String endscore = methodlist.getString(TAG_ENDSCORE);

                                //in lijst zetten
                                fullMethod.add(new Method(method, score, weight, endscore));
                                Log.d("method", method);
                                Log.d("score", score);
                                Log.d("weight", weight);
                                Log.d("endscore", endscore);

                                //jsonResponse += "TestList: " + methodlist + "\n\n";
                            }
                            mListView = (ListView) findViewById(R.id.showMethodList);
                            mAdapter = new com.example.thier.demo.ListAdapter(Conclusion.this, 0, fullMethod);
                            mListView.setAdapter(mAdapter);

                            //txtResponse.setText(jsonResponse);
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
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                hidepDialog();
            }
        });
        Log.d("opsturen json", "opsturen");

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
