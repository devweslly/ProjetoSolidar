package com.example.projetosolidar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.example.projetosolidar.databinding.FragmentCadastroProdutoBinding

private lateinit var binding: FragmentCadastroProdutoBinding

class CadastroProdutoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /*
        // Criando a lógica do Spinner
        // da activity_cadastro_produto_doador

        // findViewById(id) - acessando o Spinner
        val categoriaSpinner = binding.spinner

        // Criando array para listar infos no Spinner
        var categoria =
            arrayOf("Categoria do Produto", "Perecíveis", "Não Perecíveis", "Bebida", "Hortifrúti")
        // Entender o que faz o adapter
        categoriaSpinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categoria)
        */

        // Inflate the layout for this fragment
        binding = FragmentCadastroProdutoBinding.inflate(layoutInflater, container, false)

        binding.buttonCadastrarProduto.setOnClickListener {
            findNavController().navigate(R.id.action_cadastroProdutoFragment_to_listFragment)
        }

        return binding.root
    }
}