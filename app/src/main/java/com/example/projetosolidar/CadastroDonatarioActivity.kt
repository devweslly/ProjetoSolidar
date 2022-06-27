package com.example.projetosolidar

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.projetosolidar.data.Usuario
import com.example.projetosolidar.databinding.ActivityCadastroDonatarioBinding

class CadastroDonatarioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroDonatarioBinding
    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroDonatarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)

        // Ação de click
        binding.botaoCriarDonatario.setOnClickListener {

            // chamada do metodo
            criarUsuario()
        }
    }

    private fun validarCampos(
        nome: String,
        email: String,
        senha: String,
        repetir_senha: String,
        cnpj_cpf: String,
        cep: String,
        endereco: String,
        numero: String,
        bairro: String,
        cidade: String
    ): Boolean {
        return !(
                (nome == "") ||
                (email == "") ||
                (senha == "" || senha.length < 6 || senha.length > 8) ||
                (repetir_senha != senha) ||
                (cnpj_cpf == "" || cnpj_cpf.length > 14) ||
                (cep == "") ||
                (endereco == "") ||
                (numero == "") ||
                (bairro == "") ||
                (cidade == "")
                )
    }

    private fun criarUsuario(){

        var nome = binding.nomeOng.text.toString()
        var email = binding.entrarEmailDonatario.text.toString()
        var senha = binding.senhaEmailDonatario.text.toString()
        var repetir_senha = binding.repetirSenhaDonatario.text.toString()
        var cnpj_cpf = binding.cpfCnpjDonatario.text.toString()
        var cep = binding.cepDonatario.text.toString()
        var endereco = binding.enderecoDonatario.text.toString()
        var numero = binding.numeroDonatario.text.toString()
        var bairro = binding.bairroDonatario.text.toString()
        var cidade = binding.cidadeDonatario.text.toString()


        if (validarCampos(nome, email, senha, repetir_senha, cnpj_cpf, cep, endereco, numero, bairro, cidade)) {
            val usuario = Usuario(0, nome, email, senha, cnpj_cpf, cep, endereco, numero, bairro, cidade)
            usuarioViewModel.addUsuario(usuario)
            Toast.makeText(applicationContext, "Cadastro Realizado", Toast.LENGTH_LONG).show()

            val telaInicio = Intent(this, MainActivity::class.java)
            startActivity(telaInicio)

        } else {
            Toast.makeText(applicationContext, "Verifique os Campos", Toast.LENGTH_LONG).show()
        }
    }
}