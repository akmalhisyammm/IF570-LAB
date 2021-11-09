package id.ac.umn.week09_40027;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetilActivity extends AppCompatActivity {
    private EditText etNim, etNama, etEmail, etNomorHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil);

        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);
        etEmail = findViewById(R.id.etEmail);
        etNomorHp = findViewById(R.id.etNomorHp);

        Intent intent = getIntent();
        if (intent.hasExtra("MAHASISWA")) {
            Mahasiswa mhs = (Mahasiswa) intent.getSerializableExtra("MAHASISWA");
            etNim.setText(mhs.getNim());
            etNama.setText(mhs.getNama());
            etEmail.setText(mhs.getEmail());
            etNomorHp.setText(mhs.getNomorhp());
            etNim.setEnabled(false);
        } else {
            etNim.setEnabled(true);
        }
    }

    public void simpanData(View view) {
        String mNim = etNim.getText().toString();
        String mNama = etNama.getText().toString();
        String mEmail = etEmail.getText().toString();
        String mNomorHp = etNomorHp.getText().toString();

        if (mNim.length() <= 0 || mNama.length() <= 0 || mEmail.length() <= 0 || mNomorHp.length() <= 0) {
            Toast.makeText(this, "Semua harus diisi", Toast.LENGTH_LONG).show();
        } else {
            Intent intentJawab = new Intent();
            Mahasiswa mhs = new Mahasiswa(mNim, mNama, mEmail, mNomorHp);
            intentJawab.putExtra("MAHASISWA", mhs);
            setResult(RESULT_OK, intentJawab);
            finish();
        }
    }

    public void batal(View view) {
        Intent intentJawab = new Intent();
        setResult(RESULT_CANCELED, intentJawab);
        finish();
    }
}