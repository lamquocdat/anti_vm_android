package com.example.qemupipe;

import android.util.Log;
import android.widget.TextView;
import java.io.File;

public class Utils {
    // qemu pipes testing
    private static String[] known_pipes = {"/dev/socket/qemud", "/dev/qemu_pipe"};

    public static boolean hasPipes(TextView textView) {
        String Pipe = "";
        for (String pipe : known_pipes) {
            File qemu_socket = new File(pipe);
            if (qemu_socket.exists()) {
                Log.d("test", "find qemu pipes:" + pipe);
                textView.setText("find qemu pipes: " + pipe);
                return true;
            }
        }
        textView.setText("Not find qemu pipes!");
        return false;
    }
}