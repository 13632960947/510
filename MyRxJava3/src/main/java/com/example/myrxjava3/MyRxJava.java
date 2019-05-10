package com.example.myrxjava3;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.schedulers.Schedulers;
import sun.rmi.runtime.Log;

/**
 * Author:          zhaopan <BR/>
 * CreatedTime:     2019/4/17 <BR/>
 * Desc:            TODO <BR/>
 * <p/>
 * ModifyTime:      <BR/>
 * ModifyItems:     <BR/>
 *
 * @author zhaopan <BR/>
 */
public class MyRxJava {
    public static void main(String args[]){
//        fun01();
//        fun02();
//        fun03();
//        fun04();
    }

    public static void fun01(){
        Flowable.just("Hello,world").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
    }

    public static void fun02() {
        Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext("hhha");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io())

           .subscribe(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public static void fun03(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
                emitter.onNext(4);
            }
        }).map(new Function<Integer,String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return String.valueOf(integer);
            }

        }).subscribeOn(Schedulers.io())

                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String o) throws Exception {
                        System.out.println(o);
                    }
                });
    }



}
