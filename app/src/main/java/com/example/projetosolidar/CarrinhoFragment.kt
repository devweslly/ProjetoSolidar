package com.example.projetosolidar

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetosolidar.adapter.CarrinhoAdapter
import com.example.projetosolidar.databinding.FragmentCarrinhoBinding
import com.example.projetosolidar.databinding.FragmentEditarPerfilBinding

class CarrinhoFragment : Fragment() {

    private lateinit var binding: FragmentCarrinhoBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCarrinhoBinding.inflate(layoutInflater, container, false)

        finalizarPedido()

        val adapter = CarrinhoAdapter(mainViewModel, requireContext())
        binding.recycleCarrinho.layoutManager = LinearLayoutManager(context)
        binding.recycleCarrinho.adapter = adapter
        binding.recycleCarrinho.setHasFixedSize(true)

        return binding.root
    }

    fun finalizarPedido(){
        if(mainViewModel.pedido.isEmpty()){
            mainViewModel.pedido.clear()
            binding.buttonFinalizarPedido.visibility = View.GONE
        } else {
            binding.buttonFinalizarPedido.setOnClickListener {
                AlertDialog.Builder(context)
                    .setTitle("Pedido Confirmado!")
                    .setIcon(R.drawable.confirmacao_doacao)
                    .setMessage("Seu pedido foi confirmado, yay!\n" +
                            "Código do pedido: 59864821\n")
                    .setPositiveButton("Okay"){
                            _,_ -> findNavController().navigate(R.id.action_carrinhoFragment_to_listFragment)
                    }.show()
                mainViewModel.pedido.clear()
            }
        }
    }

}