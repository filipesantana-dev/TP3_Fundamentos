package com.example.tp3_fundamentos

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

        val usuarioNome = arguments?.get("userName").toString()
        val exibirNomeUsuario = view.findViewById<TextView>(R.id.textViewNomeUsuario)
        //textViewNomeUsuario.text = "Olá ${usuarioNome}"
        //val nomeUsuarioFinal : String? = "Olá ${usuarioNome}"
        exibirNomeUsuario.setText("Olá $usuarioNome")

        val finalScore = arguments?.get("score9").toString()
        val exibirFinalScore = view.findViewById<TextView>(R.id.textViewFinalScore)
        exibirFinalScore.setText("Total de Pontos: $finalScore")

        return view
    }
}