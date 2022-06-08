package com.example.projetosolidar.model

data class Produto(
    var nome: String,
    var imagem: String,
    var descricao: String,
    var quantidade: Int,
    var valor: Int,
    var categoria: String,
)
