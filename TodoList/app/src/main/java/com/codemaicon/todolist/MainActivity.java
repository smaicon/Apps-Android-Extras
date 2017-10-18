package com.codemaicon.todolist;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
    private EditText textoTarefa;
    private Button botaoAdicionar;
    private ListView listaDeTarefas;
    private SQLiteDatabase bancoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {


            //recuperar componente
            textoTarefa = (EditText) findViewById(R.id.textoId);
            botaoAdicionar = (Button) findViewById(R.id.btnAdicionarId);
            listaDeTarefas = (ListView) findViewById(R.id.listViewId);

            //Banco dados
            bancoDados = openOrCreateDatabase("apptarefas", MODE_PRIVATE, null);

            //tabela tarefas
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS tarefas(id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR ) ");
            //salvando as info
            botaoAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String textoDigitado = textoTarefa.getText().toString();
                    bancoDados.execSQL("INSERT INTO tarefas (tarefa) VALUES('" + textoDigitado + "') ");
                }
            });
            //recupera tarefa
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM tarefas", null);

            //  recupera id
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

            //listar tarefas
            cursor.moveToFirst();
            while(cursor != null){
                Log.i("Resultado - ", "Tarefa" + cursor.getString(indiceColunaTarefa));
                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
