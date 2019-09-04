package com.example.ogrencikayit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText ad = (EditText)findViewById(R.id.edt_ad);
        final EditText mail = (EditText)findViewById(R.id.edt_mail);
        final EditText adres = (EditText)findViewById(R.id.edt_adres);
        Button ekle = (Button)findViewById(R.id.btn_ekle);
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Veritabani veritabani = new Veritabani(MainActivity.this);
                veritabani.VeriEkle(ad.getText().toString(), mail.getText().toString(), adres.getText().toString());
            }
        });
        Button listele = (Button)findViewById(R.id.btn_listele);
        final ListView listView = (ListView)findViewById(R.id.listView);

        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

    }
}
