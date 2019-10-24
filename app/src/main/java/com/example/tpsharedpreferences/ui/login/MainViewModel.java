package com.example.tpsharedpreferences.ui.login;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpsharedpreferences.models.Usuario;
import com.example.tpsharedpreferences.request.ApiClient;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Usuario> mldUsuario;

    public LiveData<Usuario> getMLDUsuario() {
        if (mldUsuario == null) {
            mldUsuario = new MutableLiveData<>();
        }
        return mldUsuario;
    }

    public void login(Context context, String email, String pass){
        Usuario usuario = ApiClient.login(context,email,pass);
        mldUsuario.setValue(usuario);
    }

    public void registrarNuevo(Context context)
    {
        //ApiClient.leer(context);
        Usuario usuario= ApiClient.leer(context);
        mldUsuario.setValue(usuario);
    }
}
