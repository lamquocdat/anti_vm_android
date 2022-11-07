package com.example.monkey;

import android.app.ActivityManager;
import android.widget.TextView;

public class Utils {

    //Monkey
    public static void isUserAMonkey(TextView textView) {
        if(ActivityManager.isUserAMonkey()){
            textView.setText("A monkey!");
        }else{
            textView.setText("Not qemu");
        }
    }
}