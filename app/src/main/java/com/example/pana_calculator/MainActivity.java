package com.example.pana_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private String currentNumber = "";
    private String operation = "";
    private double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);

        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(v -> {
            currentNumber = "";
            operation = "";
            result = 0;
            tvResult.setText("0");
        });
        Button btnEquals = findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(v -> performOperation(""));
        Button btnPlus = findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(v -> performOperation("+"));
        Button btnMinus = findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(v -> performOperation("-"));

        Button btnMultiply = findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(v -> performOperation("*"));

        Button btnDivide = findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(v -> performOperation("/"));

        Button btnZero = findViewById(R.id.btnZero);
        btnZero.setOnClickListener(v -> handleNumberInput("0"));

        Button btnOne = findViewById(R.id.btnOne);
        btnOne.setOnClickListener(v -> handleNumberInput("1"));

        Button btnTwo = findViewById(R.id.btnTwo);
        btnTwo.setOnClickListener(v -> handleNumberInput("2"));

        Button btnThree = findViewById(R.id.btnThree);
        btnThree.setOnClickListener(v -> handleNumberInput("3"));

        Button btnFour = findViewById(R.id.btnFour);
        btnFour.setOnClickListener(v -> handleNumberInput("4"));

        Button btnFive = findViewById(R.id.btnFive);
        btnFive.setOnClickListener(v -> handleNumberInput("5"));

        Button btnSix = findViewById(R.id.btnSix);
        btnSix.setOnClickListener(v -> handleNumberInput("6"));

        Button btnSeven = findViewById(R.id.btnSeven);
        btnSeven.setOnClickListener(v -> handleNumberInput("7"));

        Button btnEight = findViewById(R.id.btnEight);
        btnEight.setOnClickListener(v -> handleNumberInput("8"));

        Button btnNine = findViewById(R.id.btnNine);
        btnNine.setOnClickListener(v -> handleNumberInput("9"));

    }

    private void handleNumberInput(String number) {
        currentNumber += number;
        tvResult.setText(currentNumber);
    }

    private void performOperation(String op) {
        if (operation.isEmpty()) {
            result = Double.parseDouble(currentNumber);
        } else {
            calculate();
        }
        operation = op;
        currentNumber = "";
    }

    private void calculate() {
        double num = Double.parseDouble(currentNumber);
        switch (operation) {
            case "+":
                result += num;
                break;
            case "-":
                result -= num;
                break;
            case "*":
                result *= num;
                break;
            case "/":
                result /= num;
                break;
        }
        currentNumber = "";
        operation = "";
        tvResult.setText(String.valueOf(result));
    }
}