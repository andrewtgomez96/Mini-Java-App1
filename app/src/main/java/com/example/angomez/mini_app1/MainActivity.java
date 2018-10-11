package com.example.angomez.mini_app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1 B = 8 b; 1 MiB = 220 B; 1 Mbps = 106 bps is bits per second
        final EditText tvNS = (EditText) findViewById(R.id.editText);
        final EditText tvFS = (EditText) findViewById(R.id.editText2);

        //The TextChangeListener for changes to the File Size TextView
        tvFS.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                //error checking for nullptr exception and empty case
                if(s != null && !s.toString().equalsIgnoreCase("")){
                    updateCalculation(tvNS, tvFS);
                }
            }
        });

        //The TextChangeListener for changes to the Network Speed TextView
        tvNS.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                //error checking for nullptr exception and empty case
                if(s != null && !s.toString().equalsIgnoreCase("")){
                    updateCalculation(tvNS, tvFS);
                }
            }
        });

    }

    public void updateCalculation(EditText tvNS, EditText tvFS){
        /*Log.d("MYrando", tvNS.getText().toString());
        Log.d("MYrando", tvFS.getText().toString());
        Integer networkSpeed = 0;//Integer.getInteger(tvNS.getText().toString());
        Integer fileSize = 0;//Integer.getInteger(tvFS.getText().toString());
        TextView printTime = (TextView) findViewById(R.id.textView3);

        double perByteSpeed = (double) (networkSpeed * Math.pow(10, 6)) / 8;
        double sizeInBytes = fileSize * Math.pow(2, 20);

        double downloadTime = sizeInBytes / perByteSpeed;

        Log.d("hello", "why does nothing wqork");
        System.out.println(downloadTime);
*/
        if(tvNS.getText().length() > 0 && tvFS.getText().length() > 0){
            DecimalFormat value = new DecimalFormat("#.#");
            Integer networkSpeed = Integer.parseInt(tvNS.getText().toString());
            Integer fileSize = Integer.parseInt(tvFS.getText().toString());
            TextView printTime = (TextView) findViewById(R.id.textView3);

            double perByteSpeed = (double) (networkSpeed * Math.pow(10, 6)) / 8;
            double sizeInBytes = fileSize * Math.pow(2, 20);

            double downloadTime = sizeInBytes / perByteSpeed;
            downloadTime = Math.round(downloadTime * 10) / 10.0;

            printTime.setText(Double.toString(downloadTime));
            Log.d("THE ANSWER", Double.toString(downloadTime));
        }
    }


}
