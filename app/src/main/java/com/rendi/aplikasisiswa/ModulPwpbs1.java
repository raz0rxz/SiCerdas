package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ModulPwpbs1 extends AppCompatActivity {

    private PDFView pdfView12;
    private int savedPage12;
    private SharedPreferences pref12;
    private SharedPreferences.Editor prefedit12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_pwpbs1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref12 = getApplicationContext().getSharedPreferences("tesreader12",0);
        prefedit12 = pref12.edit();

        pdfView12 = findViewById(R.id.pdfView);
        savedPage12 = pref12.getInt("savedPage12", savedPage12);
        pdfView12.fromAsset("modul_pwpbs1.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage12)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage12 = pdfView12.getCurrentPage();
        prefedit12.putInt("savedPage12",savedPage12);
        prefedit12.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage12 = pdfView12.getCurrentPage();
        prefedit12.putInt("savedPage", savedPage12);
        prefedit12.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
