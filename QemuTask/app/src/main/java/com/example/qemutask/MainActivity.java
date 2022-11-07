package com.example.qemutask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static {
       System.loadLibrary("qemutask");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.show);

        Button qemu_task = (Button)findViewById(R.id.qemu_task);
        qemu_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test","main in java!");
                String threadresult = mainthread();
                Log.d("test","result:"+threadresult+" length: "+ threadresult.length());
                textView.setText(threadresult);
            }
        });
    }
    public native String mainthread();
}
