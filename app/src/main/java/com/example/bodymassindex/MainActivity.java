package com.example.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }

    public void myButtonListenerMethod() {
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                final EditText heighText = (EditText)
                        findViewById(R.id.heightInput);

                String heighStr = heighText.getText().toString();
                double height = Double.parseDouble(heighStr);

                final EditText weightText = (EditText)
                        findViewById(R.id.weightInput);

                String weightStr = weightText.getText().toString();
                double weight = Double.parseDouble(weightStr);

                double BMI = (weight)/(height*height);

                final EditText BMIResult = (EditText)
                        findViewById(R.id.BMIResult);
                BMIResult.setText(Double.toString(BMI));

                String BMI_Cat;
                if (BMI < 15)
                        BMI_Cat = "Ağır düzeyde zayıf";
                else if(BMI < 16)
                    BMI_Cat = "Orta düzeyde zayıf";
                else if(BMI < 18.5)
                    BMI_Cat = "Zayıf";
                else if(BMI < 25)
                    BMI_Cat = "Normal";
                else if(BMI < 30)
                    BMI_Cat = "Kilolu";
                else if(BMI < 35)
                    BMI_Cat = "1. derece obez!";
                else if(BMI < 40)
                    BMI_Cat = "2. derece obez!!";
                else
                    BMI_Cat = "3. derece obez!!!";

                final TextView BMICategory = (TextView)
                        findViewById(R.id.BMICategory);
                BMICategory.setText(BMI_Cat);
            }
        });
    }
}
