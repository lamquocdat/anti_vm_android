package com.example.taintdroid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.TextView;

public class Utils {
    /*TaintDroid*/
    public static boolean hasPackageNameInstalled(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        // In theory, if the package installer does not throw an exception, package exists
        try {
            packageManager.getInstallerPackageName(packageName);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
    public static void hasAppAnalysisPackage(Context context,TextView textView) {
        if(Utils.hasPackageNameInstalled(context, "org.appanalysis")){
            textView.setText("Find taint");
        }else{
            textView.setText("No taint");
        }
    }
    public static boolean hasTaintClass(TextView textView) {
        try {
            Class.forName("dalvik.system.Taint");
            textView.setText("Find taint");
            return true;
        }
        catch (ClassNotFoundException exception) {
            textView.setText("No taint");
            return false;
        }
    }
}