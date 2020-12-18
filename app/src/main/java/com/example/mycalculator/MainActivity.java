package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    String oldNumber="";
    String op="+";
    boolean isNewOp =true;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.infoTextView);

    }
    public void numberEvent(View view) {
        if(isNewOp)
            editText.setText("");
        isNewOp = false;
        String number = editText.getText() .toString();
        switch (view.getId()) {
            case R.id.buttonNine:
                number += "9";
                break;
            case R.id.buttonEight:
                number += "8";
                break;
            case R.id.buttonSeven:
                number += "7";
                break;
            case R.id.buttonSix:
                number += "6";
                break;
            case R.id.buttonFive:
                number += "5";
                break;
            case R.id.buttonFour:
                number += "4";
                break;
            case R.id.buttonThree:
                number += "3";
                break;
            case R.id.buttonTwo:
                number += "2";
                break;
            case R.id.buttonOne:
                number += "1";
                break;
            case R.id.buttonZero:
                number += "0";
                break;
            case R.id.buttonDot:
                number += ".";
                break;
            case R.id.buttonNegaPos:
                number = "-"+number;
                break;
        }
        editText.setText(number);
    }
    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber =editText.getText().toString();
        switch (view.getId()){
            case R.id.buttonDivide: op ="/"; break;
            case R.id.buttonMultiply: op ="*"; break;
            case R.id.buttonAdd: op ="+"; break;
            case R.id.buttonSubtract: op ="-"; break;
        }
    }
    public void equalEvent(View view) {
        String newNumber = editText.getText().toString();
        double result = 0.0;
        switch (op) {
            case "+":
                result = Double.parseDouble(oldNumber)+
                        Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber)-
                        Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber)/
                        Double.parseDouble(newNumber);
                break;
        }
        textView.setText(result+"");
    }
    public void ClearEvent(View view) {
        editText.setText("");
        textView.setText("0");
        isNewOp = true;

    }
    public void PercentageEvent(View view) {
        double no =Double.parseDouble(textView.getText().toString())/100;
        textView.setText(no+"");
        isNewOp = true;
    }
}