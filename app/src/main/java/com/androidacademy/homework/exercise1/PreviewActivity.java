package com.androidacademy.homework.exercise1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PreviewActivity extends AppCompatActivity {

    private static final String MESSAGE = "extra:message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        final String message = getIntent().getStringExtra(MESSAGE);
        final TextView viewMessage = findViewById(R.id.message);
        viewMessage.setText(message);

        final Button btnEmail = findViewById(R.id.btn_email);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmailSenderApp(message);
            }
        });
    }

    private void openEmailSenderApp(String body) {
        final Intent intent = new Intent(Intent.ACTION_SENDTO).setData(Uri.parse(String.format("mailto:%s", getString(R.string.email_address))))
                .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject))
                .putExtra(Intent.EXTRA_TEXT, body);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.no_email_app, Toast.LENGTH_LONG).show();
        }
    }

    public static void startPreviewActivity(Activity activity, String text) {
        Intent intent = new Intent(activity, PreviewActivity.class);
        intent.putExtra(MESSAGE, text);
        activity.startActivity(intent);
    }
}