package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ModulTeknikclosing extends AppCompatActivity {

    private PDFView pdfView14;
    private int savedPage14;
    private SharedPreferences pref14;
    private SharedPreferences.Editor prefedit14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_teknikclosing);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref14 = getApplicationContext().getSharedPreferences("tesreader14",0);
        prefedit14 = pref14.edit();

        pdfView14 = findViewById(R.id.pdfView);
        savedPage14 = pref14.getInt("savedPage14", savedPage14);
        pdfView14.fromAsset("modul_teknikclosing.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage14)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage14 = pdfView14.getCurrentPage();
        prefedit14.putInt("savedPage14",savedPage14);
        prefedit14.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage14 = pdfView14.getCurrentPage();
        prefedit14.putInt("savedPage", savedPage14);
        prefedit14.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
