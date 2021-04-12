package ro.pub.cs.systems.eim.Colocviu1_2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class Colocviu1_2Service extends Service {
    public Colocviu1_2Service() {
    }

    MyProcessingThread myProcessingThread;

    @Override
    public void onDestroy() {
        myProcessingThread.stopThread();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int sum = intent.getExtras().getInt(Constants.SUM_SERVICE_KEY);

        myProcessingThread = new MyProcessingThread(this, sum);
        myProcessingThread.start();

        return START_REDELIVER_INTENT;
    }
}