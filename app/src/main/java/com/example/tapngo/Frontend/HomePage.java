package com.example.tapngo.Frontend;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tapngo.R;

// this activity is first page for the Train and Bus button
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

        buttonBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

//        buttonBus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
//                builder.setMessage("Coming Soon")
//                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.dismiss(); // Dismiss the dialog when OK is clicked
//                            }
//                        });
//                AlertDialog dialog = builder.create();
//                dialog.show();
////                TextView textView = buttonBus.findViewById();
////                buttonBus.setText("Coming Soon");
////                buttonBus.setEnabled(false);
//            }
//        });

    }
}