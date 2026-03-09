package com.example.week8;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private double number1;
    private double number2;

    private TextView output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        output = findViewById(R.id.result);
    }

    private boolean readInputs(){
        EditText textNumber1 = findViewById(R.id.text_number1);
        EditText textNumber2 = findViewById(R.id.text_number2);

        try {
            number1 = Double.parseDouble(textNumber1.getText().toString());
            number2 = Double.parseDouble(textNumber2.getText().toString());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String formatResult(double result) {
        if (result % 1 == 0) {
            return String.valueOf((long) result);
        } else {
            return String.valueOf(result);
        }
    }

    public void onPlus(View view) {
        boolean succeed = readInputs();
        if (!succeed) {
            output.setText("Invalid input");
            return;
        }
        output.setText(formatResult(number1 + number2));
    }

    public void onMinus(View view) {
        boolean succeed = readInputs();
        if (!succeed) {
            output.setText("Invalid input");
            return;
        }
        output.setText(formatResult(number1 - number2));
    }

    public void onMultiply(View view) {
        boolean succeed = readInputs();
        if (!succeed) {
            output.setText("Invalid input");
            return;
        }
        output.setText(formatResult(number1 * number2));
    }

    public void onDivide(View view) {
        readInputs();
        if (number2 == 0) {
            output.setText("Error: Division by zero");
            return;
        }
        output.setText(formatResult(number1 / number2));

    }
}