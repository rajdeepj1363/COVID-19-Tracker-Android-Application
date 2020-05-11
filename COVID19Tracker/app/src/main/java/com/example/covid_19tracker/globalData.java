package com.example.covid_19tracker;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.TextView;

public class globalData extends AppCompatActivity {
    public static TextView globalText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_data);
        globalText = (TextView)findViewById(R.id.globalFetch);
        globalFetch gb = new globalFetch();
        gb.execute();
    }
}
