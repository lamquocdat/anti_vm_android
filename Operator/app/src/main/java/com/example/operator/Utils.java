package com.example.operator;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

public class Utils {

    //Operator
    public static boolean isOperatorNameAndroid(TextView textView, Context paramContext) {
        String szOperatorName = ((TelephonyManager) paramContext.getSystemService(Context.TELEPHONY_SERVICE)).getNetworkOperatorName();
        boolean isAndroid = szOperatorName.equalsIgnoreCase("android");
        Log.d("test:","Operation: " +szOperatorName);
        textView.setText("Operator: " + szOperatorName);
        return isAndroid;
    }
}