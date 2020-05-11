package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.TextView;

public class SearchedCountryDataActivity extends AppCompatActivity {
    public static TextView countryData;
    public static String Country_Name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched_country_data);
        countryData = (TextView)findViewById(R.id.CountryDataID);
        Intent intent = getIntent();
        Country_Name = intent.getStringExtra("search");
        SpecificCountrySearch caller = new SpecificCountrySearch();
        caller.valueSet(Country_Name);
        caller.execute();
    }
}
