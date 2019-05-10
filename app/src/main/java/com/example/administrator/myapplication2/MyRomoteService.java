package com.example.administrator.myapplication2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Author:          zhaopan <BR/>
 * CreatedTime:     2019/3/27 <BR/>
 * Desc:            TODO <BR/>
 * <p/>
 * ModifyTime:      <BR/>
 * ModifyItems:     <BR/>
 *
 * @author zhaopan <BR/>
 */
public class MyRomoteService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
