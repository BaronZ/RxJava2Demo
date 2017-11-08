package com.zzb.rxjava.consumer;

import android.support.annotation.NonNull;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
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
}
