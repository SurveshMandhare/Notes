package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class camera_click extends Activity {

    EditText topic;
    Button btnCamera;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_click);

        topic = findViewById(R.id.TopicText);
        btnCamera = findViewById(R.id.btnCamera);
        imageView = findViewById(R.id.imageView);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }

    public void done(View view) {
        Intent camera2f = new Intent(this, MainActivity.class);
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        String myText = String.valueOf(topic.getText());
        String day = sdf.format(today);

        if (TextUtils.isEmpty(myText)) {
            topic.setError("Title is Empty!");
        } else {
            camera2f.putExtra("topic", myText);
            camera2f.putExtra("day", day);
            startActivity(camera2f);
        }
    }
}
