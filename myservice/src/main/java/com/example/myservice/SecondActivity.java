package com.example.myservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Author:          zhaopan <BR/>
 * CreatedTime:     2019/4/25 <BR/>
 * Desc:            TODO <BR/>
 * <p/>
 * ModifyTime:      <BR/>
 * ModifyItems:     <BR/>
 *
 * @author zhaopan <BR/>
 */
public class SecondActivity extends AppCompatActivity {
    private MyService myService;
    private Button button;
    private Button btn02;
    private MyServiceConnection myServiceConnection;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        bind();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setData("onDestroySecond");

    }

    private void initView(){
        button=findViewById(R.id.btn_sec);
        btn02=findViewById(R.id.btn_unbind);
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(myServiceConnection);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyService.getInstance().setData("second");
            }
        });
    }

    public void start(){
        Intent intent=new Intent(this,MyService.class);
        startService(intent);
    }


    public void bind(){
        myServiceConnection=new MyServiceConnection();
        Intent intent=new Intent(this,MyService.class);
        bindService(intent,myServiceConnection,BIND_AUTO_CREATE);
    }
    public void setData(String data){
        Log.e(SecondActivity.class.getSimpleName(),"--"+data);
    }

    public class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder binder= (MyService.MyBinder) service;
            myService=binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
