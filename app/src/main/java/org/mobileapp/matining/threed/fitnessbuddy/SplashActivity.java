package org.mobileapp.matining.threed.fitnessbuddy;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;


public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {

            Intent intent = new Intent(SplashActivity.this, GetStartedActivity.class);
            startActivity(intent);
            // Close SplashActivity
            finish();
        }, 3000);
    }
}