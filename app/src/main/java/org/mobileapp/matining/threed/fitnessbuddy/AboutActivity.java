package org.mobileapp.matining.threed.fitnessbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


         ActionBar actionBar = getSupportActionBar();
         if (actionBar != null) {
             actionBar.setDisplayHomeAsUpEnabled(true);
             actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24);
         }

        // Find social media icons
        ImageView facebookIcon = findViewById(R.id.facebook_icon);
        ImageView twitterIcon = findViewById(R.id.twitter_icon);
        ImageView instagramIcon = findViewById(R.id.instagram_icon);
        ImageView youtubeIcon = findViewById(R.id.youtube_icon);
        ImageView threadsIcon = findViewById(R.id.threads_icon);
        ImageView telegramIcon = findViewById(R.id.telegram_icon);
        ImageView githubIcon = findViewById(R.id.github_icon);

        // Set click listeners for icons with confirmation dialog
        facebookIcon.setOnClickListener(v -> showConfirmationDialog("https://www.facebook.com", "Facebook"));
        twitterIcon.setOnClickListener(v -> showConfirmationDialog("https://www.twitter.com", "Twitter"));
        instagramIcon.setOnClickListener(v -> showConfirmationDialog("https://www.instagram.com", "Instagram"));
        youtubeIcon.setOnClickListener(v -> showConfirmationDialog("https://www.youtube.com", "YouTube"));
        threadsIcon.setOnClickListener(v -> showConfirmationDialog("https://www.threads.net", "Threads"));
        telegramIcon.setOnClickListener(v -> showConfirmationDialog("https://telegram.org", "Telegram"));
        githubIcon.setOnClickListener(v -> showConfirmationDialog("https://github.com", "GitHub"));
    }

    /**
     * Shows a confirmation dialog before opening a URL.
     *
     * @param url   The URL to open.
     * @param platform The name of the platform for display in the dialog.
     */
    private void showConfirmationDialog(String url, String platform) {
        new AlertDialog.Builder(this)
                .setTitle("Open Link")
                .setMessage("Do you want to open " + platform + "?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    // Open the link
                    openLink(url);
                })
                .setNegativeButton("No", (dialog, which) -> {
                    // Dismiss the dialog
                    dialog.dismiss();
                })
                .create()
                .show();
    }

    /**
     * Opens a URL in the browser or respective app.
     *
     * @param url The URL to open.
     */
    private void openLink(String url) {
        Toast.makeText(this, "Opening link...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Navigate back to MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setMessage("Exit Application?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AboutActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
