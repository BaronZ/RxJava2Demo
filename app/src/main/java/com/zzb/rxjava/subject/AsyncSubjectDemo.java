package com.zzb.rxjava.subject;

import android.util.Log;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.AsyncSubject;

/**
 * 只发射最后一个值，不管前面发了多少个值，且监听者也只收到最后一个发射的值，onComplete之前还是之后监听
 * Created by ZZB on 2017/12/27.
 */

public class AsyncSubjectDemo {
    private static final String TAG = "AsyncSubjectDemo";
    AsyncSubject<String> mAsyncSubject = AsyncSubject.create();

    public void test() {
        mAsyncSubject.onNext("1");
        mAsyncSubject.onNext("2");
        mAsyncSubject.subscribe(getConsumer("A"));// receive 4

        mAsyncSubject.onNext("3");
        mAsyncSubject.subscribe(getConsumer("B"));// receive 4
        mAsyncSubject.onNext("4");
        mAsyncSubject.onComplete();
        mAsyncSubject.subscribe(getConsumer("C"));// receive 4
        mAsyncSubject.subscribe(getConsumer("D"));// receive 4
    }

    private Consumer<String> getConsumer(String prefix) {
        return new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, prefix + " : " + s);
            }
        };
    }
}
