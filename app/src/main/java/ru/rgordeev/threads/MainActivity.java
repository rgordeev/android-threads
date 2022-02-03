package ru.rgordeev.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar1;
    private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);

        new MyThread().execute();
    }

    class MyThread extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPostExecute(Void unused) {
            progressBar1.setVisibility(View.INVISIBLE);
            progressBar2.setVisibility(View.INVISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar1.setProgress(values[0]);
            progressBar2.setProgress(values[0]);
        }
    }
}