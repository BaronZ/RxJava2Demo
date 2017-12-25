package com.zzb.rxjava.op;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;

/**
 * 只接收最后一个触发的响应，
 * 比如短时间之内有两个搜索，ab, abc, 那如果触发abc搜索的时候，ab还没响应，那么就算之后ab的响应来了也不会accept，直接等abc的响应
 * Created by ZZB on 2017/12/25.
 */

public class SwitchMap {
    private static final String TAG = "SwitchMap";
    private PublishSubject<String> mPublishSubject = PublishSubject.create();

    public SwitchMap() {
        mPublishSubject.switchMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(String s) throws Exception {
                return fakeServerQuery(s);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "query result:" + s);
            }
        });
    }

    private int counter;

    public void query() {
        String query = "" + counter++;
        Log.d(TAG, "startQuery:" + query);
        mPublishSubject.onNext(query);
    }

    //假的服务器请求
    private Observable<String> fakeServerQuery(String query) {
        return Observable.just(query).delay(2, TimeUnit.SECONDS);
    }
}
