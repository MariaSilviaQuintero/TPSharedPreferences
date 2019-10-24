package com.example.tpsharedpreferences.ui.registro;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpsharedpreferences.models.Usuario;
import com.example.tpsharedpreferences.request.ApiClient;

public class RegistroViewModel extends ViewModel {

    private MutableLiveData<Usuario> mldUsuario;

    public LiveData<Usuario> getMLDUsuario(){
        if(mldUsuario==null){
            mldUsuario= new MutableLiveData<>();
        }
        return mldUsuario;
    }

    public void mostrarDatos(Context context){
        Usuario usuario= ApiClient.leer(context);
        mldUsuario.setValue(usuario);
    }

    public void guardarDatos(Context context,Usuario usuario ){
        ApiClient.guardar(context,usuario);
    }
}
