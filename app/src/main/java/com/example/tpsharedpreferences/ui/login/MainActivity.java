package com.example.tpsharedpreferences.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.tpsharedpreferences.R;
import com.example.tpsharedpreferences.models.Usuario;
import com.example.tpsharedpreferences.ui.registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getMLDUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                if (usuario != null) {
                    startActivity(new Intent(getApplicationContext(), RegistroActivity.class));
                }
            }
        });
    }

    public void inicializar()
    {
        email = findViewById(R.id.tvEmail);
        password = findViewById(R.id.tvContrasena);
    }

    public void login(View view) {
        String mail = email.getText().toString();
        String pass = password.getText().toString();
        mainViewModel.login(this, mail, pass);
    }

    public void registrarNuevo(View view)
    {
        //startActivity(new Intent(getApplicationContext(), RegistroActivity.class));
        mainViewModel.registrarNuevo(getApplicationContext());
    }
}
