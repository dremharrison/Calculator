package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLeftParenthesis, btnRightParenthesis, btnPercent, btnClear, btnDivide, btnMultiply, btnAdd, btnSubtract, btnDecimal, btnEquals;
    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    TextView calcDisplayTextView;
    Float firstNumber, secondNumber, answer;
    Boolean add, subtract, multiply, divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcDisplayTextView = findViewById(R.id.displayTextView);
        btnZero = findViewById(R.id.zeroButton);
        btnOne = findViewById(R.id.oneButton);
        btnTwo = findViewById(R.id.twoButton);
        btnThree = findViewById(R.id.threeButton);
        btnFour = findViewById(R.id.fourButton);
        btnFive = findViewById(R.id.fiveButton);
        btnSix = findViewById(R.id.sixButton);
        btnSeven = findViewById(R.id.sevenButton);
        btnEight = findViewById(R.id.eightButton);
        btnNine = findViewById(R.id.nineButton);
        btnRightParenthesis = findViewById(R.id.rightParenthesisButton);
        btnLeftParenthesis = findViewById(R.id.leftParenthesisButton);
        btnPercent = findViewById(R.id.percentageButton);
        btnClear = findViewById(R.id.clearButton);
        btnDivide = findViewById(R.id.divisionButton);
        btnMultiply = findViewById(R.id.multiplyButton);
        btnAdd = findViewById(R.id.addButton);
        btnSubtract = findViewById(R.id.minusButton);
        btnDecimal = findViewById(R.id.decimalButton);
        btnEquals = findViewById(R.id.equalsButton);

        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add = true;
               firstNumber = Float.parseFloat(calcDisplayTextView.getText().toString());
               calcDisplayTextView.setText("");
                Log.i("isthisnull", add.toString());
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiply = true;
                firstNumber = Float.parseFloat(calcDisplayTextView.getText().toString());
                calcDisplayTextView.setText("");
                Log.i("isthisnull", multiply.toString());
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subtract = true;
                firstNumber = Float.parseFloat(calcDisplayTextView.getText().toString());
                calcDisplayTextView.setText("");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                divide = true;
                firstNumber = Float.parseFloat(calcDisplayTextView.getText().toString());
                calcDisplayTextView.setText("");
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondNumber = Float.parseFloat(calcDisplayTextView.getText().toString());
                 if (add == true){
                    answer = firstNumber + secondNumber;
                    calcDisplayTextView.setText(answer.toString());
                    add = false;
                 }
                Log.i("whatisadd", add.toString());
                if (subtract == true){
                    answer = firstNumber - secondNumber;
                    calcDisplayTextView.setText(answer.toString());
                    subtract = false;
                }
               else if (divide == true){
                    answer = firstNumber / secondNumber;
                    calcDisplayTextView.setText(answer.toString());
                    divide = false;
                }
                else if (multiply == true){
                    answer = firstNumber * secondNumber;
                    calcDisplayTextView.setText(answer.toString());
                    multiply = false;
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clearButton:
                calcDisplayTextView.setText("");
                add = false;
                subtract = false;
                multiply = false;
                divide = false;
                break;
            case R.id.zeroButton:
                calcDisplayTextView.append("0");
                break;
            case R.id.oneButton:
                calcDisplayTextView.append("1");
                break;
            case R.id.twoButton:
                calcDisplayTextView.append("2");
                break;
            case R.id.threeButton:
                calcDisplayTextView.append("3");
                break;
            case R.id.fourButton:
                calcDisplayTextView.append("4");
                break;
            case R.id.fiveButton:
                calcDisplayTextView.append("5");
                break;
            case R.id.sixButton:
                calcDisplayTextView.append("6");
                break;
            case R.id.sevenButton:
                calcDisplayTextView.append("7");
                break;
            case R.id.eightButton:
                calcDisplayTextView.append("8");
                break;
            case R.id.nineButton:
                calcDisplayTextView.append("9");
                break;
            case R.id.decimalButton:
                calcDisplayTextView.append(".");
                break;
        }
    }
}
