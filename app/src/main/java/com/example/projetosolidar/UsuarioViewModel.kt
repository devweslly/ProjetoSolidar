
package com.example.projetosolidar

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.projetosolidar.api.Repository
import com.example.projetosolidar.data.Usuario
import com.example.projetosolidar.data.UsuarioDao
import com.example.projetosolidar.data.UsuarioDatabase
import com.example.projetosolidar.data.UsuarioRepository
import com.example.projetosolidar.model.Categoria
import com.example.projetosolidar.model.Produto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject
import kotlin.Exception

class UsuarioViewModel(
    application: Application
): AndroidViewModel(application)  {

    //val selectUsuario: LiveData<List<Usuario>>
    val usuarioRepository: UsuarioRepository

    init {
        val usuarioDao = UsuarioDatabase.getDatabase(application).usuarioDao()
        usuarioRepository = UsuarioRepository(usuarioDao)
        //selectUsuario = usuarioRepository.selectUsuario
    }

    fun addUsuario(usuario: Usuario){
        viewModelScope.launch (Dispatchers.IO){
            try {
                usuarioRepository.addUsuario(usuario)
            }catch (e: Exception){
                Log.d("ERRO", e.message.toString())
            }
        }
    }
}