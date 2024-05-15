package br.com.fiap.chllgdb1.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class cadastroScreenViewModel:ViewModel(){

    private val _nomeState = MutableLiveData<String>()
    val nomeState: LiveData<String> = _nomeState

    private val _telefoneState = MutableLiveData<String>()
    val telefoneState: LiveData<String> = _telefoneState

    private val _docState = MutableLiveData<String>()
    val docState: LiveData<String> = _docState

    private val _emailState = MutableLiveData<String>()
    val emailState: LiveData<String> = _emailState

    private val _senhaState = MutableLiveData<String>()
    val senhaState: LiveData<String> = _senhaState

    private val _expState = MutableLiveData<String>()
    val expState: LiveData<String> = _expState

    private val _habilState = MutableLiveData<String>()
    val habilState: LiveData<String> = _habilState

    private val _interesseState = MutableLiveData<String>()
    val interesseState: LiveData<String> = _interesseState

    private val _formacaoState = MutableLiveData<String>()
    val formacaoState: LiveData<String> = _formacaoState

    fun onExpCapitalChanged(novoExp: String){
        _expState.value = novoExp
    }

    fun onHabilCapitalChanged(novoHabil: String){
        _habilState.value = novoHabil
    }

    fun  onInteresseCapitalChanged(novointeresse: String){
        _interesseState.value = novointeresse
    }

    fun onFormacaoCapitalChanged(novoFormacao: String){
        _formacaoState.value = novoFormacao
    }

    fun onNomeCapitalChanged(novoNome: String){
        _nomeState.value = novoNome
    }
    fun onTelefoneCapitalChanged(novoTelefone: String){
        _telefoneState.value = novoTelefone
    }
    fun onDocCapitalChanged(novoDoc: String){
        _docState.value = novoDoc
    }
    fun onEmailCapitalChanged(novoEmail: String){
        _emailState.value = novoEmail
    }
    fun onSenhaCapitalChanged(novaSenha: String){
        _senhaState.value = novaSenha
    }
}