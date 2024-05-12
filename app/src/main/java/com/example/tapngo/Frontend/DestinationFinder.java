package com.example.tapngo.Frontend;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tapngo.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DestinationFinder extends AppCompatActivity {

    EditText edtFrom, edtTo, edtDate;
    ImageView imgDate;
    Button btnSearch, btnBack;
    public static String from = "", to = "", date = "";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_finder);

        edtFrom = findViewById(R.id.edtFrom);
        edtTo = findViewById(R.id.edtTo);
        edtDate = findViewById(R.id.edtDate);
        edtDate.setEnabled(false);
        imgDate = findViewById(R.id.imgDate);
        btnSearch = findViewById(R.id.btnSearch);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imgDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate();
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                from = edtFrom.getText().toString().trim();
                to = edtTo.getText().toString().trim();
                date = edtDate.getText().toString().trim();

                if (from.isEmpty()) {
                    edtFrom.setError("Required!");
                    edtFrom.requestFocus();
                    return;
                }
                if (to.isEmpty()) {
                    edtTo.setError("Required!");
                    edtTo.requestFocus();
                    return;
                }
                if (date.isEmpty()) {
                    edtDate.setError("Required!");
                    edtDate.requestFocus();
                    return;
                }

                // Show loading screen
                showProgressDialog();

                // Perform API request asynchronously
                new FetchDataAsyncTask().execute(from, to, date);
            }
        });
    }

    private void selectDate() {
        try {
            final Calendar calendar = Calendar.getInstance();
            final int day = calendar.get(Calendar.DAY_OF_MONTH);
            final int month = calendar.get(Calendar.MONTH);
            final int year = calendar.get(Calendar.YEAR);

            DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
                    calendar.set(year, month, day);
                    date = sdf.format(calendar.getTime());
                    edtDate.setText(date);
                }
            }, year, month, day);
            datePicker.setTitle("Select Date");
            datePicker.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showProgressDialog() {
        // Show your loading screen here
        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
    }

    public void hideProgressDialog() {
        // Hide your loading screen here
    }

    private static class FetchDataAsyncTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            String from = params[0];
            String to = params[1];
            String date = params[2];

            // Perform API request here using 'from', 'to', and 'date' variables
            // For example, you can use HttpRequest.executeGet2() method
            // to fetch data from the API based on 'from', 'to', and 'date'

            // Simulating a delay for demonstration purposes
            try {
                Thread.sleep(2000); // 2 seconds delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            // Hide loading screen
            // To access non-static methods like hideProgressDialog(), you need a reference to the activity
            // You can pass the activity reference to the AsyncTask constructor or use a WeakReference
        }
    }
}
