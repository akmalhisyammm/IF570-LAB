package id.ac.umn.week04b_40027;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnChange1, btnChange2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChange1 = findViewById(R.id.main_button_change_1);
        btnChange2 = findViewById(R.id.main_button_change_2);

        btnChange1.setOnClickListener(v -> {
            Intent firstIntent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(firstIntent);
        });

        btnChange2.setOnClickListener(v -> {
            Intent secondIntent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(secondIntent);
        });
    }
}