package com.example.a15carlosmpf.miguelpereirafernandez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final int CODIGO=11;
    private Button btnEmpezar,btnFin;
    private Intent intent;
    private TextView tvCentro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmpezar=(Button)findViewById(R.id.btnEmpezar);
        btnFin=(Button)findViewById(R.id.btnFin);
        tvCentro=(TextView)findViewById(R.id.tvCentro);


        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent=new Intent(getApplicationContext(), Activity2.class);

                startActivityForResult(intent,CODIGO);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String respuesta;
        float resultado;

        if(requestCode==CODIGO)
            if(resultCode==RESULT_OK)
            {
                respuesta=data.getStringExtra("respuesta");
                resultado=data.getFloatExtra("resultado",0);
                tvCentro.setText(respuesta);
                tvCentro.append(String.valueOf(resultado));
            }
    }

    public void onClickFin(View view) {

        finish();
    }


}
