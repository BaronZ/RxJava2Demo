package com.zzb.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zzb.rxjava.op.DebounceOp;

public class MainActivity extends AppCompatActivity {

    DebounceOp mDebounceOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //new ThrottleOp().start();
        mDebounceOp = new DebounceOp();

    }

    public void onClick(View view) {
        mDebounceOp.emitItem();
    }
}
