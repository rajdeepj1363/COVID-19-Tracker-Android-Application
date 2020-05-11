package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchCountry extends AppCompatActivity {
    public static EditText CountryName;
    Button searchbtn;
    Button allCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_country);
        CountryName = (EditText)findViewById(R.id.countryNameID);
        allCountry = (Button)findViewById(R.id.allCountries);
        searchbtn = (Button)findViewById(R.id.searchCountryBTN);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchCountry.this,SearchedCountryDataActivity.class);
                intent.putExtra("search",CountryName.getText().toString().toLowerCase().trim());
                startActivity(intent);
            }
        });
        allCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchCountry.this,FetchActivity.class);
                startActivity(intent);
            }
        });
    }
}
