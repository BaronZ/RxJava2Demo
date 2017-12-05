package com.zzb.rxjava.exception;

import android.util.Log;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

/**
 * RxJavaPlugins.setErrorHandler可以避免OnErrorNotImplementedException
 * Created by ZZB on 2017/12/5.
 */

public class GlobalErrorHandler {

    private static final String TAG = "GlobalErrorHandler";

    public static void init() {
        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(TAG, "catch error", throwable);
            }
        });
    }

    public static void simulateErrorNotImplementedException() {
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                if (e != null) {
                    throw new RuntimeException("hehe");
                }
            }
        }, BackpressureStrategy.DROP).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("zzb1", "accept" + s);
            }
        });
    }
}
