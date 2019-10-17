package com.example.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ArrayFormat> exampleList;
    String day, title;
    private FloatingActionButton add, text, speech, camera, cancel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findHere();
        day = getIntent().getStringExtra("day");
        title = getIntent().getStringExtra("topic");
        configHere();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addClick();

                text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent f2text = new Intent(MainActivity.this, text_click.class);
                        f2text.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(f2text);
                    }
                });

                speech.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent f2speech = new Intent(MainActivity.this, speech_click.class);
                        f2speech.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(f2speech);
                    }
                });

                camera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent f2camera = new Intent(MainActivity.this, camera_click.class);
                        f2camera.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(f2camera);
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cancelClick();
                    }
                });
            }
        });

    }

    private void configHere() {
        recyclerView.setHasFixedSize(true);
        exampleList.add(new ArrayFormat(day, title));
        layoutManager = new LinearLayoutManager(this);
        adapter = new AdapterClass(exampleList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void findHere() {
        exampleList = new ArrayList<ArrayFormat>();
        add = findViewById(R.id.add);
        text = findViewById(R.id.text);
        speech = findViewById(R.id.speech);
        camera = findViewById(R.id.camera);
        cancel = findViewById(R.id.cancel);
        recyclerView = findViewById(R.id.recyclerView);
    }

    public void addClick() {
        text.show();
        speech.show();
        camera.show();
        cancel.show();
        add.hide();
    }

    public void cancelClick() {
        text.hide();
        speech.hide();
        camera.hide();
        cancel.hide();
        add.show();
    }
}
