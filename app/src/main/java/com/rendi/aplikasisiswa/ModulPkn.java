package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ModulPkn extends AppCompatActivity {

    private PDFView pdfView11;
    private int savedPage11;
    private SharedPreferences pref11;
    private SharedPreferences.Editor prefedit11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_pkn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref11 = getApplicationContext().getSharedPreferences("tesreader11",0);
        prefedit11 = pref11.edit();

        pdfView11 = findViewById(R.id.pdfView);
        savedPage11 = pref11.getInt("savedPage11", savedPage11);
        pdfView11.fromAsset("modul_pkn.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage11)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage11 = pdfView11.getCurrentPage();
        prefedit11.putInt("savedPage11",savedPage11);
        prefedit11.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage11 = pdfView11.getCurrentPage();
        prefedit11.putInt("savedPage", savedPage11);
        prefedit11.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
