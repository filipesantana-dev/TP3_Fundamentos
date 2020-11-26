package com.example.tp3_fundamentos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.fragment_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        /*var usuarioNome: String = intent.getStringExtra("userName").toString()
        var exibirUsuarioNome = "Olá {$usuarioNome}"
        textViewNomeUsuario.text = exibirUsuarioNome*/


        var finalScore: Int = intent.getIntExtra("score9", 0)

        if (finalScore <= 12){
            textViewInvestidorPerfil.text = "O Seu Perfil é de Investidor Conservador"
        } else if (finalScore <= 29){
            textViewInvestidorPerfil.text = "O Seu Perfil é de Investidor Moderado"
        } else {
            textViewInvestidorPerfil.text = "O Seu Perfil é de Investidor Arrojado"
        }

        textViewInvestidorPerfil.text = ""


        //textViewFinalScore.text = "Total de Pontos: $finalScore"

        Toast.makeText(
                this,
                "Pontuação final: $finalScore",
                Toast.LENGTH_LONG
        ).show()
    }
}