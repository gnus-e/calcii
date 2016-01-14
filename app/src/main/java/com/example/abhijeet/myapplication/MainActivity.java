package com.example.abhijeet.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener{
    public static int nArgument, nOperandA, nOperandB;
    public static String sOperator ="";
    public static Stack<

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
    }
    public void onClick(View v)
    {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the    action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onNumClick(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textViewInput);
        String sDisplay = textView.getText().toString();
        int nDigit = 0;
        boolean bIsValid = false;
        switch(view.getId())
        {
            case R.id.button_num_0:
                bIsValid = true;
                sDisplay =  sDisplay + "0";
                nDigit = 0;
                break;
            case R.id.button_num_1:
                bIsValid = true;
                sDisplay =  sDisplay + "1";
                nDigit = 1;
                break;
            case R.id.button_num_2:
                bIsValid = true;
                sDisplay =  sDisplay + "2";
                nDigit = 2;
                break;
            case R.id.button_num_3:
                bIsValid = true;
                sDisplay =  sDisplay + "3";
                nDigit = 3;
                break;
            case R.id.button_num_4:
                bIsValid = true;
                sDisplay =  sDisplay + "4";
                nDigit = 4;
                break;
            case R.id.button_num_5:
                bIsValid = true;
                sDisplay =  sDisplay + "5";
                nDigit = 5;
                break;
            case R.id.button_num_6:
                bIsValid = true;
                sDisplay =  sDisplay + "6";
                nDigit = 6;
                break;
            case R.id.button_num_7:
                bIsValid = true;
                sDisplay =  sDisplay + "7";
                nDigit = 7;
                break;
            case R.id.button_num_8:
                bIsValid = true;
                sDisplay =  sDisplay + "8";
                nDigit = 8;
                break;
            case R.id.button_num_9:
                bIsValid = true;
                sDisplay =  sDisplay + "9";
                nDigit = 9;
                break;
            default:
                break;
        }
        nArgument = (nArgument * 10) + nDigit;
        textView.setText(sDisplay);
    }

    /** Called when the user clicks the Send button */
    public void onOperatorClick(View view) {
        if(!sOperator.isEmpty())
            calculateAndShowResult();
        switch(view.getId())
        {
            case R.id.button_add:
                sOperator = "+";
                break;
            case R.id.button_division:
                sOperator = "/";
                break;
            case R.id.button_sub:
                sOperator = "-";
                break;
            case R.id.button_mul:
                sOperator = "*";
                break;
        }
        nOperandA = nArgument;
        nArgument = 0;
        TextView textView = (TextView) findViewById(R.id.textViewInput);
        String sDisplay = textView.getText().toString();
        textView.setText(sDisplay + sOperator);
    }
    public void showResult(View view) {
        calculateAndShowResult();
    }
    public void calculateAndShowResult()
    {
        nOperandB = nArgument;
        int nResult = 0;
        if(sOperator == "+")
            nResult = nOperandA + nOperandB;
        else if(sOperator == "-")
            nResult = nOperandA - nOperandB;
        else if(sOperator == "*")
            nResult = nOperandA * nOperandB;
        else if(sOperator == "/")
            nResult = nOperandA / nOperandB;

        TextView textView = (TextView) findViewById(R.id.text_Result);
        textView.setText(Integer.toString(nResult));
        nOperandA = nResult;
        nArgument = nResult;
        sOperator = "";
    }
}
