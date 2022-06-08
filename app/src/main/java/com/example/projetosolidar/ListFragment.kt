package com.example.projetosolidar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetosolidar.adapter.ProdutoAdapter
import com.example.projetosolidar.databinding.FragmentListBinding
import com.example.projetosolidar.model.Produto

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val listProduto = listOf(
            Produto(
                nome = "Cenoura",
                imagem = "Imagine uma Cenoura",
                descricao = "Uma Cenoura",
                quantidade = 5,
                vencimento = "26/06/2022",
                retirada = "25/06/2022",
                categoria = "Horti-fruit",
            ),
            Produto(
                nome = "Cebola",
                imagem = "Imagine uma Cebola",
                descricao = "Uma Cenoura",
                quantidade = 10,
                vencimento = "26/06/2022",
                retirada = "25/06/2022",
                categoria = "Horti-fruit",
            ),
            Produto(
                nome = "Batata",
                imagem = "Imagine uma Batata",
                descricao = "Uma Cenoura",
                quantidade = 8,
                vencimento = "26/06/2022",
                retirada = "25/06/2022",
                categoria = "Horti-fruit",
            ),
        )

        // Configuração do Recycler View
        val adapter = ProdutoAdapter()
        binding.recyclerProduto.layoutManager = LinearLayoutManager(context)
        binding.recyclerProduto.adapter = adapter
        binding.recyclerProduto.setHasFixedSize(true)

        adapter.setList(listProduto)

        // Navegar para o próximo fragment
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_cadastroProdutoFragment)
        }

        return binding.root
    }
}