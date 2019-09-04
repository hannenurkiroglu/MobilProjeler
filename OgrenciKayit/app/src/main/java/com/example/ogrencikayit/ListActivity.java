package com.example.ogrencikayit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        final ListView listView = (ListView)findViewById(R.id.listView);
        Button anasayfa = (Button)findViewById(R.id.btn_anasayfa);

        Veritabani veritabani = new Veritabani(ListActivity.this);
        List<String> vVeriler = veritabani.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListActivity.this, android.R.layout.simple_list_item_1,android.R.id.text1,vVeriler);
        listView.setAdapter(adapter);

        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
