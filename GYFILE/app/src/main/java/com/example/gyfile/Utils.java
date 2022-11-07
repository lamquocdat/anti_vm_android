package com.example.gyfile;

import android.widget.TextView;
import java.io.File;

public class Utils {
    //genymotion file
    private static String[] known_geny_files = {"/dev/socket/genyd", "/dev/socket/baseband_genyd"};
    public static boolean hasGenyFiles(TextView textView) {
        for (String file : known_geny_files) {
            File geny_file = new File(file);
            if (geny_file.exists()) {
                textView.setText("genymotion file: " + file);
                return true;
            }
        }
        textView.setText("No genymotion file!");
        return false;
    }
}