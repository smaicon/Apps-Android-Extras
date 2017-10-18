package com.codemaicon.signos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private ListView listaSignos;
    private String[] signos = {
            "Aries", "Touro", "Gemeos", "Cancer", "leao", "virgem",
            "libra", "Escorpiao", "sagitario", "capricornio", "aquario", "peixes",
    };
    private String[] perfis = {
        "Arianos sao animados",
            "Taurinos sao positivos",
            "geminianos sao positivos, mutaveis",
"...","...","assa","dadasdsa","dsdasdsa","dasdasd","sdasd","dsdsdfsfs","dsdfdsfds"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaSignos = (ListView) findViewById(R.id.listViewID);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                signos
        );
        listaSignos.setAdapter(adaptador);
        listaSignos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int codigoPosicao = position;
                Toast.makeText(getApplicationContext(), perfis[codigoPosicao], Toast.LENGTH_LONG).show();
            }
        });
    }
}
