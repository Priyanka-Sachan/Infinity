package com.example.kamps.ui.policies;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kamps.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class PoliciesFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<PoliciesClass>PoliceItemArray;
    private PoliciesAdapter adapter;
    View view;

    public PoliciesFragment() {
    }

    public static final String LOG_TAG =PoliciesFragment.class.getSimpleName();
    private static final String REQUEST_URL = "https://api.myjson.com/bins/dkk0g";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_policies, container, false);

        recyclerView = view.findViewById(R.id.recycler_policies);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        adapter = new PoliciesAdapter(getContext());

        ReportAsyncTask task = new ReportAsyncTask();
        task.execute();

        return view;
    }

    public void UpdateUI(ArrayList<PoliciesClass> PolicyItems)
    {

       // adapter = new PoliciesAdapter(getContext());
        if(PolicyItems!=null)
            adapter=new PoliciesAdapter(getContext(),PolicyItems);
        recyclerView.setAdapter(adapter);

        //adapter.setPoliciesAdapter(PolicyItems);
    Log.e("policy",PolicyItems.get(0).getPolicy_description()+" "+PolicyItems.get(0).getPolicy_image_id()+" "+PolicyItems.get(0).getPolicy_name()+" "+PolicyItems.get(0).getVisit_us());}


    private class ReportAsyncTask extends AsyncTask<URL, Void, ArrayList<PoliciesClass>> {

        @Override
        protected ArrayList<PoliciesClass> doInBackground(URL... urls) {

            ArrayList<PoliciesClass> PolicyItems = new ArrayList<>();

            try {
                URL URL_url=createUrl(REQUEST_URL);
                String url_string = makeHttpRequest(URL_url);
                JSONObject baseJson =new JSONObject(url_string);
                JSONArray policyArray = baseJson.getJSONArray("policies");
                for(int i=0;i<policyArray.length();i++)
                { JSONObject currentpolicy = policyArray.getJSONObject(i);
                    String name =currentpolicy.getString("policy_name");
                    String description =currentpolicy.getString("policy_description");
                    String visit =currentpolicy.getString("policy_visit_us");
                    String image_id =currentpolicy.getString("policy_image");
                    //Log.e("Policy",name+" "+description+" "+visit+" "+image_id);
                    PolicyItems.add(new PoliciesClass(name,description,image_id,visit));
                }

            } catch (JSONException | IOException e) {

                Log.e("PoliciesFragment", "Problem parsing the earthquake JSON results", e);
            }
            return PolicyItems;
        }

        @Override
        protected void onPostExecute(ArrayList<PoliciesClass> PolicyItems) {
            if(PolicyItems!=null){
            UpdateUI(PolicyItems);}

        }

    }
    private static  URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException exception) {
            Log.e(LOG_TAG, "Error with creating URL", exception);
            return null;
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        if(url!=null) {
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(15000 /* milliseconds */);
                urlConnection.connect();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = urlConnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);
                } else {
                    Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
                }
            } catch (IOException e) {
                //TODO:Handle the exception
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }
}