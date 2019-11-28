package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ModulPbos2 extends AppCompatActivity {

    private PDFView pdfView9;
    private int savedPage9;
    private SharedPreferences pref9;
    private SharedPreferences.Editor prefedit9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_pbos2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref9 = getApplicationContext().getSharedPreferences("tesreader9",0);
        prefedit9 = pref9.edit();

        pdfView9 = findViewById(R.id.pdfView);
        savedPage9 = pref9.getInt("savedPage9", savedPage9);
        pdfView9.fromAsset("modul_pbos2.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage9)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage9 = pdfView9.getCurrentPage();
        prefedit9.putInt("savedPage9",savedPage9);
        prefedit9.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage9 = pdfView9.getCurrentPage();
        prefedit9.putInt("savedPage", savedPage9);
        prefedit9.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
