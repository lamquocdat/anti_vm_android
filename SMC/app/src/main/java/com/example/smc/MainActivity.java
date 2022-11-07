package com.example.smc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
       System.loadLibrary("smc");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.show);

        Button SMC = (Button)findViewById(R.id.SMC);
        SMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smc = SMCdetection();
                textView.setText(smc);
            }
        });
    }

    public native String SMCdetection();
}
