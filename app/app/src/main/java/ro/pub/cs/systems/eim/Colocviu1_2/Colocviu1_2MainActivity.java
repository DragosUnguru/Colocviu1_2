package ro.pub.cs.systems.eim.Colocviu1_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Colocviu1_2MainActivity extends AppCompatActivity {

    private TextView outputText;
    private EditText inputText;
    private Button addButton;
    private Button computeButton;

    private int lastComputedSum;

    private final ButtonHandler buttonHandler = new ButtonHandler();
    private class ButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Button button = (Button) v;

            if (button.getId() == R.id.add) {

                if (inputText.getText().toString() == null || inputText.getText().toString().isEmpty()) {
                    return;
                }
                String toAppend;
                if (outputText.getText().toString().isEmpty()) {
                    toAppend = inputText.getText().toString();
                } else {
                    toAppend = " + " + inputText.getText().toString();
                }

                outputText.setText(String.format("%s%s", outputText.getText().toString(), toAppend));
            }
            else if (button.getId() == R.id.compute) {
                Intent intent = new Intent(v.getContext(), Colocviu1_2SecondaryActivity.class);
                intent.putExtra(Constants.EXTRA_BUNDLE_KEY, outputText.getText().toString());
                startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Toast.makeText(this, "Received result: " + resultCode, Toast.LENGTH_LONG).show();
        lastComputedSum = resultCode;

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(Constants.SAVE_INSTANCE_KEY, lastComputedSum);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        lastComputedSum = savedInstanceState.getInt(Constants.SAVE_INSTANCE_KEY);
        outputText.setText(Integer.toString(lastComputedSum));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);

        outputText = findViewById(R.id.output_text);
        inputText = findViewById(R.id.input_text);

        addButton = findViewById(R.id.add);
        computeButton = findViewById(R.id.compute);
        addButton.setOnClickListener(buttonHandler);
        computeButton.setOnClickListener(buttonHandler);
    }
}