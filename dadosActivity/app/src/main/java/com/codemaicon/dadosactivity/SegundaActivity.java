package com.codemaicon.dadosactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends Activity {
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        texto = (TextView) findViewById(R.id.textoId);
        // recupera as info
        Bundle extra = getIntent().getExtras();
        // vem string nome do main activity e grava n
        if (extra != null) {
            String textoPassado = extra.getString("nome");
            texto.setText(textoPassado);
        }
    }
}
