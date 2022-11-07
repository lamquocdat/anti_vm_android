package com.example.dfnumber;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;
import static android.Manifest.permission.READ_PHONE_NUMBERS;

public class Utils {
    private static String[] known_numbers = {
            "+15555215554", // default number + VirusTotal
            "+15555215556", "+15555215558", "+15555215560", "+15555215562", "+15555215564", "+15555215566",
            "+15555215568", "+15555215570", "+15555215572", "+15555215574", "+15555215576", "+15555215578",
            "+15555215580", "+15555215582", "+15555215584",};

    public static boolean hasKnownPhoneNumber(TextView textView, AppCompatActivity act, Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(act, new String[]{ READ_PHONE_NUMBERS}, 0x12);
            Log.d("test", "No permission");
            textView.setText("error: No permission. Please let us read your phone number and press this button again!");
            return false;
        } else {
            String phoneNumber = telephonyManager.getLine1Number();
            Log.d("phoneNumber:", phoneNumber);
            for (String number : known_numbers) {
                if (number.equalsIgnoreCase(phoneNumber)) {
                    Log.d("test", "find : " + number);
                    textView.setText("find default phone number, your phone is an virtual machine: " + phoneNumber);
                    return true;
                }
            }
            Log.d("test", "No default number!");
            textView.setText("Not default phonenumber! Your phone number: " + phoneNumber);
            return false;
        }
    }
}