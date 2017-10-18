package com.codemaicon.minhasanotacoes;

import android.content.Context;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {
    private EditText texto;
    private ImageView botaoSalvar;
    private static final String Nome_arquivo = "arquivo_anotacao.txt";

    /*revisar nao esta salvando */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (EditText) findViewById(R.id.textoId);
        botaoSalvar = (ImageView) findViewById(R.id.botaoSalvarId);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoDigitado = texto.getText().toString();
                gravarNoArquivo(textoDigitado);
                Toast.makeText(MainActivity.this, "Salvo com sucesso !!", Toast.LENGTH_SHORT).show();
            }

        });
        //recuperer o que foi gravado
        if (lerArquivo() != null) {
            texto.setText(lerArquivo());
        }
    }

    private void gravarNoArquivo(String texto) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(Nome_arquivo, Context.MODE_PRIVATE));
            outputStreamWriter.write(texto);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.v("MainActivity", e.toString());
        }

    }

    private String lerArquivo() {
        String resultado = "";
        //abrindo  o arquivo
        try {
            InputStream arquivo = openFileInput(Nome_arquivo);
            if (arquivo != null) {
                //ler arquivo
                InputStreamReader inputStreamReader = new InputStreamReader(arquivo);
                //gerar buffer do arquivo lido
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                //recupera texto do arquivo
                String linhaArquivo = "";
                while (bufferedReader.readLine() != null) {
                    resultado += linhaArquivo;

                }
                arquivo.close();
            }
        } catch (IOException e) {
            Log.v("MainActivity", e.toString());
        }

        return resultado;
    }
}
