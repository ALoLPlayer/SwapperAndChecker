package com.example.swapper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText text1, text2;
    private Button btnSwap, btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        btnSwap = findViewById(R.id.btnSwap);
        btnCheck = findViewById(R.id.btnCheck);

        btnSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapText();
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkText();
            }
        });

    }

    private void swapText() {
        String temp = text1.getText().toString();
        text1.setText(text2.getText().toString());
        text2.setText(temp);
    }

    private void checkText() {
        String str1 = text1.getText().toString();
        String str2 = text2.getText().toString();

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);

        if (str1.equals(str2)) {
            intent.putExtra("result", "SAME");
            startActivity(intent);
        } else {
            intent.putExtra("result", "NOT THE SAME");
            startActivity(intent);
        }
    }
}
