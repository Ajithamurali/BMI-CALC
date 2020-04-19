package com.Blooming_Buds.BMI_Calc;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.Blooming_Buds.BMI_Calc.R;

public class splaa extends AppCompatActivity {


    Intent splash;
    public static int Checkout=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splash = new Intent(splaa.this, MainActivity.class);
                startActivity(splash);
                finish();
            }
        },Checkout);
    }

}

