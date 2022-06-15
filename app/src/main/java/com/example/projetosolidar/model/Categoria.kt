package com.example.projetosolidar.model

// criar a data class que receberá a lista de categorias pela API
data class Categoria (
    val id: Int,
    val descricao : String?,
    val produtos: List<Produto>?
    ) {

    override fun toString(): String {
        return descricao!!
    }
}