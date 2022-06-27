package com.example.projetosolidar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetosolidar.MainViewModel
import com.example.projetosolidar.R
import com.example.projetosolidar.databinding.CardLayoutBinding
import com.example.projetosolidar.databinding.CardLayoutCarrinhoBinding
import com.example.projetosolidar.model.Produto

class CarrinhoAdapter(
    val mainViewModel: MainViewModel,
    private val context: Context
): RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder>() {

    private var carrinho = mainViewModel.pedido

    class CarrinhoViewHolder(val binding: CardLayoutCarrinhoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrinhoViewHolder  {
        return CarrinhoViewHolder (
            CardLayoutCarrinhoBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CarrinhoViewHolder, position: Int) {
        val produto = carrinho[position]

        holder.binding.nomeProdutoCardView.text = produto.nomeMarca
        holder.binding.categoriaProdutoCardView.text =  "Categoria: " + produto.categoria.toString()
        holder.binding.quantidadeCardView.text =  "Quantidade: " + produto.quantidade.toString()
        Glide.with(context)
            .load(produto.imagem)
            .placeholder(R.drawable.ic_baseline_close_24)
          .into(holder.binding.imageCardView)

        holder.binding.buttonDeletarItem.setOnClickListener {
            mainViewModel.deletarCarrinho(produto)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return carrinho.size
    }
}