package com.example.havadurumu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView sehir,sicaklik,durum,ulke;
    private Button button;
    private EditText editText;
    private ImageView imageView;
    String str_sehir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sehir = (TextView)findViewById(R.id.txt_sehir);
        sicaklik = (TextView)findViewById(R.id.txt_sicaklik);
        durum = (TextView)findViewById(R.id.txt_durum);
        ulke = (TextView)findViewById(R.id.txt_ulke);
        button = (Button)findViewById(R.id.btn_goster);
        editText = (EditText)findViewById(R.id.edt_sehir);
        imageView = (ImageView)findViewById(R.id.img_ikon);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonParse jsonParse = new JsonParse();
                str_sehir = String.valueOf(editText.getText());
                new JsonParse().execute();
            }
        });
    }

    protected  class JsonParse extends AsyncTask<Void, Void, Void>{
        String result_tempC ="";
        String result_description = "";
        String result_icon = "";
        String result_city;
        Bitmap bitImage;


        @Override
        protected Void doInBackground(Void... voids) {
            String result="";
            try{
                URL weather_url = new URL("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=5ec2bfaba016493fa7f152236182709&q="+str_sehir+"&format=json&includelocation=yes");
                BufferedReader bufferedReader = null;
                bufferedReader = new BufferedReader(new InputStreamReader(weather_url.openStream()));
                String line = null;
                while((line = bufferedReader.readLine()) != null){//satırları tek tek aldık ve ekledik
                    result += line;
                }
                bufferedReader.close();

                JSONObject jsonObject = new JSONObject(result);//string ifadeye çevirdik
                JSONObject jsonObject_data = jsonObject.getJSONObject("data");

                JSONArray jsonArray_city = jsonObject_data.getJSONArray("request");
                JSONObject jsonObject_city = jsonArray_city.getJSONObject(0);

                JSONArray jsonArray = jsonObject_data.getJSONArray("current_condition");
                JSONObject jsonObject_weather = jsonArray.getJSONObject(0);

                JSONArray jsonArray_desc = jsonObject_weather.getJSONArray("weatherDesc");
                JSONObject jsonObject_desc = jsonArray_desc.getJSONObject(0);

                JSONArray jsonArray_imgUrl = jsonObject_weather.getJSONArray("weatherIconUrl");
                JSONObject jsonObject_imgUrl = jsonArray_imgUrl.getJSONObject(0);

                result_tempC = jsonObject_weather.getString("temp_C");//ikinci indexin tempC adlı değişkenini çektik
                result_description = jsonObject_desc.getString("value");
                result_icon = jsonObject_imgUrl.getString("value");//tek tek işimize yarayacakları aldık
                result_city = jsonObject_city.getString("query");//en sondaki kısımdan city ismini aldık

                URL icon_url = new URL(result_icon);//resim dosyasını burada saklıyor api adresimiz
                bitImage = BitmapFactory.decodeStream(icon_url.openConnection().getInputStream());//Android'de image olarak kullanamadığımız için bitmap formatına çevirdik
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            sicaklik.setText(result_tempC);
            durum.setText(result_description);
            sehir.setText(result_city);
            imageView.setImageBitmap(bitImage);
            super.onPostExecute(aVoid);

//tek tek gerekli olan kısımlara yerleştirdik aldığımız verileri
        }
        }
}
