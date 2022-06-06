package com.example.projetosolidar

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class CadastroProdutoDoador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_produto_doador)

        // Criando a lógica do Spinner
        // da activity_cadastro_produto_doador

        // findViewById(id) - acessando o Spinner
        val categoriaSpinner = findViewById<Spinner>(R.id.spinner)

        // Criando array para listar infos no Spinner
        var categoria =
        arrayOf("Categoria do Produto", "Perecíveis", "Não Perecíveis", "Bebida", "Hortifrúti")
        // Entender o que faz o adapter
        categoriaSpinner.adapter =
        ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categoria)

    }
}