package com.example.hesapmakinesi;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView sonuc;
    EditText birinciSayi,ikinciSayi;
    Button topla,cikar,carp,bol,temizle;

    float islemSonucu;
    float sayi1, sayi2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sonuc = (TextView)findViewById(R.id.tv_sonuc);

        birinciSayi = (EditText)findViewById(R.id.et_birinciSayi);
        ikinciSayi = (EditText)findViewById(R.id.et_ikinciSayi);

        topla = (Button)findViewById(R.id.btn_topla);
        cikar = (Button)findViewById(R.id.btn_cikar);
        carp = (Button)findViewById(R.id.btn_carp);
        bol = (Button)findViewById(R.id.btn_bol);
        temizle = (Button)findViewById(R.id.btn_temizle);

        topla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayi1 = Integer.parseInt(birinciSayi.getText().toString());
                sayi2 = Integer.parseInt(ikinciSayi.getText().toString());
                islemSonucu = sayi1 + sayi2;
                sonuc.setText(String.valueOf(islemSonucu));
            }
        });
        cikar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayi1 = Integer.parseInt(birinciSayi.getText().toString());
                sayi2 = Integer.parseInt(ikinciSayi.getText().toString());
                islemSonucu = sayi1 - sayi2;
                sonuc.setText(String.valueOf(islemSonucu));
            }
        });
        carp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayi1 = Integer.parseInt(birinciSayi.getText().toString());
                sayi2 = Integer.parseInt(ikinciSayi.getText().toString());
                islemSonucu = sayi1 * sayi2;
                sonuc.setText(String.valueOf(islemSonucu));
            }
        });
        bol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayi1 = Integer.parseInt(birinciSayi.getText().toString());
                sayi2 = Integer.parseInt(ikinciSayi.getText().toString());
                islemSonucu = sayi1 / sayi2;
                sonuc.setText(String.valueOf(islemSonucu));
            }
        });
        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                birinciSayi.setText(String.valueOf(0));
                ikinciSayi.setText(String.valueOf(0));
                sonuc.setText(String.valueOf(0));
            }
        });

    }
}
