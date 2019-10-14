package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class text_click extends AppCompatActivity {
    Switch aSwitch;
    TextView days, times;
    EditText topic, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_click);

        aSwitch = findViewById(R.id.switch1);
        days = findViewById(R.id.dateText);
        times = findViewById(R.id.timeText);
        topic = findViewById(R.id.TopicText);
        desc = findViewById(R.id.DescriptionText);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    days.setVisibility(View.VISIBLE);
                    times.setVisibility(View.VISIBLE);
                } else {
                    days.setVisibility(View.INVISIBLE);
                    times.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void datey(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this);

        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int yr, int month, int day) {
                days.setText(day + "/" + (month + 1) + "/" + yr);
            }
        });
        datePickerDialog.setTitle("Select Date");
        datePickerDialog.show();
    }

    public void timey(View view) {
        TimePickerDialog timePickerDialog;
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hr, int min) {
                times.setText(hr + ":" + min);
            }
        }, Calendar.HOUR_OF_DAY, Calendar.MINUTE, true);
        timePickerDialog.setTitle("Set Time");
        timePickerDialog.show();
    }

    public void done(View view) {
        Intent t2f = new Intent(this, MainActivity.class);
        String myText = String.valueOf(topic.getText());
        String day = String.valueOf(days.getText());

        if (TextUtils.isEmpty(myText)){
            topic.setError("Title is Empty!");
        } else{
            t2f.putExtra("topic", myText);
            t2f.putExtra("day", day);
            startActivity(t2f);
        }
    }

}
