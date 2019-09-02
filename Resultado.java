package com.example.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends AppCompatActivity {
    private TextView tvFigura,tvResultado,tvCalculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        recibeResultado();
        Toast mensaje=Toast.makeText(this,"Calculo Realizado Con Exito",Toast.LENGTH_LONG);
        mensaje.show();
    }
    public void recibeResultado(){
        Bundle resultados=getIntent().getExtras();
        String figura=resultados.getString("Figura");
        String calculo=resultados.getString("Calculo");
        String resultado=resultados.getString("Resultado");
        String metrica=resultados.getString("Metrica");
        tvFigura=(TextView)findViewById(R.id.tvFigura);
        tvCalculo=(TextView)findViewById(R.id.tvCalculo);
        tvResultado=(TextView)findViewById(R.id.tvResultado);
        tvFigura.setText(figura);
        tvCalculo.setText(calculo);
        tvResultado.setText(resultado+" "+metrica);

    }
}
