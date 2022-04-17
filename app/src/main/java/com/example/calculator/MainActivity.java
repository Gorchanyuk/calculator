package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    Double cashNum1;
    Double cashNum2;
    String operator;
    TextView text;
    String cash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        cash = "";
        operator = "";

    }

    public void num1(View view){
        cash += "1";
        text.setText(cash);
    }
    public void num2(View view){
        cash += "2";
        text.setText(cash);
    }

    public void num3(View view){
        cash += "3";
        text.setText(cash);
    }

    public void num4(View view){
        cash += "4";
        text.setText(cash);
    }

    public void num5(View view){
        cash += "5";
        text.setText(cash);
    }

    public void num6(View view){
        cash += "6";
        text.setText(cash);
    }

    public void num7(View view){
        cash += "7";
        text.setText(cash);
    }

    public void num8(View view){
        cash += "8";
        text.setText(cash);
    }

    public void num9(View view){
        cash += "9";
        text.setText(cash);
    }

    public void num0(View view){
        if(!cash.equals(""))
            cash += "0";
        text.setText(cash);
    }

    public void dot(View view){
        if(cash.isEmpty()) cash += "0";
        cash += ".";
        text.setText(cash);
    }


//    Операция сложения
    public void add(View view){
        mathOperation(view, "+");
    }

//    Оперрация вычитания
    public void sub(View view){
        mathOperation(view, "-");
    }


//    Операция деления
    public void div(View view){
        mathOperation(view, "/");
    }

//    Операция умножения
    public void mul(View view){
        mathOperation(view, "*");
    }

//    Оперция вычисления корня
    public void sqrt(View view){
        String num = text.getText().toString();
        cashNum1 = Math.sqrt(Double.valueOf(num));
        writeRes(cashNum1);
        cash = "";

    }

//    Операция 1/х
    public void inverseProp(View view){
    cashNum1 = 1 / (Double.valueOf(text.getText().toString()));
    writeRes(cashNum1);
    cash = "";
    }

//    Операция +/-
    public void inversion(View view){
        if(!text.getText().toString().isEmpty()) {
            Double num = Double.valueOf(text.getText().toString());
            Double res = num * -1;
            writeRes(res);
        }
    }

//    Операция вычисления
    public void res(View view){
        if(!cash.isEmpty())
            cashNum2 = Double.valueOf(cash);
        Double res;

        switch(operator){
            case "+":
                res = cashNum1 + cashNum2;
                writeRes(res);
                break;
            case "-":
                res = cashNum1 - cashNum2;
                writeRes(res);
                break;
            case "*":
                res = cashNum1 * cashNum2;
                writeRes(res);
                break;
            case "/":
                res = cashNum1 / cashNum2;
                writeRes(res);
                break;
            default:
                break;
        }
        cash = "";
        if(!text.getText().toString().isEmpty())
            cashNum1 = Double.valueOf(text.getText().toString());
    }


    public void clear(View view){
        text.setText("");
        cashNum1 = 0.0;
        operator = "";
        cash = "";

    }

    private void createCashNum1(){
        cashNum1 = Double.valueOf(text.getText().toString());
        cash = "";
    }

    private void writeRes(Double num){
        if(num % 1 == 0)
            text.setText(String.valueOf(num.intValue()));
        else
            text.setText(num.toString());
    }

    private void mathOperation(View view, String arg){
        if (!cash.isEmpty()) res(view);
        createCashNum1();
        operator = arg;
        cash = "";
    }

}