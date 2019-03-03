package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button divisionBtn, clearBtn, minusBtn, multiplicationBtn, plusBtn;
    TextView tvResult;
    EditText firstNumber, secondNumber;
    ImageView operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        divisionBtn = findViewById(R.id.divisionBtn);
        clearBtn = findViewById(R.id.clearBtn);
        minusBtn = findViewById(R.id.minusBtn);
        multiplicationBtn = findViewById(R.id.multiplicationBtn);
        plusBtn = findViewById(R.id.plusBtn);

        operation = findViewById(R.id.operation);

        tvResult = findViewById(R.id.tvResult);

        firstNumber = findViewById(R.id.firstNumb);
        secondNumber = findViewById(R.id.secondNumb);

        divisionBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);
        minusBtn.setOnClickListener(this);
        multiplicationBtn.setOnClickListener(this);
        plusBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        double a, b;
        if(v.getId() == R.id.clearBtn){
            firstNumber.setText("");
            secondNumber.setText("");
            tvResult.setText("");
            operation.setImageResource(R.drawable.question);
            Toast.makeText(this,"Чисто",Toast.LENGTH_SHORT).show();
        }
        else if (StringHelper.validate(firstNumber.getText().toString(),secondNumber.getText().toString())) {
            a = Double.parseDouble(firstNumber.getText().toString());
            b = Double.parseDouble(secondNumber.getText().toString());
            switch (v.getId()) {
                case R.id.divisionBtn:
                    tvResult.setText(Double.toString(a / b));
                    operation.setImageResource(R.drawable.divisioncalc);
                    break;

                case R.id.minusBtn:
                    tvResult.setText(Double.toString(a - b));
                    operation.setImageResource(R.drawable.minusbuttoncalc);
                    break;


                case R.id.multiplicationBtn:
                    tvResult.setText(Double.toString(a * b));
                    operation.setImageDrawable(getResources().getDrawable(R.drawable.multiplicationcalc));
                    break;


                case R.id.plusBtn:
                    tvResult.setText(Double.toString(a + b));
                    operation.setImageResource(R.drawable.plusbuttoncalc);
                    break;
            }

        }
        else{
            Toast.makeText(this,"Введите значения",Toast.LENGTH_LONG).show();
        }
    }


}
