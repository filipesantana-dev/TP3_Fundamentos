package com.example.tp3_fundamentos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var usuarioNome: String? = intent!!.getStringExtra("userName").toString()
        textViewNomeUsuario.text = "Usuário: $usuarioNome"


        var finalScore: Int = intent!!.getIntExtra("score9", 0)

        exibirTipoPerfilInvestidor(finalScore)

        Toast.makeText(
                this,
                "Pontuação final: $finalScore",
                Toast.LENGTH_LONG
        ).show()
    }

    private fun exibirTipoPerfilInvestidor(finalScore: Int) {
        textViewInvestidorPerfil.text =  if (finalScore <= 12) {
            "Investidor: Conservador"
        } else if (finalScore <= 29) {
             "Investidor: Moderado"
        } else {
            "Investidor: Arrojado"
        }
    }
}