package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    String operator = "";
    int source1;
    int source2;
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    public void onClick(View view) {
        int id = view.getId();
        String Num = editText.getText().toString();
        
        if(check){
            editText.setText("");
            check=false;
        }
        
        switch (view.getId()) {
            case R.id.clear:
                initialize();
                break;
            case R.id.n0:
                editText.append("0");
                break;
            case R.id.n1:
                editText.append("1");
                break;
            case R.id.n2:
                editText.append("2");
                break;
            case R.id.n3:
                editText.append("3");
                break;
            case R.id.n4:
                editText.append("4");
                break;
            case R.id.n5:
                editText.append("5");
                break;
            case R.id.n6:
                editText.append("6");
                break;
            case R.id.n7:
                editText.append("7");
                break;
            case R.id.n8:
                editText.append("8");
                break;
            case R.id.n9:
                editText.append("9");
                break;
        }
    }

    public void operator(View view) {
        String Num = editText.getText().toString();
        if (!Num.equals("")){
            if(!check) {
                int tmp = Integer.parseInt(Num);
                if (source1 == 0) {
                    source1 = tmp;
                    editText.setText(String.valueOf(source1));
                } else {
                    source2 = tmp;
                    calculate();
                }
            }
        }
        switch(view.getId()) {
            case R.id.add:
                operator = "+";
                break;
            case R.id.minus:
                operator = "-";
                break;
            case R.id.multiply:
                operator = "*";
                break;
            case R.id.div:
                operator = "/";
                break;
            }
        check=true;
        }

    public void Enter(View view){
        String result = editText.getText().toString();

        int tmp = Integer.parseInt(result);
        source2 = tmp;
        calculate();
        operator = "=";
        check=true;
    }

    public void initialize(){
        operator = "";
        editText.setText("");
        source1 = 0;
        source2 = 0;
    }

    public void calculate(){
        switch(operator) {
            case "+":
                source1 = source1 + source2;
                break;
            case "-":
                source1 = source1 - source2;
                break;
            case "*":
                source1 = source1 * source2;
                break;
            case "/":
                source1 = source1 / source2;
                break;
        }
        source2 = 0;
        editText.setText(String.valueOf(source1));
    }
}