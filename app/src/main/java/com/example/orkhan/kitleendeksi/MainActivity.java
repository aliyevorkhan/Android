package com.example.orkhan.kitleendeksi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import static com.example.orkhan.kitleendeksi.R.id.boy_tv;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView boy_tv, durum_tv, ideal_tv, kilo_tv;
    private SeekBar seekBar;
    private RadioGroup radioGroup;
    private boolean erkekMi = true;
    private double boy = 0.0;
    private int kilo = 50;
    private RadioGroup.OnCheckedChangeListener radioGroupOlayIsleyicisi = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId == R.id.rbMale)
                erkekMi = true;
            else if (checkedId == R.id.rbFemale)
                erkekMi = false;
            guncelle();
        }
    };
    private SeekBar.OnSeekBarChangeListener seekBarOlayIsleyicisi = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            kilo = 30 + progress;
            guncelle();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private TextWatcher editTextOlayIsleyicisi = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try {
                boy = Double.parseDouble(s.toString())/100.0;

            }catch (NumberFormatException e){
                boy = 0.0;
            }
            guncelle();

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.editText);
        boy_tv = (TextView) findViewById(R.id.boy_tv);
        durum_tv = (TextView) findViewById(R.id.durum_tv);
        ideal_tv = (TextView) findViewById(R.id.ideal_tv);
        kilo_tv = (TextView) findViewById(R.id.kilo_tv);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        editText.addTextChangedListener(editTextOlayIsleyicisi);
        seekBar.setOnSeekBarChangeListener(seekBarOlayIsleyicisi);
        radioGroup.setOnCheckedChangeListener(radioGroupOlayIsleyicisi);

        guncelle();
    }

    private void guncelle() {
        kilo_tv.setText(String.valueOf(kilo));
        boy_tv.setText(String.valueOf(boy) + " m");

        int ideal_kiloErkek = (int) (50+2.3*(boy*100*0.4-60));
        int ideal_kiloKadin = (int) (45.5+2.3*(boy*100*0.4-60));
        double vki = kilo/(boy*boy);

        if (erkekMi){
        //erkek ise burasi calisacak
            ideal_tv.setText(String.valueOf(ideal_kiloErkek));
            if(vki <= 17.5){
                durum_tv.setBackgroundResource(R.color.underweight);
                durum_tv.setText(R.string.cokZayif);
            }else if(17.5 < vki && vki<= 20.7){
                durum_tv.setBackgroundResource(R.color.underweight);
                durum_tv.setText(R.string.zayif);
            }else if(20.7 < vki && vki <= 26.4){
                durum_tv.setBackgroundResource(R.color.normal);
                durum_tv.setText(R.string.normal);
            }else if(26.4 < vki && vki <= 34.9){
                durum_tv.setBackgroundResource(R.color.overweight);
                durum_tv.setText(R.string.fazlaKilo);
            }else if (34.9 < vki && vki <= 60){
                durum_tv.setBackgroundResource(R.color.obese);
                durum_tv.setText(R.string.obezite);
            }
        }else {
            ///kadinsa
            ideal_tv.setText(String.valueOf(ideal_kiloKadin));

            ideal_tv.setText(String.valueOf(ideal_kiloErkek));
            if(vki <= 17.5){
                durum_tv.setBackgroundResource(R.color.underweight);
                durum_tv.setText(R.string.cokZayif);
            }else if(17.5 < vki && vki<= 19.1){
                durum_tv.setBackgroundResource(R.color.underweight);
                durum_tv.setText(R.string.zayif);
            }else if(19.1 < vki && vki <= 25.8){
                durum_tv.setBackgroundResource(R.color.normal);
                durum_tv.setText(R.string.normal);
            }else if(25.8 < vki && vki <= 34.9){
                durum_tv.setBackgroundResource(R.color.overweight);
                durum_tv.setText(R.string.fazlaKilo);
            }else if (34.9 < vki && vki <= 60){
                durum_tv.setBackgroundResource(R.color.obese);
                durum_tv.setText(R.string.obezite);
            }
        }
    }
}
