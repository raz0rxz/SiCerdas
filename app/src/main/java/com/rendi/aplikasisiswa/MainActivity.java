package com.rendi.aplikasisiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuku, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.item1){
            startActivity(new Intent(this, AboutUs.class));
        }
        return true;
    }

    public void pindah(View view) {
        Intent intent = new Intent(MainActivity.this, ModulAndroid.class);
        startActivity(intent);
    }

    public void pindah2(View view) {
        Intent intent = new Intent(MainActivity.this, ModulBadata.class);
        startActivity(intent);
    }

    public void pindah3(View view) {
        Intent intent = new Intent(MainActivity.this, ModulBindo.class);
        startActivity(intent);
    }

    public void pindah4(View view) {
        Intent intent = new Intent(MainActivity.this, ModulBinggris.class);
        startActivity(intent);
    }

    public void pindah5(View view) {
        Intent intent = new Intent(MainActivity.this, ModulCopywriting.class);
        startActivity(intent);
    }

    public void pindah6(View view) {
        Intent intent = new Intent(MainActivity.this, ModulDigitalmarketing.class);
        startActivity(intent);
    }

    public void pindah7(View view) {
        Intent intent = new Intent(MainActivity.this, ModulMatematika.class);
        startActivity(intent);
    }

    public void pindah8(View view) {
        Intent intent = new Intent(MainActivity.this, ModulPbos1.class);
        startActivity(intent);
    }

    public void pindah9(View view) {
        Intent intent = new Intent(MainActivity.this, ModulPbos2.class);
        startActivity(intent);
    }

    public void pindah10(View view) {
        Intent intent = new Intent(MainActivity.this, ModulPkk.class);
        startActivity(intent);
    }

    public void pindah11(View view) {
        Intent intent = new Intent(MainActivity.this, ModulPkn.class);
        startActivity(intent);
    }

    public void pindah12(View view) {
        Intent intent = new Intent(MainActivity.this, ModulPwpbs1.class);
        startActivity(intent);
    }

    public void pindah13(View view) {
        Intent intent = new Intent(MainActivity.this, ModulPwpbs2.class);
        startActivity(intent);
    }

    public void pindah14(View view) {
        Intent intent = new Intent(MainActivity.this, ModulTeknikclosing.class);
        startActivity(intent);
    }
}
