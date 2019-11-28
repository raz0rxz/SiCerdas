package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ModulBinggris extends AppCompatActivity {

    private PDFView pdfView4;
    private int savedPage4;
    private SharedPreferences pref4;
    private SharedPreferences.Editor prefedit4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_binggris);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref4 = getApplicationContext().getSharedPreferences("tesreader4",0);
        prefedit4 = pref4.edit();

        pdfView4 = findViewById(R.id.pdfView);
        savedPage4 = pref4.getInt("savedPage4", savedPage4);
        pdfView4.fromAsset("modul_binggris.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage4)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage4 = pdfView4.getCurrentPage();
        prefedit4.putInt("savedPage4",savedPage4);
        prefedit4.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage4 = pdfView4.getCurrentPage();
        prefedit4.putInt("savedPage", savedPage4);
        prefedit4.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
