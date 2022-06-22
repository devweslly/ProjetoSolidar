package com.example.projetosolidar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetosolidar.databinding.FragmentCarrinhoBinding
import com.example.projetosolidar.databinding.FragmentEditarPerfilBinding

class CarrinhoFragment : Fragment() {

    private lateinit var binding: FragmentCarrinhoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCarrinhoBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}