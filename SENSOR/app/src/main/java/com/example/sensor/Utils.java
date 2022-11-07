package com.example.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.TextView;

public class Utils {
    //sensor
    private static float oldsensor;
    private static float sensor_count;
    public static boolean detectsensor(final TextView textView, final Context context){
        try {
            final SensorManager smanger = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);

            final Sensor sensor = smanger.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

            SensorEventListener sensorEvent = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    sensor_count++;
                    if((sensor_count == 2) && (event.values[0] == oldsensor)  ){
                        Log.d("test","find sensor:"+Float.toString(event.values[0]) );
                        textView.setText("The sensor has constant value:\n "+ Float.toString(event.values[0])+"\n"+Float.toString(event.values[1])+"\n"+Float.toString(event.values[2]));

                    } else {
                        oldsensor = event.values[0];
                        textView.setText("The old sensor has constant value:\n "+ Float.toString(event.values[0])+"\n"+Float.toString(event.values[1])+"\n"+Float.toString(event.values[2]) );
                        return;
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {
                }
            };
            smanger.registerListener(sensorEvent, sensor, SensorManager.SENSOR_DELAY_UI);
            return false;
        }catch (Exception e){
            textView.setText("Can't detect sensor!");
            return true;
        }
    }
}