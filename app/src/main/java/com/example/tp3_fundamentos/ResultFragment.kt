package com.example.tp3_fundamentos

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        /*// Usuario NOME
        val usuarioNome = arguments?.get("userName").toString()
        val exibirNomeUsuario = view.findViewById<TextView>(R.id.textViewNomeUsuario)
        //textViewNomeUsuario.text = "Olá ${usuarioNome}"
        //val nomeUsuarioFinal : String? = "Olá ${usuarioNome}"
        exibirNomeUsuario.setText("Olá $usuarioNome")*/
        //------------------------------------------------------------------------------------------
        // Pontuação final
        val finalScore = arguments?.get("score9") as Int
        var bundleFinalScore = Bundle()
        bundleFinalScore.putInt("score9", finalScore)
        val exibirFinalScore = view.findViewById<TextView>(R.id.textViewFinalScore)
        exibirFinalScore.setText("Total de Pontos: $finalScore")
        //------------------------------------------------------------------------------------------
        // Perfil do investidor
        //val perfilInvestidor = finalScore.toString()

        /*if (finalScore <= 12) {
            textViewInvestidorPerfil.text = "Convervador"
        } else if (finalScore <= 29) {
            textViewInvestidorPerfil.text = "Moderado"
        } else {
            textViewInvestidorPerfil.text = "Arrojado"
        }

        textViewInvestidorPerfil.text = ""*/

        //val exibirPerfilInvestidor = view.findViewById<TextView>(R.id.textViewInvestidorPerfil)
        //exibirPerfilInvestidor.setText("O Seu Perfil é de Investidor $perfilInvestidor")

        return view
    }

    /*fun tipoInvestidorPerfil(finalScore: Int) {
        if (finalScore <= 12) {
            textViewInvestidorPerfil.text = "Convervador"
        } else if (finalScore <= 29) {
            textViewInvestidorPerfil.text = "Moderado"
        } else {
            textViewInvestidorPerfil.text = "Arrojado"
        }.toString()
        return
    }*/
}