package com.example.covid_19tracker;


import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class fetchClass extends AsyncTask<Void,Void,Void> {
    String data = "";
    String dataParsed = "";
    String singleParsed = "";
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

            JSONArray JA = JO.getJSONArray("Countries");

            int i;
            for (i = 0; i < JA.length() ; i++) {
                JO = (JSONObject) JA.get(i);
                singleParsed = "Country: " + JO.getString("Country") + "\n"
                        + "Country Code: " + JO.getString("CountryCode") + "\n"
                        + "New Confirmed: " + JO.getString("NewConfirmed") + "\n"
                        + "Total Confirmed: " + JO.getString("TotalConfirmed") + "\n"
                        + "New Deaths: " + JO.getString("NewDeaths") + "\n"
                        + "Total Deaths: " + JO.getString("TotalDeaths") + "\n"
                        + "New Recovered: " + JO.getString("NewRecovered") + "\n"
                        + "Total Recovered: " + JO.getString("TotalRecovered") + "\n"
                        + "Date: " + JO.getString("Date") + "\n\n";
                dataParsed = dataParsed + singleParsed;
            }


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
        FetchActivity.fetchInfo.setText(this.dataParsed);

    }
}
