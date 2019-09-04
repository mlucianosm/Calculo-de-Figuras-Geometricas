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

public class Rombo extends AppCompatActivity {
    private Button btnCalcular;
    private EditText etLado1,etLado2;
    private RadioButton rbPerimetro,rbArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rombo);
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        etLado1=(EditText)findViewById(R.id.etLado1);
        etLado2=(EditText)findViewById(R.id.etLado2);

        rbPerimetro=(RadioButton)findViewById(R.id.rbPerimetro);
        rbArea=(RadioButton)findViewById(R.id.rbArea);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etLado1.getText().toString().isEmpty()||etLado2.getText().toString().isEmpty())
                {
                    Toast error=Toast.makeText(v.getContext(),"Ingrese Valor en el Campo",Toast.LENGTH_LONG);
                    error.show();
                }else {
                    Double lado1, lado2;
                    Double resultado;

                    lado1 = Double.parseDouble(etLado1.getText().toString());
                    lado2 = Double.parseDouble(etLado2.getText().toString());

                    if ((lado1 < 1) || (lado2 < 1)) {
                        Toast error = Toast.makeText(v.getContext(), "Ingrese Valor sobre Cero en el Campo", Toast.LENGTH_LONG);
                        error.show();
                    }else {

                        if (rbPerimetro.isChecked() == true) {
                            resultado = 2 * Math.sqrt((lado1 * lado1) + (lado2 * lado2));
                            String area4, area5;
                            area4 = Double.toString(resultado);
                            area5 = area4.substring(0, 5);
                            Intent intento = new Intent(v.getContext(), Resultado.class);
                            intento.putExtra("Figura", "Rombo");
                            intento.putExtra("Calculo", rbPerimetro.getText().toString());
                            intento.putExtra("Resultado", area5);
                            intento.putExtra("Metrica", "Metros");
                            startActivity(intento);

                        }
                        if (rbArea.isChecked() == true) {
                            resultado = (lado1 * lado2) / 2;

                            Intent intento = new Intent(v.getContext(), Resultado.class);
                            intento.putExtra("Figura", "Rombo");
                            intento.putExtra("Calculo", rbArea.getText().toString());
                            intento.putExtra("Resultado", Double.toString(resultado));
                            intento.putExtra("Metrica", "Metros Cuadrados");
                            startActivity(intento);
                        }
                        if ((rbPerimetro.isChecked() == false) && (rbArea.isChecked() == false)) {
                            Toast error2 = Toast.makeText(v.getContext(), "Seleccione Tipo de Calculo", Toast.LENGTH_LONG);
                            error2.show();
                        }
                    }

                }

            }
        });
    }
}
