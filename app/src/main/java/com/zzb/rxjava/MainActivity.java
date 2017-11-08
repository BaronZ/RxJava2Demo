package com.zzb.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Observable<String>> obs = new ArrayList<Observable<String>>();
        obs.add(Observable.just("haha", "hehe", "c1"));
        obs.add(Observable.just("haha1", "hehe1", "c2"));
        obs.add(Observable.just("haha2", "hehe2", "c3"));
        Observable.zip(obs, new Function<Object[], Boolean>() {
            @Override
            public Boolean apply(Object[] objects) throws Exception {
                for(int i=0; i<objects.length; i++) {
                    Log.d("zzb1", "value:" + objects[i]);
                }
                return true;
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Log.d("zzb1", "end:" + aBoolean);
            }
        });



    }
}
