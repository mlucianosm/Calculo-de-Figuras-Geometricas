package com.example.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Cuadrado extends AppCompatActivity {
    private Button btnCalcular;
    private EditText etLado1,etLado2,etLado3,etLado4;
    private RadioButton rbPerimetro,rbArea,rbDiagonal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        etLado1=(EditText)findViewById(R.id.etLado1);
        etLado2=(EditText)findViewById(R.id.etLado2);
        etLado3=(EditText)findViewById(R.id.etLado3);
        etLado4=(EditText)findViewById(R.id.etLado4);
        rbPerimetro=(RadioButton)findViewById(R.id.rbPerimetro);
        rbArea=(RadioButton)findViewById(R.id.rbArea);
        rbDiagonal=(RadioButton)findViewById(R.id.rbDiagonal);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lado1,lado2,lado3,lado4,resultado;
                lado1=Integer.parseInt(etLado1.getText().toString());
                lado2=Integer.parseInt(etLado2.getText().toString());
                lado3=Integer.parseInt(etLado3.getText().toString());
                lado4=Integer.parseInt(etLado4.getText().toString());
                if(rbPerimetro.isChecked()==true){
                    resultado=lado1+lado2+lado3+lado4;
                }
                if(rbArea.isChecked()==true){
                    resultado=lado1*lado1;
                }
                if(rbDiagonal.isChecked()==true){

                }
            }
        });
    }
}
