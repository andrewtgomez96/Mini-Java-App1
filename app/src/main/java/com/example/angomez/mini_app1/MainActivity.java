package com.example.angomez.mini_app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;

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
        Integer networkSpeed = Integer.getInteger(tvNS.getText().toString());
        Integer fileSize = Integer.getInteger(tvFS.getText().toString());
        TextView printTime = (TextView) findViewById(R.id.textView3);

        double perByteSpeed = (double)(networkSpeed * Math.pow(10, 6))/ 8;
        double sizeInBytes = fileSize * Math.pow(2, 20);

       double downloadTime = sizeInBytes / perByteSpeed;

       System.out.println(downloadTime);

       printTime.setText(Double.toString(downloadTime));
    }


}
