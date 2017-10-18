package com.codemaicon.mediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button botaoTocar;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoTocar = (Button) findViewById(R.id.tocarId);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.musica);

        botaoTocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    pausarMusica();

                } else {
                    tocarMusica();
                }
            }
        });
    }

    private void tocarMusica() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            botaoTocar.setText("pausar");
        }
    }

    private void pausarMusica() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            botaoTocar.setText("tocar");
        }
    }

    @Override
    protected void onDestroy() {
        //apos executar destroir processo para nao usar tanto a memoria
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop(); // para
            mediaPlayer.release(); // recomendacao para liberar recursos utilizados
            mediaPlayer = null;
            // apos esta verificacao os recursos de memoria sao liberados
        }
        super.onDestroy();
    }

}
