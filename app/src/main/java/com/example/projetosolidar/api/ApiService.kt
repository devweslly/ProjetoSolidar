package com.example.projetosolidar.api

import com.example.projetosolidar.model.Categoria
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    // implementar metodo GET de categoria
    @GET("categoria")
    suspend fun listarCategoria() : Response<List<Categoria>>

}