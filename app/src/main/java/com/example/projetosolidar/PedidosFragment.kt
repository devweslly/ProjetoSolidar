package com.example.projetosolidar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetosolidar.databinding.FragmentPedidosBinding

class PedidosFragment : Fragment() {

    private lateinit var binding: FragmentPedidosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentPedidosBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}