package com.example.qudriver;

import android.util.Log;
import android.widget.TextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class Utils {
    //qemu drivers
    private static String[] known_qemu_drivers = {"goldfish","ranchu"};
    public static boolean hasQEmuDrivers(TextView textView) {
        for (File drivers_file : new File[]{new File("/proc/tty/drivers"), new File("/proc/cpuinfo")}) {
            if (drivers_file.exists() && drivers_file.canRead()) {
                // We don't care to read much past things since info we care about should be inside here
                byte[] data = new byte[1024];
                try {
                    InputStream is = new FileInputStream(drivers_file);
                    is.read(data);
                    is.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                String driver_data = new String(data);
                Log.d("test",driver_data);
                for (String known_qemu_driver : Utils.known_qemu_drivers) {
                    if (driver_data.indexOf(known_qemu_driver) != -1) {
                        textView.setText("qemu drivers exits!");
                        return true;
                    }
                }
            }
        }
        textView.setText("qemu drivers not exits!");
        return false;
    }
}