package com.example.qemuprop;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

public class Utils {

    // system properties
    private static Property[] known_props = {new Property("init.svc.qemud", null),
            new Property("init.svc.qemu-props", null), new Property("qemu.hw.mainkeys", null),
            new Property("qemu.sf.fake_camera", null), new Property("qemu.sf.lcd_density", null),
            new Property("ro.bootloader", "unknown"), new Property("ro.bootmode", "unknown"),
            new Property("ro.hardware", "goldfish"), new Property("ro.kernel.android.qemud", null),
            new Property("ro.kernel.qemu.gles", null), new Property("ro.kernel.qemu", "1"),
            new Property("ro.product.device", "generic"), new Property("ro.product.model", "sdk"),
            new Property("ro.product.name", "sdk"),
            new Property("ro.serialno", null)};
    private static int MIN_PROPERTIES_THRESHOLD = 0x5;
    private static String qemu_property;

    public static void hasQEmuProps(TextView textView, Context context) {
        int found_props = 0;
        for (Property property : known_props) {
            String property_value = Syspro.getProp(context, property.name);
            /*
             * See if we expected just a non-null
             * if the property value is not null, emulator!
             * the source code it provides has some problem,
             * I change the property_value.equals("")
             */
            Log.d("test", property.name + ":" + property_value);
            if ((property.seek_value == null) && (!property_value.equals(""))) {
                //Log.d("test",property.name+":"+property_value );
                qemu_property += (property.name + ":" + property_value + "##");
                //return true;
            }
            // See if we expected a value to seek
            // the expected value is there, emulator!
            if ((property.seek_value != null) && (property_value.indexOf(property.seek_value) != -1)) {
                //Log.d("test",property.name+":"+property_value);
                qemu_property += (property.name + ":" + property_value + "##");
                //return true;
            }
        }
        textView.setText(qemu_property);
        //return false;
    }
}