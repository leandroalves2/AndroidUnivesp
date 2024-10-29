package com.example.androidunivesp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    // variavel EditText no java para captura do conteudo inserido pelo usuario (associado ao componente EditText "editText" no layout)
    private EditText mensagemInserida;

    //String contendo a mensagem a ser enviada
    private String mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Associando a variavel mensagemInserida do java com o componente editText do arquivo XML
        mensagemInserida = findViewById(R.id.editTextXML);
    }

    //metodo para enviar a mensagem para a proxima tela
    public void diaparaNovaTela(View v) {

        // atribuiçao do valor digitado pelo usuario no campo do EditText para a variavel mensagem
        mensagem = mensagemInserida.getText().toString();

        // criaçao da Intent para chamada da segunda tela com envio da mensagem
        Intent myIntent = new Intent(this, MostraTexto.class);

        // uso do metodo putExtra para envio da mensagem
        myIntent.putExtra("mensagemEnviada", mensagem);

        // envio da solicitacao
        startActivity(myIntent);
    }

    public void meuClick(View e) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
        startActivity(myIntent);

    }
}