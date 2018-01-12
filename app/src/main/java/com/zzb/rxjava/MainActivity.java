package com.zzb.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zzb.rxjava.op.DebounceOp;
import com.zzb.rxjava.op.DistinctUntilChangedOp;
import com.zzb.rxjava.op.SwitchMap;
import com.zzb.rxjava.subject.AsyncSubjectDemo;
import com.zzb.rxjava.subject.BehaviorSubjectDemo;

public class MainActivity extends AppCompatActivity {

    DebounceOp mDebounceOp;
    DistinctUntilChangedOp mDistinctUntilChangedOp;
    SwitchMap mSwitchMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        new BehaviorSubjectDemo().test();
    }
}
