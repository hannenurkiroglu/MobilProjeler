package com.example.vucutkitleindeksi;

import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar1;
    TextView kilo,idealKilo,durum;
    EditText boy;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button hesapla ;

    int intboy,intkilo,vki;
    double dbboy,ideal_kilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boy = (EditText)findViewById(R.id.edt_boy);
        seekBar1 = (SeekBar)findViewById(R.id.seekBar1);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        hesapla = (Button)findViewById(R.id.btn_hesapla);
        idealKilo = (TextView)findViewById(R.id.txt_idealKilo);
        durum = (TextView)findViewById(R.id.txt_durum);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar1, int i, boolean b) {
                seekBar1.setMax(100);
                kilo.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intboy = Integer.parseInt(String.valueOf(boy));
                intkilo = Integer.parseInt(String.valueOf(kilo));

                vki = (intkilo / ((intboy/100)^2));

                ideal_kilo = 50 + ((2.3 / 2.54) * (intboy - 152.4));

                if( vki < 18 ){

                    durum.setText("Zayıf Durumdasınız.");
                    durum.setBackgroundColor(Color.BLUE);

                }else if (vki == 18 || vki < 25){

                    durum.setText("Normal Durumdasınız.");
                    durum.setBackgroundColor(Color.GREEN);

                }else {

                    durum.setText("Kilolu Durumdasınız.");
                    durum.setBackgroundColor(Color.RED);

                }
                idealKilo.setText(String.valueOf(ideal_kilo));
            }
        });


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rdb_bay:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.rdb_bayan:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
