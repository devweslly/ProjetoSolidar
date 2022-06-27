package com.example.projetosolidar.api

import com.example.projetosolidar.model.Categoria
import com.example.projetosolidar.model.Produto
import retrofit2.Response

class Repository {

    suspend fun listarCategoria(): Response<List<Categoria>> {
        return RetrofitInstance.api.listarCategoria()
    }

    suspend fun listarProduto(): Response<List<Produto>> {
        return RetrofitInstance.api.listarProduto()
    }
}