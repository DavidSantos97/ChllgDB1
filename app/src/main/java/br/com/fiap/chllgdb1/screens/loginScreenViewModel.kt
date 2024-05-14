package br.com.fiap.chllgdb1.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class loginScreenViewModel: ViewModel() {

    private val _emailState = MutableLiveData<String>()
    val emailState: LiveData<String> = _emailState

    private val _senhaState = MutableLiveData<String>()
    val senhaState: LiveData<String> = _senhaState

    fun onEmailCapitalChanged(novoEmail: String){
        _emailState.value = novoEmail
    }
    fun onSenhaCapitalChanged(novaSenha: String){
        _senhaState.value = novaSenha
    }



}