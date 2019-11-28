package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ModulPbos1 extends AppCompatActivity {

    private PDFView pdfView8;
    private int savedPage8;
    private SharedPreferences pref8;
    private SharedPreferences.Editor prefedit8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_pbos1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref8 = getApplicationContext().getSharedPreferences("tesreader8",0);
        prefedit8 = pref8.edit();

        pdfView8 = findViewById(R.id.pdfView);
        savedPage8 = pref8.getInt("savedPage8", savedPage8);
        pdfView8.fromAsset("modul_pbos1.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage8)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage8 = pdfView8.getCurrentPage();
        prefedit8.putInt("savedPage8",savedPage8);
        prefedit8.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage8 = pdfView8.getCurrentPage();
        prefedit8.putInt("savedPage", savedPage8);
        prefedit8.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
