package com.rendi.aplikasisiswa;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.github.barteksc.pdfviewer.PDFView;

public class ModulAndroid extends AppCompatActivity {

    private PDFView pdfView;
    private int savedPage;
    private SharedPreferences pref;
    private SharedPreferences.Editor prefedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_android);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pref = getApplicationContext().getSharedPreferences("tesreader",0);
        prefedit = pref.edit();

        pdfView = findViewById(R.id.pdfView);
        savedPage = pref.getInt("savedPage", savedPage);
        pdfView.fromAsset("modul_android.pdf")
                .enableSwipe(true)
                .defaultPage(savedPage)
                .load();

    }
    protected void onPause(){
        super.onPause();
        savedPage = pdfView.getCurrentPage();
        prefedit.putInt("savedPage",savedPage);
        prefedit.apply();
    }
    protected void onStop(){

        super.onStop();
        savedPage = pdfView.getCurrentPage();
        prefedit.putInt("savedPage", savedPage);
        prefedit.apply();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
