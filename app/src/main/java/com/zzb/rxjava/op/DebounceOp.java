package com.zzb.rxjava.op;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
 * 一段时间内，没有事件来临，就触发，如果有事件来临，会重新等设定的时间，直至没有事件来临
 * Created by ZZB on 2017/12/25.
 */

public class DebounceOp {

    private static final String TAG = "DebounceOp";
    private PublishSubject<String> mPublishSubject = PublishSubject.create();

    public DebounceOp() {
        mPublishSubject.debounce(3, TimeUnit.SECONDS).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "current: " + System.currentTimeMillis() + " accept: " + s);
            }
        });
    }

    public void emitItem() {
        String item = System.currentTimeMillis() + "";
        Log.d(TAG, "emit:" + item);
        mPublishSubject.onNext(item);

    }
}
