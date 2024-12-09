package org.mobileapp.matining.threed.fitnessbuddy;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GetStartedActivity extends AppCompatActivity {

    Button startButton;
    TextView appDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        startButton = findViewById(R.id.start_button);
        appDescription = findViewById(R.id.app_description);

        // Setting the app description for the Get Started screen
        appDescription.setText(" \n\n"  +
                " \n\n"  +
                " \n\n"  +
                "Get started by exploring various features to track your fitness journey.\n\n" +
                "Key Features:\n" +
                "- Exercise Tracking\n" +
                "- BMI Calculator\n" +
                "- Diet Suggestions\n" +
                "- Daily Routines\n" +
                "- Yoga Practices\n" +
                "- Pedometer");

        // When the user clicks the "Get Started" button, navigate to the main app activity
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetStartedActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
