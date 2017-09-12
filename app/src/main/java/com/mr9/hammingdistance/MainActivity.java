package com.mr9.hammingdistance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText input1,input2;
    private static TextView output;
    private static Button submit;

    String findHammingDistance(String s1,String s2){
        int distance=0,i=0;
        while(i<s1.length())
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                distance++;
            }
            i++;
        }
        return String.valueOf(distance);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1=(EditText)findViewById(R.id.editIn1);
        input2=(EditText)findViewById(R.id.editIn2);
        submit=(Button)findViewById(R.id.button);
        output=(TextView)findViewById(R.id.textOut);

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String in1,in2;
                        in1=input1.getText().toString();
                        in2=input2.getText().toString();
                        if(in1.length()==0)
                        {   output.setText("Hamming distance");
                            input1.setError("Give input!");
                        }
                        if(in2.length()==0)
                        {   output.setText("Hamming distance");
                            input2.setError("Give input!");
                        }
                        else if(in1.length()!=in2.length())
                        {
                            output.setText("Hamming distance");
                            Toast.makeText(MainActivity.this,"Enter inputs of equal length.",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            output.setText("Hamming distance is : "+findHammingDistance(in1,in2));
                        }
                    }
                }
        );
    }
}
