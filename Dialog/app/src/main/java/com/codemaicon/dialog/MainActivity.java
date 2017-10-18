package com.codemaicon.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button botao;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.botaoId);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // criando alert dialog
                dialog = new AlertDialog.Builder(MainActivity.this);
                //configurando a dialog
                dialog.setTitle("titulo dialog sem criatividade");
                //configurando a mensagem
                dialog.setMessage("mensagem do dialgoadasd");
                //se pode ser cancelado ou nao // nao sera possivel cancelar mesmo clicando fora da dialog
                dialog.setCancelable(false);
                //seta icone para mostrar
                dialog.setIcon(android.R.drawable.ic_delete);
                // configurar negative button 1 texto que vai aparecer 2 a acao
                dialog.setNegativeButton("nao",
                        new DialogInterface.OnClickListener() {
                            //acao
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "pressionado nao", Toast.LENGTH_SHORT).show();
                            }
                        });
                //botao positivo
                dialog.setPositiveButton("sim",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "pressionado sim", Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog.create();
                dialog.show();
            }
        });


    }
}
