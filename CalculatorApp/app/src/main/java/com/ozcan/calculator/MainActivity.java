package com.ozcan.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText number1Text, number2Text;
    Button sumButton, substractButton, muliplyButton, divideButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        //XML VERİLERİNİ TANIMLAYALIM
        number1Text = findViewById(R.id.number1Text);
        number2Text = findViewById(R.id.number2Text);
        sumButton = findViewById(R.id.sumButton);
        substractButton = findViewById(R.id.subtractButton);
        muliplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);
        resultTextView = findViewById(R.id.resultTextView);

        //Toplama butonuna tıklama olayı
        sumButton.setOnClickListener(v ->Sum());
        substractButton.setOnClickListener(v -> Substract());
        muliplyButton.setOnClickListener(v -> Multiply());
        divideButton.setOnClickListener(v -> Divide());
    }

    public void Sum(){
        int number1 = Integer.parseInt(number1Text.getText().toString());
        int number2 = Integer.parseInt(number2Text.getText().toString());

        int result = number1 + number2;
        resultTextView.setText("Result: " +result);
    }

    public void Substract(){
        int number1 = Integer.parseInt(number1Text.getText().toString());
        int number2 = Integer.parseInt(number2Text.getText().toString());

        int result = number1 - number2;
        resultTextView.setText("Result: " +result);
    }

    public void Multiply(){
        int number1 = Integer.parseInt(number1Text.getText().toString());
        int number2 = Integer.parseInt(number2Text.getText().toString());

        int result = number1 * number2;
        resultTextView.setText("Result: " +result);
    }

    public void Divide(){
        int number1 = Integer.parseInt(number1Text.getText().toString());
        int number2 = Integer.parseInt(number2Text.getText().toString());

        int result = number1 / number2;
        resultTextView.setText("Result: " +result);
    }
}