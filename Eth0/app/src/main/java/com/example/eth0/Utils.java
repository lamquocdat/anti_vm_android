package com.example.eth0;

import android.util.Log;
import android.widget.TextView;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Utils {
    //eth0
    public static boolean hasEth0Interface(TextView textView) {
        String NI = "Network Interface of this service:\n";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();

                Log.d("test","Interface: " + intf.getName());

                NI=NI.concat(intf.getName());
                NI=NI.concat("\n");

                if (intf.getName().contains("eth0")) {
                    textView.setText("Find eth0");
                    return true;
                }
            }
        } catch (SocketException ex) {
            Log.d("test","error!");
            textView.setText("Error!");

        }
        textView.setText(NI + "\nNo eth0");
        return false;
    }
}