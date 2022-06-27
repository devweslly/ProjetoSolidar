package com.example.projetosolidar.api

import com.example.projetosolidar.model.Categoria
import com.example.projetosolidar.model.Produto
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    // implementar metodo GET de categoria
    @GET("categoria")
    suspend fun listarCategoria() : Response<List<Categoria>>

    @GET ("produtos")
    suspend fun listarProduto() : Response<List<Produto>>


}