package com.example.androidunivesp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Tela2 extends AppCompatActivity {

    // String para armazenamento da mensagem recebida da primeira tela
    private String mensagem;

    // variavel TextView no java associado ao componente TextView "exibeMensagem" no layout
    TextView exibeMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // associando a variavel mensagemInserida do java com o componente editText "mensagemRecebidaXML" do arquivo XML
        exibeMensagem = findViewById(R.id.mensagemRecebidaXML);

        // utilizando o metodo getExtras() para recuperar a mensagem enviada
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        String mensagemRecebida = (String) bd.get("mensagemEnviada");

        //exibe a mensagem na tela
        exibeMensagem.setText(mensagemRecebida);

    }
}