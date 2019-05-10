package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Author:          zhaopan <BR/>
 * CreatedTime:     2019/4/19 <BR/>
 * Desc:            TODO <BR/>
 * <p/>
 * ModifyTime:      <BR/>
 * ModifyItems:     <BR/>
 *
 * @author zhaopan <BR/>
 */
public class MyService extends Service {
    public static MyService instance;
    public MyBinder myBinder;

    public static MyService getInstance(){
        if(instance==null){
            instance=new MyService();
            setData("instance");
        }
        return instance;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        myBinder=new MyBinder();
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setData("onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        setData("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    public class MyBinder extends Binder implements IBinder{
        public MyService getService(){
            instance=MyService.this;
            return MyService.this;
        }
    }

    public static void setData(String data){
        Log.e(MyService.class.getSimpleName(),"--"+data);
    }

    @Override
    public void onDestroy() {
        setData("destroyService");
        super.onDestroy();
    }
}
