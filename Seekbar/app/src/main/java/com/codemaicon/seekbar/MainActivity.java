package com.codemaicon.seekbar;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.id.progress;

public class MainActivity extends Activity {
private SeekBar seekBar;
    private TextView textoExibicao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBarId);
        textoExibicao = (TextView)  findViewById(R.id.textoExibicaoId);
        //configurando seekbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                //ira ser chamado sempre que movimenta o seekbar
                textoExibicao.setText("progresso:"+ progress + " / " + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            //quando pressiona o seekbar
                Toast.makeText(MainActivity.this, "seek pressionado",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //quando solta o seekbar
                Toast.makeText(MainActivity.this, "Salvar o valor do serkbar",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
