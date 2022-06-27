package com.example.projetosolidar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetosolidar.MainViewModel
import com.example.projetosolidar.R
import com.example.projetosolidar.databinding.CardLayoutBinding
import com.example.projetosolidar.model.Produto

class CarrinhoAdapter( val mainViewModel: MainViewModel, private val context: Context
): RecyclerView.Adapter<CarrinhoAdapter.carrinhoviewholder>() {

    private var carrinho = mainViewModel.pedido

    class carrinhoviewholder(val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): carrinhoviewholder {
        return CarrinhoAdapter.carrinhoviewholder(
            CardLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: carrinhoviewholder, position: Int) {
        val produto = carrinho[position]

        

       // holder.binding.nomeProdutoCardView.text = produto.toString()
       /* holder.binding.categoriaProdutoCardView.text =  produto.categoria.toString()
        holder.binding.quantidadeCardView.text =  produto.quantidade.toString()
*/
       /* Glide.with(context)
            .load(produto.imagem)
            .placeholder(R.drawable.ic_baseline_close_24)
          .into(holder.binding.imageCardView)  */
    }

    override fun getItemCount(): Int {
        return carrinho.size
    }
   /* fun setlist(list: List<Produto>){
        carrinho = list.sortedByDescending {
            it.id}
        notifyDataSetChanged()
    }*/
}