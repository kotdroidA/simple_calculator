package com.kodroid.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {


    EditText etFirstNum,etSecondNum;
    TextView tvResult,tvPlus,tvMinus,tvMultiply,tvDivision,tvClear;
    double num1,num2,result;
    String numOne="",numTwo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        // initializing views
        etFirstNum = findViewById(R.id.etFirstNumber);
        etSecondNum = findViewById(R.id.etSecondNumber);

        tvPlus = findViewById(R.id.tvPlus);
        tvMinus = findViewById(R.id.tvMinus);
        tvMultiply = findViewById(R.id.tvMultiply);
        tvDivision = findViewById(R.id.tvDivision);
        tvResult = findViewById(R.id.tvResult);
        tvClear =findViewById(R.id.tvClear);



        // set on click listener
        tvPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumbers();
            }
        });


        tvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });

        tvMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subNumbers();
            }
        });


        tvMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplyNumbers();
            }
        });

        tvDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divisionNumbers();
            }
        });



    }

    void addNumbers(){
         numOne = etFirstNum.getText().toString().trim();
         numTwo = etSecondNum.getText().toString().trim();

        if(!validation()){
            return;
        }



        num1 = Double.parseDouble(numOne);
        num2 = Double.parseDouble(numTwo);

        result = num1+num2;


        tvResult.setText(result+"");
    }
    void subNumbers(){
        numOne = etFirstNum.getText().toString().trim();
        numTwo = etSecondNum.getText().toString().trim();

        if(!validation()){
            return;
        }



        num1 = Double.parseDouble(numOne);
        num2 = Double.parseDouble(numTwo);

        result = num1-num2;


        tvResult.setText(result+"");
    }

    void multiplyNumbers(){
        numOne = etFirstNum.getText().toString().trim();
        numTwo = etSecondNum.getText().toString().trim();

        if(!validation()){
            return;
        }



        num1 = Double.parseDouble(numOne);
        num2 = Double.parseDouble(numTwo);

        result = num1*num2;


        tvResult.setText(result+"");
    }

    void divisionNumbers(){
        numOne = etFirstNum.getText().toString().trim();
        numTwo = etSecondNum.getText().toString().trim();

        if(!validation()){
            return;
        }



        num1 = Double.parseDouble(numOne);
        num2 = Double.parseDouble(numTwo);
        if(num2==0){
            Toast.makeText(this, "can't divide by 0", Toast.LENGTH_SHORT).show();
            return;
        }

        result = num1/num2;


        tvResult.setText(result+"");
    }


    boolean validation(){
        if(numOne.isEmpty()){
            Toast.makeText(this, "Please enter 1st number.", Toast.LENGTH_LONG).show();
            return false;
        }else if(numTwo.isEmpty()){
            Toast.makeText(this, "Please enter 2nd number.", Toast.LENGTH_LONG).show();
            return false;
        }
        return  true;
    }

    void clearFields(){
        etFirstNum.setText("");
        etSecondNum.setText("");
        numOne="";
        numTwo="";
        num1=0.0;
        num2=0.0;
        result=0.0;
        tvResult.setText("0.0");
    }
}