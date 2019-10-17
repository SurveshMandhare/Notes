package com.example.notes;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class speech_click extends AppCompatActivity {

    TextView days;
    EditText topic;
    ImageView play, pause, stop;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_click);

        days = findViewById(R.id.dateText);
        topic = findViewById(R.id.TopicText);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        days.setText(sdf.format(today));

    }

    public void playIt(View view) {
        play.setVisibility(View.INVISIBLE);
        pause.setVisibility(View.VISIBLE);
        stop.setVisibility(View.VISIBLE);
    }

    public void stopIt(View view) {
        play.setVisibility(View.VISIBLE);
        pause.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);
    }

    public void done(View view) {
        Intent speech2f = new Intent(this, MainActivity.class);
        String myText = String.valueOf(topic.getText());
        String day = String.valueOf(days.getText());

        if (TextUtils.isEmpty(myText)) {
            topic.setError("Title is Empty!");
        } else {
            speech2f.putExtra("topic", myText);
            speech2f.putExtra("day", day);
            startActivity(speech2f);
        }
    }
}
