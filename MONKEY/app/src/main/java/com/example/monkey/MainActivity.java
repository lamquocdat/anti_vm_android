package com.example.monkey;

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

        Button Monkey = (Button) findViewById(R.id.Monkey);
        Monkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.isUserAMonkey(textView);
            }
        });
    }
}
