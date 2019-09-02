package com.example.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Circulo extends AppCompatActivity {
    private Button btnCalcular;
    private RadioButton rbPerimetro,rbArea,rbDiametro;
    private EditText etRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        rbPerimetro=(RadioButton)findViewById(R.id.rbPerimetro);
        rbArea=(RadioButton)findViewById(R.id.rbArea);
        rbDiametro=(RadioButton)findViewById(R.id.rbDiametro);
        etRadio=(EditText)findViewById(R.id.etRadio);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etRadio.getText().toString().isEmpty())
                {
                    Toast error=Toast.makeText(v.getContext(),"CAMPO VACIO",Toast.LENGTH_LONG);
                    error.show();
                }else{
                    double resultado,radio;
                    radio=Double.parseDouble(etRadio.getText().toString());
                    if(rbPerimetro.isChecked()==true)
                    {
                        resultado=2*Math.PI*radio;
                        Intent intento= new Intent(v.getContext(),Resultado.class);
                        intento.putExtra("Figura","Circulo");
                        intento.putExtra("Calculo",rbPerimetro.getText().toString());
                        intento.putExtra("Resultado",Double.toString(resultado));
                        intento.putExtra("Metrica","Metros");
                        startActivity(intento);

                    }
                    if(rbArea.isChecked()==true)
                    {
                        resultado=Math.PI*(radio*radio);
                        Intent intento= new Intent(v.getContext(),Resultado.class);
                        intento.putExtra("Figura","Circulo");
                        intento.putExtra("Calculo",rbArea.getText().toString());
                        intento.putExtra("Resultado",Double.toString(resultado));
                        intento.putExtra("Metrica","Metros");
                        startActivity(intento);

                    }
                    if(rbDiametro.isChecked()==true)
                    {
                        resultado=2*radio;
                        Intent intento= new Intent(v.getContext(),Resultado.class);
                        intento.putExtra("Figura","Circulo");
                        intento.putExtra("Calculo",rbDiametro.getText().toString());
                        intento.putExtra("Resultado",Double.toString(resultado));
                        intento.putExtra("Metrica","Metros");
                        startActivity(intento);
                    }
                }

            }
        });
    }
}
