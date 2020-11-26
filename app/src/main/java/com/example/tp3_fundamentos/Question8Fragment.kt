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

class Question8Fragment : Fragment() {

    var scoreQuestion8 : Int = 0

    lateinit var radioButton: RadioButton

    val question8 = Question(
        8,
        "8. Qual sua faixa de renda mensal média?",
        "Até R$ 1.000",
        "De R$ 1.001 até R$ 5.000",
        "De R$ 5.001 até R$ 10.000",
        "Acima de R$ 10.000",
        null,
        0,
        1,
        2,
        4,
        null
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question8, container, false)
        val usuarioNome = arguments?.get("userName").toString()
        val titulo = view.findViewById<TextView>(R.id.editTextUsuarioNome)
        titulo.setText(usuarioNome)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = question8.question
        radioButtonOptionA.text = question8.optionOne
        radioButtonOptionB.text = question8.optionTwo
        radioButtonOptionC.text = question8.optionThree
        radioButtonOptionD.text = question8.optionFour

        btnProximaQuestao.setOnClickListener {

            var bundleNewScore8 = Bundle(onRadioButtonClicked())
            bundleNewScore8.putInt("score8", scoreQuestion8)
            findNavController().navigate(R.id.action_question8Fragment_to_question9Fragment, bundleNewScore8)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestion7 : Int = arguments?.get("score7") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _question8 = Question8Fragment().question8

        if (radioButtonOptionA.isChecked) {
            scoreQuestion8 = _question8.optionOneScore + scoreQuestion7
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestion8 = _question8.optionTwoScore + scoreQuestion7
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestion8 = _question8.optionThreeScore + scoreQuestion7
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestion8 = _question8.optionFourScore!! + scoreQuestion7
        }
        return scoreQuestion8
    }
}