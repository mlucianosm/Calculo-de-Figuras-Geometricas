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

public class Triangulos extends AppCompatActivity {
    private Button btnElegir;
    private RadioButton rbEquilatero,rbIsocele,rbEscaleno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulos);
        btnElegir=(Button)findViewById(R.id.btnElegir);
        rbEquilatero=(RadioButton)findViewById(R.id.rbEquilatero);
        rbIsocele=(RadioButton)findViewById(R.id.rbIsocele);
        rbEscaleno=(RadioButton)findViewById(R.id.rbEscaleno);
        btnElegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbEquilatero.isChecked()==true){
                    Intent intento=new Intent(v.getContext(),TEquilatero.class);
                    startActivityForResult(intento,0);
                }
                if(rbIsocele.isChecked()==true){
                    Intent intento=new Intent(v.getContext(),TIsocele.class);
                    startActivityForResult(intento,0);
                }
                if(rbEscaleno.isChecked()==true){
                    Intent intento=new Intent(v.getContext(),TEscaleno.class);
                    startActivityForResult(intento,0);
                }
            }
        });



    }
}
