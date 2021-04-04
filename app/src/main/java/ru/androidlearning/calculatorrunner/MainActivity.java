package ru.androidlearning.calculatorrunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListeners();
    }

    private void initListeners() {
        findViewById(R.id.runCalculatorOnUriButton).setOnClickListener(v -> {
            String UriString = "app://calculator.androidlearning.ru";
            Uri calculatorUri = Uri.parse(UriString);
            Intent calculatorRunIntent = new Intent(Intent.ACTION_MAIN, calculatorUri);
            calculatorRunIntent.addCategory(Intent.CATEGORY_APP_CALCULATOR);

            ActivityInfo activityInfo = calculatorRunIntent.resolveActivityInfo(getPackageManager(), calculatorRunIntent.getFlags());
            if (activityInfo != null) {
                startActivity(calculatorRunIntent);
            } else {
                Toast.makeText(getApplicationContext(), "URI " + UriString + " not found!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}