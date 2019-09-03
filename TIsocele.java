package com.example.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class TIsocele extends AppCompatActivity {
    private RadioButton rbPerimetro,rbArea,rbSemiperimetro;
    private Button btnCalcular;
    private EditText etLado1,etLado2,etLado3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tisocele);
        rbPerimetro=(RadioButton)findViewById(R.id.rbPerimetro);
        rbArea=(RadioButton)findViewById(R.id.rbArea);
        rbSemiperimetro=(RadioButton)findViewById(R.id.rbSemiperimetro);
        etLado1=(EditText)findViewById(R.id.etLado1);
        etLado2=(EditText)findViewById(R.id.etLado2);
        etLado3=(EditText)findViewById(R.id.etLado3);
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        etLado1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etLado2.setText(etLado1.getText());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etLado1.getText().toString().isEmpty()||etLado2.getText().toString().isEmpty()||etLado3.getText().toString().isEmpty())
                {
                    Toast error=Toast.makeText(v.getContext(),"CAMPO VACIO",Toast.LENGTH_LONG);
                    error.show();
                }else{
                    double lado1,lado2,lado3,resultado;
                    lado1=Double.parseDouble(etLado1.getText().toString());
                    lado2=Double.parseDouble(etLado2.getText().toString());
                    lado3=Double.parseDouble(etLado3.getText().toString());
                    if(rbPerimetro.isChecked()==true)
                    {
                        resultado=lado1+lado2+lado3;
                        Intent intento= new Intent(v.getContext(),Resultado.class);
                        intento.putExtra("Figura","Cuadrado");
                        intento.putExtra("Calculo",rbPerimetro.getText().toString());
                        intento.putExtra("Resultado",Double.toString(resultado));
                        intento.putExtra("Metrica","Metros");
                        startActivity(intento);
                    }
                    if(rbArea.isChecked()==true)
                    {
                        resultado=(lado1+lado2+lado3)/2;
                        Double alturalado1,alturalado2,alturalado3,area1,area2,area3;
                        alturalado1=2/lado1*Math.sqrt(resultado*(resultado-lado1)*(resultado-lado2)*(resultado-lado3));
                        alturalado2=2/lado2*Math.sqrt(resultado*(resultado-lado1)*(resultado-lado2)*(resultado-lado3));
                        alturalado3=2/lado3*Math.sqrt(resultado*(resultado-lado1)*(resultado-lado2)*(resultado-lado3));
                        area1=(lado1*alturalado1)/2;
                        area2=(lado2*alturalado2)/2;
                        area3=(lado3*alturalado3)/2;
                        Intent intento= new Intent(v.getContext(),Resultado.class);
                        intento.putExtra("Figura","Cuadrado");
                        intento.putExtra("Calculo",rbArea.getText().toString());
                        intento.putExtra("Resultado","Area lado 1 y 2= "+Double.toString(area1)+" Metros Cuadrados y Area lado 3= "+Double.toString(area3));
                        intento.putExtra("Metrica","Metros Cuadrados");
                        startActivity(intento);
                    }
                    if(rbSemiperimetro.isChecked()==true)
                    {
                        resultado=(lado1+lado2+lado3)/2;
                        Intent intento= new Intent(v.getContext(),Resultado.class);
                        intento.putExtra("Figura","Cuadrado");
                        intento.putExtra("Calculo",rbSemiperimetro.getText().toString());
                        intento.putExtra("Resultado",Double.toString(resultado));
                        intento.putExtra("Metrica","Metros");
                        startActivity(intento);
                    }
                }

            }
        });
    }
}
