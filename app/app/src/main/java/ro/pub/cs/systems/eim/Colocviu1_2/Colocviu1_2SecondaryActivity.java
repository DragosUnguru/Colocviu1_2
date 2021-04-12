package ro.pub.cs.systems.eim.Colocviu1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Colocviu1_2SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_2_secondary);

        Intent intent = getIntent();
        if (intent != null) {
            String recvData = intent.getExtras().getString(Constants.EXTRA_BUNDLE_KEY);
            String[] elems = recvData.split("[-+*/]");
            int result = 0;

            for (String elem : elems) {
                elem = elem.trim();
                result += Integer.parseInt(elem);
            }

            setResult(result);
            finish();
        }
    }
}