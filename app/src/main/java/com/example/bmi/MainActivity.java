package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bmi.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        EditText edtWeight, edtHeightft, edtHeightIn;
        Button btn;
        TextView txtResult;
        LinearLayout llmain;

        edtWeight = findViewById(R.id.weight)  ; // R means resource me jake id dhundi weight naam ki
        edtHeightft=findViewById(R.id.heightFt);
        edtHeightIn=findViewById(R.id.heightIn);
        btn = findViewById(R.id.btnCal);
        txtResult = findViewById(R.id.result);
        llmain = findViewById(R.id.llmain);


        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int wt =  Integer.parseInt(edtWeight.getText().toString());
//We dont get directly the integer, We get editable form so first we convert that editable to string with the help of to string and then convert it to Interger (as our input will be integer) using parseInt
                int htf =  Integer.parseInt(edtHeightft.getText().toString());
                int htI =  Integer.parseInt(edtHeightIn.getText().toString());
//Formula for BMI is weight/(height^2), SI unit kg/m^2
//                To convert ft to inches
                int totalIn = htf*12 + htI;
                double totalCm = totalIn * 2.53;
                double totalm = totalCm/100;

                double BMI = wt/(totalm*totalm);

                // Determine the BMI category
                if (BMI > 25) {
                    txtResult.setText(getString(R.string.overweight));
                    llmain.setBackgroundColor(getResources().getColor(R.color.overweight));

                } else if (BMI < 18) {
                    txtResult.setText(getString(R.string.underweight));
                    llmain.setBackgroundColor(getResources().getColor(R.color.underweight));
                } else {
                    txtResult.setText(getString(R.string.fit));
                    llmain.setBackgroundColor(getResources().getColor(R.color.fit));
                }
            }
        });

   /*     When click on button the calculation will be done
      onClickListener is a interface class, Method is already declared, defination is not given
      btn is under view so the object will also be derived from the view
*/
    }
}