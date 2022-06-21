package com.example.projetosolidar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class CadastroDonatarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_donatario)

        // findViewById(id) - acessando o botão
        val botaoTelaCadastDonatario = findViewById<Button>(R.id.botao_criar_donatario)

        // Ação de click
        botaoTelaCadastDonatario.setOnClickListener {
            // chamada do metodo
            irTelaCadastroPerfil()
        }
    }

    private fun irTelaCadastroPerfil(){
        val telaCadasPerfilDonatario = Intent(this, CadastroPerfilDonatarioActivity::class.java)
        startActivity(telaCadasPerfilDonatario)
    }
}