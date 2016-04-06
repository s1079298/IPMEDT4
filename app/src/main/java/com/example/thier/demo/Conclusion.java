package com.example.thier.demo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

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

    private String JSONArray = "http://nieuwemaker.nl/madvise/index.php?action=comparemethod&data=JAD&results=8&weight=11102";
    RequestQueue requestQueue;

    private static String TAG = MainActivity.class.getSimpleName();

    //Progress Dialog
    private ProgressDialog pDialog;

    //temporary string to show the parsed response
    private String jsonResponse;


    private ListView mListView;
    private com.example.thier.demo.ListAdapter mAdapter;
    private List<Method> fullMethod = new ArrayList<>();

    //array voor lijst en items
    private static final String TAG_METHOD = "method";
    private static final String TAG_ENDSCORE = "endscore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.method_layout);

        Intent intent = getIntent();

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        makeJsonArrayRequest();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    private void makeJsonArrayRequest() {

        showpDialog();

        JsonArrayRequest req = new JsonArrayRequest(JSONArray,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response)
                    {
                        Log.d(TAG, response.toString());

                        try {

                            //jsonResponse = "";

                            for (int i = 0; i < response.length(); i++) {

                                JSONObject methodlist = (JSONObject) response.get(i);

                                String method = methodlist.getString("method");
                                String methodname = methodlist.getString("endscore");

                                //in lijst zetten
                                fullMethod.add(new Method(method, methodname));
                                Log.d("method", method);
                                Log.d("methodlist", methodname);

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
