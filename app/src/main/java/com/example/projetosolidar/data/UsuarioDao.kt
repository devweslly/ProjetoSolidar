package com.example.projetosolidar.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDao {

    @Insert()
    fun addUsuario(usuario: Usuario)

    //Verificar o select se não puxar algum nome.
   // @Query("SELECT * FROM tabela_usuarios where email = email")
   // fun selectUsuario(): LiveData<List<Usuario>>
}