package com.example.tapngo.Frontend;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.tapngo.R;

public class LoaderPage extends AppCompatActivity {

    private static final long LOADING_DELAY = 2000; // 2 seconds delay
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader_page);

        showProgressDialog(); // Show the loading dialog

        // Simulating loading process with a delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideProgressDialog(); // Hide the loading dialog
                startMainActivity(); // Start MainActivity after the delay
            }
        }, LOADING_DELAY);
    }

    public void showProgressDialog() {
        // Your AlertDialog code here
    }

    public void hideProgressDialog() {
        // Your hide dialog code here
    }

    private void startMainActivity() {
        Intent intent = new Intent(LoaderPage.this, MainActivity.class);
        startActivity(intent);
        finish(); // Finish LoaderPage activity
    }
}

//    AlertDialog dialog;
//    Activity activity;
//
//
//    LoaderPage(Activity myActivity){
//        activity = myActivity;
//    }
//
//    void startloader(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//
//        LayoutInflater inflater = activity.getLayoutInflater();
//        builder.setView(inflater.inflate(R.layout.activity_loader_page, null));
//        builder.setCancelable(true);
//
//        dialog = builder.create();
//        dialog.show();
//    }
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_loader_page);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
