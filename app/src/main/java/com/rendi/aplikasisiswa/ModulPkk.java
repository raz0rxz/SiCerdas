package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ModulPkk extends AppCompatActivity {

    private PDFView pdfView10;
    private int savedPage10;
    private SharedPreferences pref10;
    private SharedPreferences.Editor prefedit10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_pkk);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref10 = getApplicationContext().getSharedPreferences("tesreader10",0);
        prefedit10 = pref10.edit();

        pdfView10 = findViewById(R.id.pdfView);
        savedPage10 = pref10.getInt("savedPage10", savedPage10);
        pdfView10.fromAsset("modul_pkk.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage10)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage10 = pdfView10.getCurrentPage();
        prefedit10.putInt("savedPage10",savedPage10);
        prefedit10.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage10 = pdfView10.getCurrentPage();
        prefedit10.putInt("savedPage", savedPage10);
        prefedit10.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
