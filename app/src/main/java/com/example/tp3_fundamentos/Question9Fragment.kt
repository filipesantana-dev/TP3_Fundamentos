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
import kotlinx.android.synthetic.main.fragment_question2.btnProximaQuestao
import kotlinx.android.synthetic.main.fragment_question2.radioButtonOptionA
import kotlinx.android.synthetic.main.fragment_question2.radioButtonOptionB
import kotlinx.android.synthetic.main.fragment_question2.radioButtonOptionC
import kotlinx.android.synthetic.main.fragment_question2.radioButtonOptionD
import kotlinx.android.synthetic.main.fragment_question2.radioGroupOptions
import kotlinx.android.synthetic.main.fragment_question2.textViewQuestion
import kotlinx.android.synthetic.main.fragment_question9.*

class Question9Fragment : Fragment() {

    var scoreQuestion9: Int = 0

    lateinit var radioButton: RadioButton

    val question9 = Question(
            9,
            "9. Qual o valor aproximado do seu patrimônio?",
            "Até R$ 10.000",
            "De R$ 10.001 até R$ 100.00",
            "De R$ 100.001 até R$ 500.000",
            "De R$ 500.001 até R$ 1.000.000",
            "Acima de R$ 1.000.001",
            0,
            1,
            2,
            4,
            5
    )

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question9, container, false)
        val usuarioNome = arguments?.get("userName").toString()
        val titulo = view.findViewById<TextView>(R.id.editTextUsuarioNome)
        titulo.setText(usuarioNome)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = question9.question
        radioButtonOptionA.text = question9.optionOne
        radioButtonOptionB.text = question9.optionTwo
        radioButtonOptionC.text = question9.optionThree
        radioButtonOptionD.text = question9.optionFour
        radioButtonOptionE.text = question9.optionFive

        btnProximaQuestao.setOnClickListener {

            var bundleNewScore9 = Bundle(onRadioButtonClicked())
            bundleNewScore9.putInt("score9", scoreQuestion9)

            findNavController().navigate(R.id.action_question9Fragment_to_resultFragment, bundleNewScore9)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestion8: Int = arguments?.getInt("score8") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _question9 = Question9Fragment().question9

        if (radioButtonOptionA.isChecked) {
            scoreQuestion9 = _question9.optionOneScore + scoreQuestion8
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestion9 = _question9.optionTwoScore + scoreQuestion8
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestion9 = _question9.optionThreeScore + scoreQuestion8
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestion9 = _question9.optionFourScore!! + scoreQuestion8
        } else if (radioButtonOptionE.isChecked) {
            scoreQuestion9 = _question9.optionFiveScore!! + scoreQuestion8
        }

        return scoreQuestion9
    }
}
