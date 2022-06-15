package com.example.projetosolidar.api

import com.example.projetosolidar.model.Categoria
import retrofit2.Response

class Repository {

    suspend fun listarCategoria() : Response<List<Categoria>>{
        return RetrofitInstance.api.listarCategoria()
    }

}