package com.example.myservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MyService myService;
    private Button button;
    private Button btn02;
    private MyServiceConnection myServiceConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData("onCreateActivity");
        initView();
        bind();
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

    private void initView(){
        button=findViewById(R.id.btn);
        btn02=findViewById(R.id.btn02);
        btn02.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                Intent intent=new Intent(this,SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.btn02:
                unbindService(myServiceConnection);
                break;
        }

    }

    public class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder binder= (MyService.MyBinder) service;
            myService=binder.getService();
            setData("service");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    public void setData(String data){
        Log.e(MainActivity.class.getSimpleName(),"--"+data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setData("destroyActivity");
        unbindService(myServiceConnection);
        System.exit(0);
    }
}
