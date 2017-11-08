package com.zzb.rxjava.op;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by ZZB on 2017/11/8.
 */

public class ZipOp {

    private static final String TAG = "ZipOp";

    /**
     * output
     * value:haha
     * value:haha1
     * value:haha2
     * end:true
     * value:hehe
     * value:hehe1
     * value:hehe2
     * end:true
     *
     * //c1,c2 wont out put
     */
    public void case1() {
        List<Observable<String>> obs = new ArrayList<Observable<String>>();
        obs.add(Observable.just("haha", "hehe", "c1"));
        obs.add(Observable.just("haha1", "hehe1", "c2"));
        obs.add(Observable.just("haha2", "hehe2"));
        Observable.zip(obs, new Function<Object[], Boolean>() {
            @Override
            public Boolean apply(Object[] objects) throws Exception {
                for (int i = 0; i < objects.length; i++) {
                    Log.d(TAG, "value:" + objects[i]);
                }
                return true;
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Log.d(TAG, "end:" + aBoolean);
            }
        });
    }
}
