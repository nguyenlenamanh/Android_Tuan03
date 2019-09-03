package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityBT3 extends AppCompatActivity {

    EditText editText;
    Button btnAdd;
    TextView tvDisplay;
    ListView lvNames;
    ArrayList<String> Names;
    AppCompatActivity parent = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt3);

        editText = findViewById(R.id.txtName);
        btnAdd = findViewById(R.id.btnAdd);
        tvDisplay = findViewById(R.id.tvDisplay);
        lvNames = findViewById(R.id.lvNames);

        Names = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.arr)));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Names);
        arrayAdapter.notifyDataSetChanged();

        lvNames.setAdapter(arrayAdapter);

        lvNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvDisplay.setText("position: " + i + " ,value:" + Names.get(i));
            }
        });

        //Toast.makeText(parent,editText.getText().toString(),Toast.LENGTH_SHORT).show();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Names.add(editText.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
