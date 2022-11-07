package com.example.qufile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.show);

        Button qufile = (Button) findViewById(R.id.qufile);
        qufile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.hasQEmuFiles(textView);
            }
        });
    }
}
