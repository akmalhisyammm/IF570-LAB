package id.ac.umn.week10c_40027;

import android.os.AsyncTask;
import android.util.Log;

public class CustomServiceTask extends AsyncTask<Integer, Integer, Integer> {
    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.i("CUSTOMSERVICE", "onStartCommand: " + values[0] + " berjalan " + values[1] + " persen");
    }

    @Override
    protected void onPostExecute(Integer integer) {
        Log.i("CUSTOMSERVICE", "onStartCommand: " + integer + " Selesai");
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        int startId = integers[0];
        int n = (int)(Math.random() * 50) + 10;

        try {
            for (int i = 0; i < n; i++) {
                Thread.sleep(200);
                publishProgress(startId, ((int)((100 * i) / (float)n)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return startId;
    }
}
