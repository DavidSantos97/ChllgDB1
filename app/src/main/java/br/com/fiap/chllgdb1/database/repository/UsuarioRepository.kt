package br.com.fiap.chllgdb1.database.repository

import android.content.Context
import br.com.fiap.chllgdb1.database.dao.UsuarioDb
import br.com.fiap.chllgdb1.model.Usuario

class UsuarioRepository (context: Context) {

    var db = UsuarioDb.getDatabase(context).usuarioDao()

    fun salvar(usuario: Usuario): Long{
        return db.salvar(usuario = usuario)
    }

    fun atualizar(usuario: Usuario): Int{
        return db.excluir(usuario = usuario)
    }

    fun excluir(usuario: Usuario): Int{
        return db.excluir(usuario = usuario                                                 )
    }
}