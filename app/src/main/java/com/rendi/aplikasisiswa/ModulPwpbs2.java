package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ModulPwpbs2 extends AppCompatActivity {

    private PDFView pdfView13;
    private int savedPage13;
    private SharedPreferences pref13;
    private SharedPreferences.Editor prefedit13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_pwpbs2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref13 = getApplicationContext().getSharedPreferences("tesreader13",0);
        prefedit13 = pref13.edit();

        pdfView13 = findViewById(R.id.pdfView);
        savedPage13 = pref13.getInt("savedPage13", savedPage13);
        pdfView13.fromAsset("modul_pwpbs2.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage13)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage13 = pdfView13.getCurrentPage();
        prefedit13.putInt("savedPage13",savedPage13);
        prefedit13.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage13 = pdfView13.getCurrentPage();
        prefedit13.putInt("savedPage", savedPage13);
        prefedit13.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
