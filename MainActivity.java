package com.example.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private Button btnAcercade,btnIngresar;
    private RadioButton rbCuadrado,rbRectangulo,rbCirculo,rbTriangulo,rbRombo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAcercade=(Button)findViewById(R.id.btnAcercade);
        btnIngresar=(Button)findViewById(R.id.btnIngresar);
        rbCuadrado=(RadioButton)findViewById(R.id.rbCuadrado);
        rbRectangulo=(RadioButton)findViewById(R.id.rbRectangulo);
        rbCirculo=(RadioButton)findViewById(R.id.rbCirculo);
        rbTriangulo=(RadioButton)findViewById(R.id.rbTriangulo);
        rbRombo=(RadioButton)findViewById(R.id.rbRombo);
        btnAcercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(v.getContext(),AcercaDe.class);
                startActivityForResult(intento,0);

            }
        });
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbCuadrado.isChecked()==true){
                    Intent intento=new Intent(v.getContext(),Cuadrado.class);
                    startActivityForResult(intento,0);
                }
                if(rbRectangulo.isChecked()==true){
                    Intent intento=new Intent(v.getContext(),Rectangulo.class);
                    startActivityForResult(intento,0);
                }
                if(rbCirculo.isChecked()==true){
                    Intent intento=new Intent(v.getContext(),Circulo.class);
                    startActivityForResult(intento,0);
                }
                if(rbTriangulo.isChecked()==true){
                    Intent intento=new Intent(v.getContext(),Triangulos.class);
                    startActivityForResult(intento,0);
                }
                if(rbRombo.isChecked()==true){
                    Intent intento=new Intent(v.getContext(),Rombo.class);
                    startActivityForResult(intento,0);
                }
            }
        });
    }
}
