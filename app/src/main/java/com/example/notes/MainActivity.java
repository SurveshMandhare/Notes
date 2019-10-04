package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton add;
    TextView label,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.addIcon);
        label = findViewById(R.id.label);
        day = findViewById(R.id.day);

        label.setText(getIntent().getStringExtra("topic"));
        day.setText(getIntent().getStringExtra("day"));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f2s = new Intent(MainActivity.this, text_click.class);
                startActivity(f2s);
            }
        });
    }
}
