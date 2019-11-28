package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ModulBindo extends AppCompatActivity {

    private PDFView pdfView3;
    private int savedPage3;
    private SharedPreferences pref3;
    private SharedPreferences.Editor prefedit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_bindo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref3 = getApplicationContext().getSharedPreferences("tesreader3",0);
        prefedit3 = pref3.edit();

        pdfView3 = findViewById(R.id.pdfView);
        savedPage3 = pref3.getInt("savedPage3", savedPage3);
        pdfView3.fromAsset("modul_bindo.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage3)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage3 = pdfView3.getCurrentPage();
        prefedit3.putInt("savedPage3",savedPage3);
        prefedit3.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage3 = pdfView3.getCurrentPage();
        prefedit3.putInt("savedPage", savedPage3);
        prefedit3.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
