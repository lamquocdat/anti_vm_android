package com.example.build;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

public class Utils {

    //Build
    public static boolean hasEmulatorBuild(TextView textView, Context context) {
        String BOARD = android.os.Build.BOARD; // The name of the underlying board, like "unknown".
        // This appears to occur often on real hardware... that's sad
        // String BOOTLOADER = android.os.Build.BOOTLOADER; // The system bootloader version number.
        String BRAND = android.os.Build.BRAND; // The brand (e.g., carrier) the software is customized for, if any.
        // "generic"
        String DEVICE = android.os.Build.DEVICE; // The name of the industrial design. "generic"
        String HARDWARE = android.os.Build.HARDWARE; // The name of the hardware (from the kernel command line or
        // /proc). "goldfish"
        String MODEL = android.os.Build.MODEL; // The end-user-visible name for the end product. "sdk"
        String PRODUCT = android.os.Build.PRODUCT; // The name of the overall product.
        if (BOARD.contains("unknown") /* || (BOOTLOADER.compareTo("unknown") == 0) */
                || BRAND.compareTo("generic") == 0
                || DEVICE.contains("generic")
                || MODEL.contains("sdk")
                || PRODUCT.contains("sdk")
                || HARDWARE.contains("goldfish")
        ){
            Log.d("find:","This is an emulator");
            textView.setText("EMULATOR BUILD:" + "\n" + "BOARD:" + BOARD + "\n" + "BRAND:" + BRAND + "\n" +
                    "DEVICE:" + DEVICE + "\n" + "MODEL:" + MODEL + "\n"
                    + "PRODUCT:" + PRODUCT + "\n" + "HARDWARE:" + HARDWARE + "\n");
            return true;
        }
        Log.d("test:","No build");
        textView.setText("No emulator build!" + "BUILD TESTING:" + "\n" + "BOARD:" + BOARD + "\n" + "BRAND:" + BRAND + "\n" +
                "DEVICE:" + DEVICE + "\n" + "MODEL:" + MODEL + "\n"
                + "PRODUCT:" + PRODUCT + "\n" + "HARDWARE:" + HARDWARE + "\n");
        return false;
    }
}