package com.example.bkpt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("bkpt");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.show);

        Button bkpt = (Button)findViewById(R.id.bkpt);
        bkpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bkptresult = checkQemuBreakpoint();
                if(bkptresult){
                    textView.setText("bkpt success! An emulator!");
                }
                else
                    textView.setText("bkpt success! This is Android device!");
            }
        });
    }

    public native int qemuBkpt();

    public boolean checkQemuBreakpoint() {
        boolean hit_breakpoint = false;

        // Potentially you may want to see if this is a specific value
        int result = qemuBkpt();

        if (result > 0) {
            hit_breakpoint = true;
        }

        return hit_breakpoint;
    }

}
