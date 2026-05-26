package com.luiz.etimpamiluizquadrosappdelivery;  // ← Mude se seu pacote for diferente

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnGravar, btnApresentar;
    EditText edtNome, edtIdade, edtTelefone;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnGravar = findViewById(R.id.brnGravar);
        btnApresentar = findViewById(R.id.btnApresentar);
        edtNome = findViewById(R.id.edtNome);
        edtIdade = findViewById(R.id.edtIdade);
        edtTelefone = findViewById(R.id.edtTelefone);
        tvInfo = findViewById(R.id.tvInfo);


        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravarDados();
            }
        });


        btnApresentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperarDados();
            }
        });
    }


    private void gravarDados() {
        SharedPreferences prefs = getSharedPreferences("meusDados", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("nome", edtNome.getText().toString());
        editor.putString("idade", edtIdade.getText().toString());
        editor.putString("telefone", edtTelefone.getText().toString());

        editor.apply();

        Toast.makeText(this, "Dados gravados com sucesso!", Toast.LENGTH_SHORT).show();


        edtNome.setText("");
        edtIdade.setText("");
        edtTelefone.setText("");
    }


    private void recuperarDados() {
        SharedPreferences prefs = getSharedPreferences("meusDados", Context.MODE_PRIVATE);

        String nome = prefs.getString("nome", "Não informado");
        String idade = prefs.getString("idade", "Não informado");
        String telefone = prefs.getString("telefone", "Não informado");

        tvInfo.setText("Nome: " + nome + "\nIdade: " + idade + "\nTelefone: " + telefone);
    }
}