package com.zzb.rxjava.op;

import android.util.Log;

import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;

/**
 * 如果发送的item与上一个相同，则不接收，直至发射的item有变化，才会接收
 * Created by ZZB on 2017/12/25.
 */

public class DistinctUntilChangedOp {

    private static final String TAG = "DistinctUntilChangedOp";
    private PublishSubject<String> mPublishSubject = PublishSubject.create();
    private String[] array = new String[]{"a", "b", "b", "c", "dd"};

    public DistinctUntilChangedOp() {
        test2();

    }

    private void test1() {
        mPublishSubject.distinctUntilChanged(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                //转换成一个对象去判断是否相等
                return s.length();
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "accept===========:" + s);
            }
        });
    }

    private void test2() {
        mPublishSubject.distinctUntilChanged().subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "accept===========:" + s);
            }
        });
    }

    private void test3() {
        mPublishSubject.distinctUntilChanged(new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String s2) throws Exception {
                Log.d(TAG, "test, s:" + s + " s2:" + s2);
                return s.equals(s2);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "accept===========:" + s);
            }
        });
    }


    private int counter = 0;

    public void emit() {
        counter = counter % array.length;
        String item = array[counter];
        Log.d(TAG, "emit:" + item);
        mPublishSubject.onNext(item);
        counter++;
    }
}
