package com.example.covid_19tracker;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.app.PendingIntent.getActivity;

public class globalFetch extends AsyncTask<Void,Void,Void> {
    String data = "";
    String global="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {

            URL url = new URL("https://api.covid19api.com/summary");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }
            JSONObject JO = new JSONObject(data);
            JSONObject globalObj = JO.getJSONObject("Global");

            //JSONArray JA = JO.getJSONArray("Countries");

           global = "New Confirmed: " + globalObj.getString("NewConfirmed") + "\n"
                    + "Total Confirmed: " + globalObj.getString("TotalConfirmed") + "\n"
                    + "New Deaths: " + globalObj.getString("NewDeaths") + "\n"
                    + "New Recovered: " + globalObj.getString("NewRecovered") + "\n"
                    + "Total Recovered: " + globalObj.getString("TotalRecovered") + "\n"
                   +"Date: "+JO.getString("Date")+"\n\n";



        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return null;
    }
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);

        globalData.globalText.setText(this.global);
    }
}
