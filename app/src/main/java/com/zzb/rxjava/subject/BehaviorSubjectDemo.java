package com.zzb.rxjava.subject;

import android.util.Log;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

/**
 * 在监听开始，能收到之前发射的最后一个，和之后发射的所有数据
 * Created by ZZB on 2018/1/11.
 */

public class BehaviorSubjectDemo {

    public void test() {
        BehaviorSubject<String> source = BehaviorSubject.create();
        source.onNext("1");
        source.onNext("2");
        //receive "2" and "3" "4" "5"
        source.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("zzb1", "accept:" + s);
            }
        });
        source.onNext("3");
        source.onNext("4");
        source.onNext("5");
        source.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("zzb1", "accept2: " + s);
            }
        });
        source.onNext("6");
    }
}
