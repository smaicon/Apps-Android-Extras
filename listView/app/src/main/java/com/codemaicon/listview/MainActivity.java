package com.codemaicon.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listaItens;
    private String[] itens = {
            "Angra dos Ress", "Casdas Novas",
            "Campos do Jordao", "Costa sauipe",
            "Ilheus", "Porto Seguro", "Rio de Janeiro",
            "Tiradentes", "Praga", "Santiago", "Cancun",
            "Arruba", "Eurique", "Cordoba"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaItens = (ListView) findViewById(R.id.listViewId);
        //Array adapter adpata para ser exibido
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.activity_list_item,
                android.R.id.text1,
                itens
        );
        // seta adapter como adaptador
        listaItens.setAdapter(adaptador);

        listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int codigoPosicao = position;
                String valorClicado = listaItens.getItemAtPosition(codigoPosicao).toString();
                Toast.makeText(getApplicationContext(), valorClicado, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
