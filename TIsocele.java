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
                    Toast error=Toast.makeText(v.getContext(),"Ingrese Valor en el Campo",Toast.LENGTH_LONG);
                    error.show();
                }else{
                    double lado1,lado2,lado3,resultado;
                    lado1=Double.parseDouble(etLado1.getText().toString());
                    lado2=Double.parseDouble(etLado2.getText().toString());
                    lado3=Double.parseDouble(etLado3.getText().toString());
                    if ((lado1 < 1) || (lado2 < 1) || (lado3 < 1)) {
                        Toast error = Toast.makeText(v.getContext(), "Ingrese Valor sobre Cero en el Campo", Toast.LENGTH_LONG);
                        error.show();
                    }else {
                        if (lado1 == lado3) {
                            Toast error = Toast.makeText(v.getContext(), "EL TRIANGULO TIENE TODOS SUS LADOS IGUALES", Toast.LENGTH_LONG);
                            error.show();
                        } else {
                            if (rbPerimetro.isChecked() == true) {
                                resultado = lado1 + lado2 + lado3;
                                Intent intento = new Intent(v.getContext(), Resultado.class);
                                intento.putExtra("Figura", "Triangulo Isoceles");
                                intento.putExtra("Calculo", rbPerimetro.getText().toString());
                                intento.putExtra("Resultado", Double.toString(resultado));
                                intento.putExtra("Metrica", "Metros");
                                startActivity(intento);
                            }
                            if (rbArea.isChecked() == true) {

                                resultado = (lado1 + lado2 + lado3) / 2;
                                double area1, area2, area3, alturalado1, alturalado2, alturalado3;
                                alturalado1 = lado1 * lado1;
                                alturalado2 = (lado3 * lado3) / 4;
                                alturalado3 = Math.sqrt(alturalado1 - alturalado2);
                                area3 = (lado3 * alturalado3) / 2;

                                String area4, area5;
                                area4 = Double.toString(area3);
                                area5 = area4.substring(0, 5);


                                Intent intento = new Intent(v.getContext(), Resultado.class);
                                intento.putExtra("Figura", "Triangulo Isoceles");
                                intento.putExtra("Calculo", rbArea.getText().toString());
                                intento.putExtra("Resultado", " " + area5);
                                intento.putExtra("Metrica", "Metros Cuadrados");
                                startActivity(intento);
                            }
                            if (rbSemiperimetro.isChecked() == true) {
                                resultado = (lado1 + lado2 + lado3) / 2;
                                Intent intento = new Intent(v.getContext(), Resultado.class);
                                intento.putExtra("Figura", "Triangulo Isoceles");
                                intento.putExtra("Calculo", rbSemiperimetro.getText().toString());
                                intento.putExtra("Resultado", Double.toString(resultado));
                                intento.putExtra("Metrica", "Metros");
                                startActivity(intento);
                            }
                        }

                        if ((rbPerimetro.isChecked() == false) && (rbArea.isChecked() == false) && (rbSemiperimetro.isChecked() == false)) {
                            Toast error = Toast.makeText(v.getContext(), "Seleccione Tipo de Calculo", Toast.LENGTH_LONG);
                            error.show();
                        }
                    }
                }

            }
        });
    }
}
