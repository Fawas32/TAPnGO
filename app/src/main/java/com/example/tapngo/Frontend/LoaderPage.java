package com.example.tapngo.Frontend;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tapngo.R;

//this page is for the loading screen
public class LoaderPage extends AppCompatActivity {

    AlertDialog alertDialog;

    public void showProgressDialog() {
        AlertDialog.Builder dailogBuilder = new AlertDialog.Builder(LoaderPage.this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.activity_loader_page, null);
        dailogBuilder.setView(dialogView);
        alertDialog = dailogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    public void hideProgressDialog() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
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
}