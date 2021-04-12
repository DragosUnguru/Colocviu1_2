package ro.pub.cs.systems.eim.Colocviu1_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Bundle extras = intent.getExtras();
        String action = intent.getAction();

        if (action == Constants.ACTION) {
            String recvMessage = extras.getString(Constants.ACTION_DATA_KEY);

            Toast.makeText(context, recvMessage, Toast.LENGTH_LONG).show();
        }
    }
}