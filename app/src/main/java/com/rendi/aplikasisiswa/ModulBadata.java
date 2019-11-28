package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ModulBadata extends AppCompatActivity {

    private PDFView pdfView2;
    private int savedPage2;
    private SharedPreferences pref2;
    private SharedPreferences.Editor prefedit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_badata);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref2 = getApplicationContext().getSharedPreferences("tesreader2",0);
        prefedit2 = pref2.edit();

        pdfView2 = findViewById(R.id.pdfView);
        savedPage2 = pref2.getInt("savedPage2", savedPage2);
        pdfView2.fromAsset("modul_basisdata.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage2)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage2 = pdfView2.getCurrentPage();
        prefedit2.putInt("savedPage2",savedPage2);
        prefedit2.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage2 = pdfView2.getCurrentPage();
        prefedit2.putInt("savedPage", savedPage2);
        prefedit2.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
