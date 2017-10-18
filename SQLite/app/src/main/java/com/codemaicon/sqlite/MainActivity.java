package com.codemaicon.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //criando tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR, idade INT(3))");
            //inserir dados na tabela
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Marcos', 30)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Ana', 20)");
            // query que desejamos que retorna os dados
            Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas", null);
            //recupera indice da coluna
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            // retorna ao inicio
            cursor.moveToFirst();
            while (cursor != null) {

                Log.i("RESULTADO - nome", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade", cursor.getString(indiceColunaIdade));
                cursor.moveToNext();

                cursor.getString(indiceColunaNome);
                cursor.getString(indiceColunaIdade);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
