package com.zzb.rxjava.consumer;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;

/**
 * Created by ZZB on 2017/10/31.
 */

public class BiConsumerDemo {


    public void test() {
        Single.create(new SingleOnSubscribe<String>() {

            @Override
            public void subscribe(@NonNull SingleEmitter<String> e) throws Exception {

                e.onSuccess("test");
            }
        }).subscribe(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) throws Exception {
                System.out.println(s);
            }
        });

    }

    public void test2() {

        Observer observer = Observable.just("").subscribeWith(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
    static abstract class IgnoreErrorConsumer<T> implements BiConsumer<T, Throwable> {
        private static final String TAG = "IgnoreErrorConsumer";

        @Override
        public void accept(T t, Throwable throwable) throws Exception {
            if (throwable == null) {
                accept(t);
            } else {
                Log.e(TAG, "error", throwable);
            }
        }

        protected abstract void accept(T t);
    }
}
