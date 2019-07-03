package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button btnLeftParenthesis, btnRightparenthesis, btnPercent;
    TextView calcDisplayTextView;
    Float firstNumber, secondNumber, answer;
    Boolean add, subtract, multiply, divide;
    String operand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        calcDisplayTextView = findViewById(R.id.displayTextView);

        add = false;
        subtract = false;
        multiply = false;
        divide = false;
        operand = "";
    }

    @OnClick({R.id.zeroButton, R.id.oneButton, R.id.twoButton, R.id.threeButton, R.id.fourButton, R.id.fiveButton, R.id.sixButton, R.id.sevenButton, R.id.eightButton, R.id.nineButton})
    public void onClick(Button v) {
        calcDisplayTextView.append(v.getText().toString());
    }

    @OnClick(R.id.decimalButton)
    public void decimalClicked(Button v){
        String displayViewContent = calcDisplayTextView.getText().toString();
        if (displayViewContent.contains(".")){
            calcDisplayTextView.append("");
        } else {
            calcDisplayTextView.append(v.getText().toString());
        }
    }

    @OnClick(R.id.clearButton)
    public void clearFunction() {
        calcDisplayTextView.setText("");
        add = false;
        subtract = false;
        multiply = false;
        divide = false;
    }

    @OnClick(R.id.percentageButton)
    public void percentClicked() {
        secondNumber = Float.parseFloat(calcDisplayTextView.getText().toString());
        if (add == true) {
            Float addPercentNumber;
            addPercentNumber = (secondNumber / 100) * firstNumber;
            answer = firstNumber + addPercentNumber;
            calcDisplayTextView.setText(answer.toString());
            add = false;
        }
        if (subtract == true) {
            Float subtractPercentNumber;
            subtractPercentNumber = (secondNumber / 100) * firstNumber;
            answer = firstNumber - subtractPercentNumber;
            calcDisplayTextView.setText(answer.toString());
            subtract = false;
        } else if (divide == true) {
            Float divideSecondNumber;
            divideSecondNumber = secondNumber / 100;
            answer = firstNumber / divideSecondNumber;
            calcDisplayTextView.setText(answer.toString());
            divide = false;
        } else if (multiply == true) {
            Float multiplyPercentSecondNumber;
            multiplyPercentSecondNumber = secondNumber / 100;
            answer = firstNumber * multiplyPercentSecondNumber;
            calcDisplayTextView.setText(answer.toString());
            multiply = false;
        }
    }

    @OnClick(R.id.addButton)
    public void addFunction() {
        add = true;
        operand = " + ";
        firstNumber = Float.parseFloat(calcDisplayTextView.getText().toString());
        calcDisplayTextView.setText("");
    }

    @OnClick(R.id.minusButton)
    public void subtractFunction() {
        subtract = true;
        operand = " - ";
        firstNumber = Float.parseFloat(calcDisplayTextView.getText().toString());
        calcDisplayTextView.setText("");
    }

    @OnClick(R.id.divisionButton)
    public void divideFunction() {
        divide = true;
        operand = " / ";
        firstNumber = Float.parseFloat(calcDisplayTextView.getText().toString());
        calcDisplayTextView.setText("");
    }

    @OnClick(R.id.multiplyButton)
    public void multiplyFunction() {
        multiply = true;
        operand = " * ";
        firstNumber = Float.parseFloat(calcDisplayTextView.getText().toString());
        calcDisplayTextView.setText("");
    }

    @OnClick(R.id.equalsButton)
    public void equalFunction() {
        secondNumber = Float.parseFloat(calcDisplayTextView.getText().toString());
        if (add == true) {
            answer = firstNumber + secondNumber;
            calcDisplayTextView.setText(answer.toString());
            add = false;
        }
        Log.i("whatisadd", add.toString());
        if (subtract == true) {
            answer = firstNumber - secondNumber;
            calcDisplayTextView.setText(answer.toString());
            subtract = false;
        } else if (divide == true) {
            answer = firstNumber / secondNumber;
            calcDisplayTextView.setText(answer.toString());
            divide = false;
        } else if (multiply == true) {
            answer = firstNumber * secondNumber;
            calcDisplayTextView.setText(answer.toString());
            multiply = false;
        }
    }
}
