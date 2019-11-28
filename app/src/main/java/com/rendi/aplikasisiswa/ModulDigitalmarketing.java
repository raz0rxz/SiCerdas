package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ModulDigitalmarketing extends AppCompatActivity {

    private PDFView pdfView6;
    private int savedPage6;
    private SharedPreferences pref6;
    private SharedPreferences.Editor prefedit6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_digitalmarketing);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref6 = getApplicationContext().getSharedPreferences("tesreader6",0);
        prefedit6 = pref6.edit();

        pdfView6 = findViewById(R.id.pdfView);
        savedPage6 = pref6.getInt("savedPage6", savedPage6);
        pdfView6.fromAsset("modul_digitalmarketing.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage6)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage6 = pdfView6.getCurrentPage();
        prefedit6.putInt("savedPage6",savedPage6);
        prefedit6.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage6 = pdfView6.getCurrentPage();
        prefedit6.putInt("savedPage", savedPage6);
        prefedit6.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
