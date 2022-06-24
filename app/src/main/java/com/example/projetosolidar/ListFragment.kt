package com.example.projetosolidar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetosolidar.adapter.ProdutoAdapter
import com.example.projetosolidar.adapter.ProdutoClickListener
import com.example.projetosolidar.databinding.FragmentListBinding
import com.example.projetosolidar.model.Produto

class ListFragment : Fragment(), ProdutoClickListener {

    private lateinit var binding: FragmentListBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    /* TODO: IMPLEMENTAR O CARDVIEW DE CATEGORIAS */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        mainViewModel.listarProduto()

        // Configuração do Recycler View
        val adapter = ProdutoAdapter(this, mainViewModel)
        binding.recyclerProduto.layoutManager = LinearLayoutManager(context)
        binding.recyclerProduto.adapter = adapter
        binding.recyclerProduto.setHasFixedSize(true)


        mainViewModel.produtoResponse.observe(viewLifecycleOwner){
                response -> if (response.body() != null){
                    adapter.setList(response.body()!!)
                }
        }

        return binding.root
    }

    override fun onProdutoClickListener(produto: Produto) {
        mainViewModel.produtoSelecionado = produto

        findNavController().navigate(R.id.action_listFragment_to_infoProdutoFragment)
    }
}