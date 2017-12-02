package com.zzb.rxjava.op;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
 * 一段时间内，频繁操作，只取一段时间内的最后一个或者第一个
 * Created by ZZB on 2017/12/2.
 */

public class ThrottleOp {
    PublishSubject<String> publishSubject = PublishSubject.create();
    long mStartMillis;
    public ThrottleOp() {
        publishSubject
                .throttleLast(800, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d("zzb1", "====accept:" + s + "===" + (System.currentTimeMillis() - mStartMillis));
                    }
                });
    }
    //
    public void start() {
        mStartMillis = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            String value = (i * 5) + "";
            publishSubject.onNext(value);
            Log.d("zzb1", "publish time====" + (System.currentTimeMillis() - mStartMillis));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
