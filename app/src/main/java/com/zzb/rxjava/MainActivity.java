package com.zzb.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zzb.rxjava.op.ThrottleOp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ThrottleOp().start();


    }
}
