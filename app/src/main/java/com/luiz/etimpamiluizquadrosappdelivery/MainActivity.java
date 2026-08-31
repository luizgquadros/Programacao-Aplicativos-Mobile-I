package com.luiz.etimpamiluizquadrosappdelivery;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnEntrar, btnCriar;
    EditText edtNome, edtEmail, edtSenha;
    CheckBox checkBox;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initComponets();


        preferences = getSharedPreferences("login", 0);
        boolean estaLogado = preferences.getBoolean("ManterLogado", false);

        if (estaLogado) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

        btnCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarDados()) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("EmailSalvo", edtEmail.getText().toString());
                    editor.putString("SenhaSalva", edtSenha.getText().toString());
                    editor.putString("NomeSalvo", edtNome.getText().toString());
                    editor.apply();

                    Toast.makeText(MainActivity.this, "Conta criada com sucesso!", Toast.LENGTH_SHORT).show();

                    edtNome.setText("");
                    edtEmail.setText("");
                    edtSenha.setText("");
                }
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarDados()) {
                    String emailDigitado = edtEmail.getText().toString();
                    String senhaDigitada = edtSenha.getText().toString();

                    String emailRegistrado = preferences.getString("EmailSalvo", "");
                    String senhaRegistrada = preferences.getString("SenhaSalva", "");

                    if (emailDigitado.equals(emailRegistrado) && senhaDigitada.equals(senhaRegistrada)) {
                        if (checkBox.isChecked()) {
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putBoolean("ManterLogado", true);
                            editor.apply();
                        }
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(MainActivity.this, "E-mail ou senha incorretos!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private boolean validarDados() {
        boolean retorno = true;

        if (edtNome.getText().toString().isEmpty()) {
            retorno = false;
            edtNome.setError("Este campo não pode estar vazio!");
        }

        if (edtEmail.getText().toString().isEmpty()) {
            retorno = false;
            edtEmail.setError("Este campo não pode estar vazio!");
        }

        if (edtSenha.getText().toString().isEmpty()) {
            retorno = false;
            edtSenha.setError("Este campo não pode estar vazio!");
        }
        return retorno;
    }

    private void initComponets() {
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCriar = findViewById(R.id.btnCriar);
        checkBox = findViewById(R.id.checkBox);
    }
}