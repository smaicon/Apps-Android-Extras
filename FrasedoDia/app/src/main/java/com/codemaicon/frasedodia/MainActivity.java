package com.codemaicon.frasedodia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textoNovaFrase;
    private Button botaoNovaFrase;

    private String[] frases = {
            "Quando vires um homem bom, tenta imitá-lo; quando vires um homem mau, examina-te a ti mesmo.\n" +
                    "Confúcio ",
            "Tente mover o mundo - o primeiro passo será mover a si mesmo.\n" +
                    "Platão ",
            "A religião do futuro será cósmica e transcenderá um Deus pessoal, evitando os dogmas e a teologia.\n" +
                    "Albert Einstein ",
            "Não ser descoberto numa mentira é o mesmo que dizer a verdade.\n" +
                    "Aristóteles Onassis ",
            "Fiquei magoado, não por me teres mentido, mas por não poder voltar a acreditar-te.\n" +
                    "Friedrich Nietzsche ",


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNovaFrase = (TextView) findViewById(R.id.textoNovaFraseId);
        botaoNovaFrase = (Button) findViewById(R.id.botaoNovaFraseId);

        //
        botaoNovaFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randomico = new Random();
                int numeroAleatorio = randomico.nextInt(frases.length);
                textoNovaFrase.setText(frases[numeroAleatorio]);
            }
        });
    }
}
