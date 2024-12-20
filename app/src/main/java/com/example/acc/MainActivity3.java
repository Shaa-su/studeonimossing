package com.example.acc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    private TextView named;
    private ImageView submittedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        TextView welcomeText = findViewById(R.id.welcomeText);
        named = findViewById(R.id.named);
        submittedImage = findViewById(R.id.submittedImage);

        // Get the intent data
        String fullName = getIntent().getStringExtra("fullName");
        String photoPath = getIntent().getStringExtra("photoPath");

        // Add null check and set text
        if (fullName != null && !fullName.isEmpty()) {
            named.setText(fullName + "!");
        } else {
            named.setText("No name provided");
        }

        // Set the image
        if (photoPath != null && !photoPath.isEmpty()) {
            Bitmap bitmap = BitmapFactory.decodeFile(photoPath);
            submittedImage.setImageBitmap(bitmap);
        } else {
            Toast.makeText(this, "No photo provided", Toast.LENGTH_SHORT).show();
        }
    }
}