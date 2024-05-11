package com.example.tapngo.Frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tapngo.R;

// this activity is for the Train and Bus button
public class HomePage extends AppCompatActivity {

    CardView buttonBus, buttonTrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        buttonBus = findViewById(R.id.buttonBus);
        buttonTrain = findViewById(R.id.buttonTrain);

        buttonTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DestinationFinder.class));
            }
        });

    }
}