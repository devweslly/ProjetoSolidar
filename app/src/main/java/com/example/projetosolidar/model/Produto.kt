package com.example.projetosolidar.model

data class Produto(
    var nome: String,
    var imagem: String,
    var descricao: String,
    var quantidade: Int,
    var vencimento: String,
    var retirada: String,
    var categoria: String,
)
