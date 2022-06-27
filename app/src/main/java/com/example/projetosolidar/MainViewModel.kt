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

@HiltViewModel
class MainViewModel @Inject constructor(
  private val repository : Repository, application: Application
): AndroidViewModel(application)  {

     var pedido = mutableListOf<List<Produto>>()



    var produtoSelecionado: Produto? = null
    // mutable list de categorias que recebemos da api (inacessivel)
    private val _categoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()

    // criamos uma lista imutável a partir da mutable list anterior (acessivel)
    val categoriaResponse : LiveData<Response<List<Categoria>>> = _categoriaResponse

    private val _produtoResponse = MutableLiveData<Response<List<Produto>>>()

    val produtoResponse : LiveData<Response<List<Produto>>> = _produtoResponse

    //val selectUsuario: LiveData<List<Usuario>>
    val usuarioRepository: UsuarioRepository

    init {
        val usuarioDao = UsuarioDatabase.getDatabase(application).usuarioDao()
        usuarioRepository = UsuarioRepository(usuarioDao)
        //selectUsuario = usuarioRepository.selectUsuario
    }


    fun listarCategoria(){
        // criar a corrotina
        viewModelScope.launch {
            try {
                // a resposta da requisição GET de listarCategoria
                val response = repository.listarCategoria()
                // atribuimos essa resposta ao mutableLiveData de _categoriaResponse
                _categoriaResponse.value = response
            } catch (e:Exception){
                // criar logcat caso dê erro
                Log.d("Erro", e.message.toString())
            }

        }
    }

    fun listarProduto(){
        viewModelScope.launch {
            try{
                val response = repository.listarProduto()
                _produtoResponse.value = response
            }catch (e: Exception){
                Log.d("ERRO", e.message.toString())
            }
        }
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
    fun addcarrinho (produto: Produto) {
       pedido.add(listOf(produto))
        Log.d("Pedido",pedido.toString())
    }


    }
