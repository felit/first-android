package com.example.congsl.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        doMyJob(intent);
        return super.onStartCommand(intent, flags, startId);
    }

    private void doMyJob(Intent intent) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("Test");
                super.run();
            }
        }.start();
    }
}
