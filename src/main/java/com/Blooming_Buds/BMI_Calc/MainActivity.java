package com.Blooming_Buds.BMI_Calc;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button cal,clear;
    TextView res;
    Float h,w,bmi;
    EditText val1,val2;
    Button next;
    String msg;
    String bm;
    String su;
    Intent createint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cal=(Button)findViewById(R.id.cal);
        clear=(Button)findViewById(R.id.clear);
        res=(TextView)findViewById(R.id.result);
        val1=(EditText)findViewById(R.id.val1);
        val2=(EditText)findViewById(R.id.val2);
        next=(Button)findViewById(R.id.next);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String we=val1.getText().toString();
                String he=val2.getText().toString();
                if((val1.getText().toString().isEmpty()) || (val2.getText().toString().isEmpty()))
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Valid Details",Toast.LENGTH_SHORT).show();

                }
                else {
                    h = Float.parseFloat(he) / 100;
                    w = Float.parseFloat(we);
                    bmi = w / (h * h);
                    bm = String.format("%.2f", bmi);

                    res.setText(bm);

                    if (bmi < 18.5)
                        msg = "Underweight";
                    else if (bmi >= 18.5 && bmi <= 24.9)
                        msg = "Healthy weight";
                    else if (bmi > 24.9 && bmi <= 29.9)
                        msg = "Overweight";
                    else if (bmi > 29.9 && bmi <= 40)
                        msg = "Obese";
                    else
                        msg = "Over Obese";

                    float sugg = (23) * (h * h);
                    su = String.format("%.2f", sugg);


                    AlertDialog.Builder detail = new AlertDialog.Builder(MainActivity.this);
                    detail.setMessage("Good Greetings,\n    Your BMI is " + bm + "\n    You are in " + msg + " Range\n   To achieve Healthy weight range ,you suggested weight is " + su + "\n            Stay Healthy")
                            .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = detail.create();
                    alert.setTitle("Detailed Report");
                    alert.show();

                }




            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val2.setText("");
                val1.setText("");
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createint=new Intent(MainActivity.this,About.class);
                startActivity(createint);
            }
        });
    }
}
