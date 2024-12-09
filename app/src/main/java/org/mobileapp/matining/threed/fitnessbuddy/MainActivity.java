package org.mobileapp.matining.threed.fitnessbuddy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button excercise;
    Button food;
    Button dailyroutine;
    Button yoga;
    Button bmi;
    Button stepcounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Feature");

        excercise = findViewById(R.id.Excercise);
        food = findViewById(R.id.Food);
        dailyroutine = findViewById(R.id.DailyRoutine);
        yoga = findViewById(R.id.YogaExcercise);
        bmi = findViewById(R.id.BmiCal);
        stepcounter = findViewById(R.id.Counter_steps);

        stepcounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUnavailableDialog();
            }
        });
    }

    public void Exercise_show(View view) {
        Intent i = new Intent(getApplicationContext(), ExerciseInfo.class);
        startActivity(i);
    }

    public void showUnavailableDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Feature Unavailable")
                .setMessage("This feature is currently unavailable.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public void BMI_page_show(View view) {
        Intent i = new Intent(getApplicationContext(), BMIInfo.class);
        startActivity(i);
    }

    public void diet_show(View view) {
        Intent i = new Intent(getApplicationContext(), DietInfo.class);
        startActivity(i);
    }

    public void showDailyRoutine(View view) {
        Intent i = new Intent(getApplicationContext(), DailyRoutineInfo.class);
        startActivity(i);
    }

    public void show_yoga_info(View view) {
        Intent i = new Intent(getApplicationContext(), YogaInfo.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_about:
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                startActivity(aboutIntent);
                finish();
                break;
            case R.id.action_developers:
                Intent developersIntent = new Intent(this, DevelopersActivity.class);
                startActivity(developersIntent);
                break;
            case R.id.action_settings:
                Toast.makeText(this, "Settings Not Defined!", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_logout:

                showLogoutConfirmationDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {

        SharedPreferences sp = getSharedPreferences("user_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove("username");
        editor.apply();

        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

    private void showLogoutConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to log out?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        logout(); // Proceed with logout
                    }
                })
                .setNegativeButton("No", null) // If No, do nothing
                .show();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
