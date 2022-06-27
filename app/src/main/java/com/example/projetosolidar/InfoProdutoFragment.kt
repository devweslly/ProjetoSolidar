package com.example.projetosolidar

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.projetosolidar.databinding.FragmentInfoProdutoBinding
import com.example.projetosolidar.model.Produto


class InfoProdutoFragment : Fragment() {

    private lateinit var binding: FragmentInfoProdutoBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private var produtoSelecionado: Produto? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoProdutoBinding.inflate(layoutInflater, container, false)

        carregarDados()

        binding.ButtonVoltar.setOnClickListener {
            findNavController().navigate(R.id.action_infoProdutoFragment_to_listFragment)
        }

        binding.buttonAdicionarSacola.setOnClickListener {
            produtoSelecionado = mainViewModel.produtoSelecionado
            mainViewModel.addcarrinho(produtoSelecionado!!)
            Toast.makeText(context, "Produto adicionado ao carrinho!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_infoProdutoFragment_to_listFragment)
        }


            // Inflate the layout for this fragment
        return binding.root
    }

    private fun carregarDados() {
        produtoSelecionado = mainViewModel.produtoSelecionado
        binding.textDoProduto.setText(produtoSelecionado?.nomeMarca)
        binding.textConteudoDescricao.setText(produtoSelecionado?.descricao + "\n" + produtoSelecionado?.quantidade)

        Glide.with(requireContext())
            .load(produtoSelecionado?.imagem)
            .placeholder(R.drawable.ic_baseline_close_24)
            .into(binding.imageProduto)

    }
}