package com.example.administrator.myapplication2;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.List;

import cn.jpush.android.api.JPushInterface;

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
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(MyApplication.class.getSimpleName(), "---onCreateApp");
        Intent intent = new Intent(this, MyRomoteService.class);
        startService(intent);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        JPushInterface.setAlias(this,1,"113028");
        getProcessNames();
    }


    /**
     * 分进程初始化
     */
    public void getProcessNames() {
        int pid = android.os.Process.myPid();
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps != null && !runningApps.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
                if (procInfo.pid == pid) {
                    Log.e("process", "---process name is " + procInfo.processName);
                    if (procInfo.processName.equals("com.clickcoo.yishuo:pushcore")) {
                        //极光推送
//                        JPushInterface.setDebugMode(true);
//                        JPushInterface.init(this);
                    }
                }
            }
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.e(MyApplication.class.getSimpleName(), "--onTerminate");
    }
}
