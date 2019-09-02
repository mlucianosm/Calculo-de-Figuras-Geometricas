package com.example.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Cuadrado extends AppCompatActivity {
    private Button btnCalcular;
    private EditText etLado1,etLado2,etLado3,etLado4;
    private RadioButton rbPerimetro,rbArea,rbDiagonal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);
        getSupportActionBar().setTitle("Calculo Cuadrado");
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        etLado1=(EditText)findViewById(R.id.etLado1);
        etLado2=(EditText)findViewById(R.id.etLado2);
        etLado3=(EditText)findViewById(R.id.etLado3);
        etLado4=(EditText)findViewById(R.id.etLado4);
        rbPerimetro=(RadioButton)findViewById(R.id.rbPerimetro);
        rbArea=(RadioButton)findViewById(R.id.rbArea);
        rbDiagonal=(RadioButton)findViewById(R.id.rbDiagonal);
        etLado1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etLado2.setText(etLado1.getText());
                etLado3.setText(etLado1.getText());
                etLado4.setText(etLado1.getText());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etLado1.getText().toString().isEmpty())
                {
                    Toast error=Toast.makeText(v.getContext(),"CAMPO VACIO",Toast.LENGTH_LONG);
                    error.show();
                }else{
                    Double lado1,lado2,lado3,lado4;
                    Double resultado;
                    lado1=Double.parseDouble(etLado1.getText().toString());
                    lado2=Double.parseDouble(etLado2.getText().toString());
                    lado3=Double.parseDouble(etLado3.getText().toString());
                    lado4=Double.parseDouble(etLado4.getText().toString());
                    if(rbPerimetro.isChecked()==true){
                        resultado=lado1+lado2+lado3+lado4;
                        Intent intento= new Intent(v.getContext(),Resultado.class);
                        intento.putExtra("Figura","Cuadrado");
                        intento.putExtra("Calculo",rbPerimetro.getText().toString());
                        intento.putExtra("Resultado",Double.toString(resultado));
                        intento.putExtra("Metrica","Metros");
                        startActivity(intento);


                    }
                    if(rbArea.isChecked()==true){
                        resultado=lado1*lado1;
                        Intent intento= new Intent(v.getContext(),Resultado.class);
                        intento.putExtra("Figura","Cuadrado");
                        intento.putExtra("Calculo",rbArea.getText().toString());
                        intento.putExtra("Resultado",Double.toString(resultado));
                        intento.putExtra("Metrica","Metros Cuadrados");
                        startActivity(intento);

                    }
                    if(rbDiagonal.isChecked()==true){
                        resultado=Math.sqrt(2)*lado1;
                        Intent intento= new Intent(v.getContext(),Resultado.class);
                        intento.putExtra("Figura","Cuadrado");
                        intento.putExtra("Calculo",rbDiagonal.getText().toString());
                        intento.putExtra("Resultado",Double.toString(resultado));
                        intento.putExtra("Metrica","Metros");
                        startActivity(intento);

                    }
                }

            }
        });
    }
}
