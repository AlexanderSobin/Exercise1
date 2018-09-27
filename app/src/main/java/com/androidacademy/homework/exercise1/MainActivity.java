package com.androidacademy.homework.exercise1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText message = findViewById(R.id.edit_text);
        final Button btnPreview = findViewById(R.id.btn_preview);

        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPreviewActivity(message.getText().toString());
            }
        });
    }

    private void openPreviewActivity(String text) {
        PreviewActivity.startPreviewActivity(this, text);
    }
}