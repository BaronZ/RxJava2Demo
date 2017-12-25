package com.zzb.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zzb.rxjava.op.DebounceOp;
import com.zzb.rxjava.op.DistinctUntilChangedOp;

public class MainActivity extends AppCompatActivity {

    DebounceOp mDebounceOp;
    DistinctUntilChangedOp mDistinctUntilChangedOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //new ThrottleOp().start();
        //mDebounceOp = new DebounceOp();
        mDistinctUntilChangedOp = new DistinctUntilChangedOp();
    }

    public void onClick(View view) {
        mDistinctUntilChangedOp.emit();
    }
}
