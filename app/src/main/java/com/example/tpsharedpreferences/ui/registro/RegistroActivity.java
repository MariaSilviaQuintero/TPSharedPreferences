package com.example.tpsharedpreferences.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tpsharedpreferences.R;
import com.example.tpsharedpreferences.models.Usuario;

public class RegistroActivity extends AppCompatActivity {

    EditText dni;
    EditText nombre;
    EditText apellido;
    EditText email;
    EditText password;
    RegistroViewModel registroViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        inicializar();
        registroViewModel = ViewModelProviders.of(this).get(RegistroViewModel.class);
        registroViewModel.getMLDUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                dni.setText(usuario.getDni()+"");
                nombre.setText(usuario.getNombre());
                apellido.setText(usuario.getApellido());
                email.setText(usuario.getMail());
                password.setText(usuario.getPassword());
            }
        });


            registroViewModel.mostrarDatos(getApplicationContext());

    }

    public void inicializar()
    {
        dni = findViewById(R.id.tvDni);
        nombre = findViewById(R.id.tvNombre);
        apellido = findViewById(R.id.tvApellido);
        email = findViewById(R.id.tvEmailRegistro);
        password = findViewById(R.id.tvPasswordRegistro);
    }

    public void guardarDatos(View view) {
        Usuario usuario = new Usuario();
                usuario.setDni(Long.parseLong(dni.getText().toString()));
                usuario.setNombre(nombre.getText().toString());
                usuario.setApellido(apellido.getText().toString());
                usuario.setMail(email.getText().toString());
                usuario.setPassword(password.getText().toString());
        registroViewModel.guardarDatos(getApplicationContext(), usuario);
        Toast.makeText(getApplicationContext(), "Datos guardados correctamente", Toast.LENGTH_LONG).show();
        limpiar();
    }

    public void limpiar()
    {
        dni.setText("");
        nombre.setText("");
        apellido.setText("");
        email.setText("");
        password.setText("");
    }
}
