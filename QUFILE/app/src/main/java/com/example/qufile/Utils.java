package com.example.qufile;

import android.util.Log;
import android.widget.TextView;
import java.io.File;

public class Utils {
    //qemu files
    private static String[] known_files = {"/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace",
            "/system/bin/qemu-props"};
    public static boolean hasQEmuFiles(TextView textView) {
        for (String pipe : known_files) {
            File qemu_file = new File(pipe);
            if (qemu_file.exists()) {
                Log.d("test", "hasQEmuFiles: " + pipe);
                textView.setText("find qemu file: " + pipe);
                return true;
            }
        }
        textView.setText("No qemu file!");
        return false;
    }
}