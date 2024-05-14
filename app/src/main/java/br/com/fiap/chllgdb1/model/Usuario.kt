package br.com.fiap.chllgdb1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_usuario")
class Usuario {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var nome: String = ""
    var doc: String = ""
    var telefone: String = ""
    var email: String = ""
    var senha: String = ""

}