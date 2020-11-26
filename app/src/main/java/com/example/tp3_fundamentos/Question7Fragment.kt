package com.example.tp3_fundamentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_question2.*

class Question7Fragment : Fragment() {

    var scoreQuestion7 : Int = 0


    lateinit var radioButton: RadioButton

    val question7 = Question(
        7,
        "7. Em relação as aplicações e rendimentos, em qual dessas situações você " +
                "se enquadra?",
        "Conto com o rendimento dessas aplicações para complementar minha renda " +
                "mensal",
        "Eventualmente posso resgatar parte das aplicações para fazer frente aos " +
                "meus gastos. Contudo, não tenho intenção de resgatar no curto prazo e " +
                "pretendo fazer aplicações regulares",
        "Não tenho intenção de resgatar no curto prazo, mas não pretendo realizar " +
                "novas aplicações",
        "Não tenho intenção de resgatar no curto prazo e ainda pretendo fazer " +
                "aplicações regulares",
        null,
        0,
        2,
        3,
        4,
        null
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question7, container, false)
        val usuarioNome = arguments?.get("userName").toString()
        val titulo = view.findViewById<TextView>(R.id.editTextUsuarioNome)
        titulo.setText(usuarioNome)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = question7.question
        radioButtonOptionA.text = question7.optionOne
        radioButtonOptionB.text = question7.optionTwo
        radioButtonOptionC.text = question7.optionThree
        radioButtonOptionD.text = question7.optionFour

        btnProximaQuestao.setOnClickListener {

            var bundleNewScore7 = Bundle(onRadioButtonClicked())
            bundleNewScore7.putInt("score7", scoreQuestion7)

            findNavController().navigate(R.id.action_question7Fragment_to_question8Fragment, bundleNewScore7)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestion6: Int = arguments?.get("score6") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _question7 = Question7Fragment().question7

        if (radioButtonOptionA.isChecked) {
            scoreQuestion7 = _question7.optionOneScore + scoreQuestion6
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestion7 = _question7.optionTwoScore + scoreQuestion6
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestion7 = _question7.optionThreeScore + scoreQuestion6
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestion7 = _question7.optionFourScore!! + scoreQuestion6
        }
        return scoreQuestion7
    }
}