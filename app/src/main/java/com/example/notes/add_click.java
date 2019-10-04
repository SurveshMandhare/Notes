package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class add_click extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_click);
    }

    public void text(View view) {
        Intent s2t = new Intent(add_click.this, text_click.class);
        startActivity(s2t);
    }

    public void speech(View view) {
    }

    public void camera(View view) {
    }

    public void cancel(View view) {
        Intent s2f = new Intent(add_click.this, MainActivity.class);
        startActivity(s2f);
    }
}
