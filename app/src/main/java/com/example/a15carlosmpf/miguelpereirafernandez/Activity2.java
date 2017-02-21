package com.example.a15carlosmpf.miguelpereirafernandez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private Intent intent;
    private RadioButton rbArea,rbPerimetro,rbCuadrado,rbCirculo;
    private EditText valor;
    private Button btnSeguir,btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        rbArea=(RadioButton)findViewById(R.id.rbArea);
        rbPerimetro=(RadioButton)findViewById(R.id.rbPerimetro);
        rbCuadrado=(RadioButton)findViewById(R.id.rbCuadrado);
        rbCirculo=(RadioButton)findViewById(R.id.rbCirculo);
        valor=(EditText)findViewById(R.id.valor);
        btnSeguir=(Button)findViewById(R.id.btnSeguir);
        btnVolver=(Button)findViewById(R.id.btnVolver);

        intent=getIntent();


        btnSeguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(rbCuadrado.isChecked())
                    valor.setHint("Lado");
                else
                    valor.setHint("Radio");

                btnSeguir.setVisibility(View.GONE);
                btnVolver.setVisibility(View.VISIBLE);
                valor.setVisibility(View.VISIBLE);

            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float resultado;
                String respuesta;

                if(valor.getText().length()!=0){

                    int v=Integer.parseInt(valor.getText().toString());

                    if(rbArea.isChecked() && rbCuadrado.isChecked()) {
                        resultado = v * 2;
                        respuesta="Cuadrado - Area\n";
                    }
                    else if (rbArea.isChecked() && rbCirculo.isChecked()) {
                        resultado = (float) (v * 3.14);
                        respuesta="Circulo - Area\n";
                    }
                    else if (rbPerimetro.isChecked() && rbCuadrado.isChecked()) {
                        resultado = v * 4;
                        respuesta="Cuadrado - Perimetro\n";
                    }
                    else {
                        resultado = (float) (v * 2 * 3.14);
                        respuesta="Circulo - Perimetro\n";
                    }

                    intent.putExtra("respuesta", respuesta);
                    intent.putExtra("resultado", resultado);
                    setResult(RESULT_OK, intent);
                    finish();


                }else

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_LONG).show();
            }
        });





    }

}
