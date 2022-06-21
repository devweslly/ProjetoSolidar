package com.example.projetosolidar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CadastroPerfilDonatarioActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_perfil_donatario)

        val botaoCriarContaDonatario = findViewById<Button>(R.id.botao_criar_donatario)

        botaoCriarContaDonatario.setOnClickListener {
            irTelaCriarProduto()
        }
    }

    private fun irTelaCriarProduto(){
        val telaCadasProduto = Intent(this, MainActivity::class.java)
        startActivity(telaCadasProduto)
    }
}