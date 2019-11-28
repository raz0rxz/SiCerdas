package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ModulMatematika extends AppCompatActivity {

    private PDFView pdfView7;
    private int savedPage7;
    private SharedPreferences pref7;
    private SharedPreferences.Editor prefedit7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_matematika);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref7 = getApplicationContext().getSharedPreferences("tesreader7",0);
        prefedit7 = pref7.edit();

        pdfView7 = findViewById(R.id.pdfView);
        savedPage7 = pref7.getInt("savedPage7", savedPage7);
        pdfView7.fromAsset("modul_matematika.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage7)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage7 = pdfView7.getCurrentPage();
        prefedit7.putInt("savedPage7",savedPage7);
        prefedit7.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage7 = pdfView7.getCurrentPage();
        prefedit7.putInt("savedPage", savedPage7);
        prefedit7.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
