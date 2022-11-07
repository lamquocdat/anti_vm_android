package com.example.build;

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

        Button build = (Button) findViewById(R.id.build);
        build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.hasEmulatorBuild(textView, getApplicationContext());
            }
        });
    }
}
