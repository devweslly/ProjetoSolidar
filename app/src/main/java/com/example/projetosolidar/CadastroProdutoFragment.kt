package com.example.projetosolidar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projetosolidar.databinding.FragmentCadastroProdutoBinding


class CadastroProdutoFragment : Fragment() {

    private lateinit var binding: FragmentCadastroProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentCadastroProdutoBinding.inflate(layoutInflater, container, false)

        // Criando a lógica do Spinner

        val spinnerPeso = binding.spinner

        // Para obter o context em um fragment, use getActivity(),
        // que renderiza a activity associada a um fragment.
        var thiscontext = container!!.getContext()

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            thiscontext,
            R.array.categoria,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerPeso.adapter = adapter
        }

        binding.buttonCadastrarProduto.setOnClickListener {
            findNavController().navigate(R.id.action_cadastroProdutoFragment_to_listFragment)
            cadastrarProduto()
        }

        return binding.root
    }

    private fun validarCampos(
        nomeProd: String,
        imageProd: String,
        descricaoProd: String,
        quantidadeProd: String
    ): Boolean {
        return !(
                (nomeProd == "" || nomeProd.length < 3 || nomeProd.length > 20) ||
                (imageProd == "") ||
                (descricaoProd == "" || descricaoProd.length < 3 || descricaoProd.length > 200) ||
                (quantidadeProd == "" || quantidadeProd.isEmpty())
                )
    }

    private fun cadastrarProduto() {
        val nome = binding.nomeProduto.text.toString()
        val image = binding.imagemProduto.text.toString()
        val descricao = binding.descricaoProduto.text.toString()
        val quantidade = binding.quantidadeProduto.text.toString()

        if (validarCampos(nome, image, descricao, quantidade)) {
            Toast.makeText(context, "Cadastro Realizado", Toast.LENGTH_LONG).show()
            //findNavController().navigate(R.id.action_cadastroProdutoFragment_to_listFragment)
        } else {
            Toast.makeText(context, "Verifique os Campos", Toast.LENGTH_LONG).show()
        }
    }
}