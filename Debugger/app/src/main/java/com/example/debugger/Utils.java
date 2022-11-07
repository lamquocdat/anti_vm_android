package com.example.debugger;

import android.os.Debug;
import android.widget.TextView;

public class Utils {
    //debugger
    public static void isBeingDebugged(TextView textView) {
        if(Debug.isDebuggerConnected()){
            textView.setText("Detect debugger!");
        }else{
            textView.setText("No debug!");
        }
    }
}