package br.com.fiap.chllgdb1.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import br.com.fiap.chllgdb1.model.Usuario

@Dao
interface UsuarioDao {

    @Insert
    fun salvar(usuario: Usuario) : Long

    @Update
    fun atualizar(usuario: Usuario) : Int

    @Delete
    fun excluir(usuario: Usuario) : Int




}