package ro.pub.cs.systems.eim.Colocviu1_2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class MyProcessingThread extends Thread {
    private boolean isRunning;
    private final Context context;

    private int sum;

    MyProcessingThread(Context context, int sum) {
        this.isRunning = true;
        this.context = context;
        this.sum = sum;
    }

    @Override
    public void run() {
        while (isRunning) {
            sendMessage();
            sleep();
        }
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION);

        String message = new Date().toString() + "| SUM: " + sum;
        intent.putExtra(Constants.ACTION_DATA_KEY, message);

        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException e) {
            Log.d(Constants.TAG, "Sleep interrupted");
        }
    }

    public void stopThread() {
        this.isRunning = false;
    }
}
