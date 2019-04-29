package com.example.edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText atd1,atd2,atd3;
    private TextView txv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setBackgroundDrawableResource(R.drawable.images1);
    }

    int size = 35;
    public void response(View view){

        atd1 = findViewById(R.id.editText);
        atd2 = findViewById(R.id.editText2);
        atd3 = findViewById(R.id.editText3);
        txv_result = findViewById(R.id.TextView);
        float height = Float.parseFloat(atd2.getText().toString());
        float weight = Float.parseFloat(atd3.getText().toString());
        float BMI1 = calculateBMI(height,weight);
        String BMI2 = String.valueOf(BMI1);

        txv_result.setTextSize(size);
        txv_result.setText(atd1.getText().toString() + " Hello!" + "\n" + "your BMI is " + BMI2);

        Toast.makeText(this, standardBMI(BMI1), Toast.LENGTH_SHORT).show();
    }


    private float calculateBMI(float ht ,float wt){
        float BMI = (float)(wt/Math.pow((ht/100),2));
        return BMI;
    }

    private String standardBMI(double st){
        String alert = "";

        if(st>25){
            alert = String.valueOf("You are too heavy!!!");
            getWindow().setBackgroundDrawableResource(R.drawable.images2);
        }
        else if (st<18.5){
            alert = String.valueOf("You are too slim!!!");
            getWindow().setBackgroundDrawableResource(R.drawable.images3);
        }
        else{
            alert = String.valueOf("Your body is good!");
            getWindow().setBackgroundDrawableResource(R.drawable.images1);
        }
        return alert;

    }
}