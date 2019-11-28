package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ModulCopywriting extends AppCompatActivity {

    private PDFView pdfView5;
    private int savedPage5;
    private SharedPreferences pref5;
    private SharedPreferences.Editor prefedit5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_copywriting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref5 = getApplicationContext().getSharedPreferences("tesreader5",0);
        prefedit5 = pref5.edit();

        pdfView5 = findViewById(R.id.pdfView);
        savedPage5 = pref5.getInt("savedPage5", savedPage5);
        pdfView5.fromAsset("modul_copywriting.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage5)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage5 = pdfView5.getCurrentPage();
        prefedit5.putInt("savedPage5",savedPage5);
        prefedit5.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage5 = pdfView5.getCurrentPage();
        prefedit5.putInt("savedPage", savedPage5);
        prefedit5.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
