package com.example.kamps.ui.slideshow;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kamps.R;
import com.example.kamps.Retrofit.APIRetrofit;
import com.example.kamps.Retrofit.post;
import com.example.kamps.ui.policies.PoliciesAdapter;
import com.example.kamps.ui.policies.PoliciesClass;
import com.example.kamps.ui.policies.PoliciesFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SlideshowFragment extends Fragment {

        private RecyclerView recyclerView;
        private ArrayList<campItems>CampItemArray;
        private campItemAdapter adapter;
        View view;

        public SlideshowFragment() {
        }

        public static final String LOG_TAG = com.example.kamps.ui.slideshow.SlideshowFragment.class.getSimpleName();
        private static final String REQUEST_URL = "https://api.myjson.com/bins/18xxf4";


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.fragment_slideshow, container, false);

            recyclerView = view.findViewById(R.id.camp_recycler);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
            adapter = new campItemAdapter(getContext());

            com.example.kamps.ui.slideshow.SlideshowFragment.ReportAsyncTask task = new com.example.kamps.ui.slideshow.SlideshowFragment.ReportAsyncTask();
            task.execute();

            return view;
        }

        public void UpdateUI(ArrayList<campItems> CampItems) {

            if (CampItems != null)
                adapter = new campItemAdapter(getContext(), CampItems);
            recyclerView.setAdapter(adapter);


        }



        private class ReportAsyncTask extends AsyncTask<URL, Void, ArrayList<campItems>> {

            @Override
            protected ArrayList<campItems> doInBackground(URL... urls) {

                ArrayList<campItems> CampItems = new ArrayList<>();

                try {
                    URL URL_url=createUrl(REQUEST_URL);
                    String url_string = makeHttpRequest(URL_url);
                    JSONObject baseJson =new JSONObject(url_string);
                    JSONArray campArray = baseJson.getJSONArray("camp");
                    for(int i=0;i<campArray.length();i++)
                    { JSONObject currentcamp = campArray.getJSONObject(i);
                        String name =currentcamp.getString("camp_head");
                        String description =currentcamp.getString("camp_desc");
                        String image =currentcamp.getString("camp_image");
                        String body =currentcamp.getString("camp_body");
                        //Log.e("Policy",name+" "+description+" "+visit+" "+image_id);
                        CampItems.add(new campItems(name,description,image,body));
                    }

                } catch (JSONException | IOException e) {

                    Log.e("CampFragment", "Problem parsing the  JSON results", e);
                }
                return CampItems;
            }

            @Override
            protected void onPostExecute(ArrayList<campItems> CampItems) {
                if(CampItems!=null){
                    UpdateUI(CampItems);}

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

