package com.example.debugger;

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

        Button debugger = (Button) findViewById(R.id.debugger);
        debugger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.isBeingDebugged(textView);
            }
        });
    }
}
