package com.example.projetosolidar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
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

        val adapter = CarrinhoAdapter(mainViewModel, requireContext())
        binding.recycleCarrinho.layoutManager = LinearLayoutManager(context)
        binding.recycleCarrinho.adapter = adapter
        binding.recycleCarrinho.setHasFixedSize(true)

        return binding.root
    }
}