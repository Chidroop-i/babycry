package com.example.crybaby;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class heightWeight extends AppCompatActivity {
    EditText weight,height;
    TextView w,h;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height_weight);
        weight = (EditText) findViewById(R.id.editWeight);
        height = (EditText) findViewById(R.id.editHeight);
        w = (TextView) findViewById(R.id.weight);
        h = (TextView) findViewById(R.id.height);
        b1 = (Button) findViewById(R.id.button8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String w1 = weight.getText().toString();
                String h1 = height.getText().toString();//gets you the contents of edit text
                w.setText(w1);
                h.setText(h1);//displays it in a textview..

            }
        });

    }
}
