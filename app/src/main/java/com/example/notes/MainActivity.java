package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton add, text, speech, camera, cancel;
    ArrayList<ArrayFormat> exampleList;
    String day, title;
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
                        Intent f2s = new Intent(MainActivity.this, text_click.class);
                        f2s.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(f2s);
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
