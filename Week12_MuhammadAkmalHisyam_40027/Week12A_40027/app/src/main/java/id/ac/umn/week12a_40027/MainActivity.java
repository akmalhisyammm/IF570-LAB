package id.ac.umn.week12a_40027;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvDaftarSensor = findViewById(R.id.daftarSensor);
        SensorManager mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> daftarSensor = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorText = new StringBuilder();

        for (Sensor currentSensor: daftarSensor) {
            sensorText.append(currentSensor.getName()).append(System.getProperty("line.separator"));
        }

        tvDaftarSensor.setText(sensorText);
    }
}