package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnShort, btnLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShort = findViewById(R.id.btnToastShort);
        btnLong = findViewById(R.id.btnToastLong);

        btnShort.setOnClickListener(this);
        btnLong.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int toastID;
        String text = "";
        if(view.getId() == R.id.btnToastLong) {
            toastID = Toast.LENGTH_LONG;
            text = "Long Toast";
        }
        else {
            toastID = Toast.LENGTH_SHORT;
            text = "Short Toast";
        }
        Toast.makeText(this, text, toastID).show();
    }
}
