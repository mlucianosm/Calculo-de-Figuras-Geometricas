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

public class Rectangulo extends AppCompatActivity {
    private EditText etLado1,etLado2,etLado3,etLado4;
    private Button btnCalcular;
    private RadioButton rbPerimetro,rbArea,rbDiagonal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
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
                etLado3.setText(etLado1.getText());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etLado2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etLado4.setText(etLado2.getText());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etLado1.getText().toString().isEmpty()||etLado2.getText().toString().isEmpty())
                {
                    Toast error=Toast.makeText(v.getContext(),"Ingrese Valor en el Campo",Toast.LENGTH_LONG);
                    error.show();
                }else{
                    int lado1,lado2,lado3,lado4;
                    double resultado;
                    lado1=Integer.parseInt(etLado1.getText().toString());
                    lado2=Integer.parseInt(etLado2.getText().toString());
                    lado3=Integer.parseInt(etLado3.getText().toString());
                    lado4=Integer.parseInt(etLado4.getText().toString());
                    if ((lado1 < 1) || (lado3 < 1)) {
                        Toast error = Toast.makeText(v.getContext(), "Ingrese Valor sobre Cero en el Campo", Toast.LENGTH_LONG);
                        error.show();
                    }else {
                        if (rbPerimetro.isChecked() == true) {
                            resultado = lado1 + lado2 + lado3 + lado4;
                            Intent intento = new Intent(v.getContext(), Resultado.class);
                            intento.putExtra("Figura", "Rectangulo");
                            intento.putExtra("Calculo", rbPerimetro.getText().toString());
                            intento.putExtra("Resultado", Double.toString(resultado));
                            intento.putExtra("Metrica", "Metros");
                            startActivity(intento);
                        }
                        if (rbArea.isChecked()) {
                            resultado = lado1 * lado2;
                            Intent intento = new Intent(v.getContext(), Resultado.class);
                            intento.putExtra("Figura", "Rectangulo");
                            intento.putExtra("Calculo", rbArea.getText().toString());
                            intento.putExtra("Resultado", Double.toString(resultado));
                            intento.putExtra("Metrica", "Metros Cuadrados");
                            startActivity(intento);
                        }
                        if (rbDiagonal.isChecked()) {
                            int diag = (lado1 * lado1) + (lado2 * lado2);
                            resultado = Math.sqrt(diag);
                            String area4, area5;
                            area4 = Double.toString(resultado);
                            area5 = area4.substring(0, 5);
                            Intent intento = new Intent(v.getContext(), Resultado.class);
                            intento.putExtra("Figura", "Rectangulo");
                            intento.putExtra("Calculo", rbDiagonal.getText().toString());
                            intento.putExtra("Resultado", area5);
                            intento.putExtra("Metrica", "Metros");
                            startActivity(intento);

                        }
                        if ((rbPerimetro.isChecked() == false) && (rbArea.isChecked() == false) && (rbDiagonal.isChecked() == false)) {
                            Toast error = Toast.makeText(v.getContext(), "Seleccione Tipo de Calculo", Toast.LENGTH_LONG);
                            error.show();
                        }
                    }
                }

            }
        });
    }
}
