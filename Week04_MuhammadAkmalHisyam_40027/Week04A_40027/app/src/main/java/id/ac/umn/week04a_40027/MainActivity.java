package id.ac.umn.week04a_40027;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etIsian, etUrl;
    private Button btnKirim, btnBrowse;
    private TextView tvJawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIsian = findViewById(R.id.isian);
        etUrl = findViewById(R.id.url);
        btnBrowse = findViewById(R.id.buttonBrowse);
        btnKirim = findViewById(R.id.buttonKirim);
        tvJawaban = findViewById(R.id.jawaban);

        btnBrowse.setOnClickListener(v -> {
            String urlText = etUrl.getText().toString();
            if (urlText.isEmpty()) {
                urlText = "http://www.umn.ac.id/";
            }
            Intent browseIntent = new Intent(Intent.ACTION_VIEW);
            browseIntent.setData(Uri.parse(urlText));
            if (browseIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(browseIntent);
            }
        });

        btnKirim.setOnClickListener(v -> {
            Intent intentDua = new Intent(MainActivity.this, ActivityDua.class);
            String isian = etIsian.getText().toString();
            intentDua.putExtra("PesanDariMain", isian);
            startActivityForResult(intentDua, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String jawaban = data.getStringExtra("Jawaban");
                tvJawaban.setText(jawaban);
            }
        }
    }
}