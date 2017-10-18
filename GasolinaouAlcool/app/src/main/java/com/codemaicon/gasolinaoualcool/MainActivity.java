package com.codemaicon.gasolinaoualcool;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = (EditText) findViewById(R.id.precoAlcoolId);
        precoGasolina = (EditText) findViewById(R.id.precoGasolinaId);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificar);
        textoResultado = (TextView) findViewById(R.id.textoResultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoPrecoAlccol = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();
                // converte valores strings em double
                Double valorAlcool = Double.parseDouble(textoPrecoAlccol);
                Double valorGasolina = Double.parseDouble(textoPrecoGasolina);

                //verificacao divide preco do alcool pelo preco da gasolina
                double resultado = valorAlcool / valorGasolina;

                if(resultado >= 0.7){
                    //melhor usar gasolina
                    textoResultado.setText("É MELHOR USAR GASOLINA");
                }else{
                    textoResultado.setText("É MELHOR USAR ÁLCOOL");
                }
            }
        });
    }
}
