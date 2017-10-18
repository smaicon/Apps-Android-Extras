package com.codemaicon.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText textoNome;
    private Button botaoSalvar;
    private TextView textoExibicao;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoNome = (EditText) findViewById(R.id.textoNomeId);
        textoExibicao = (TextView) findViewById(R.id.textoExibicaoId);
        botaoSalvar = (Button) findViewById(R.id.botaoSalvarId);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //0 que o arquivo é privado so pode ser lido pelo app nosso
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (textoNome.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "por favor preencher o nome", Toast.LENGTH_SHORT).show();

                } else {
                    editor.putString("nome", textoNome.getText().toString());
                    editor.commit();
                    textoExibicao.setText("olá"   + textoNome.getText().toString());
                }
            }
        });
        //recuperando dados salvos
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (sharedPreferences.contains("nome")) {
            String nomeUsuario = sharedPreferences.getString("nome", "usuario nao definido");
            textoExibicao.setText("ola"   + nomeUsuario);
        } else {
            textoExibicao.setText("ola usuario nao definido");
        }
    }
}