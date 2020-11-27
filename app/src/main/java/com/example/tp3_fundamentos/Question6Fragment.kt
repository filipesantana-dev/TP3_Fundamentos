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

class Question6Fragment : Fragment() {

    var scoreQuestion6 :Int = 0


    lateinit var radioButton: RadioButton

    val question6 = Question(
        6,
        "6. Como está distribuído o seu patrimônio?",
        "Meu patrimônio não está aplicado ou está todo aplicado em renda Fixa " +
                "e/ou imóveis",
        "Menos de 25% em renda variável e o restante em renda Fixa e/ou imóveis ",
        "Entre 25,01 e 50% aplicado em renda variável e o restante em renda Fixa " +
                "e/ou imóveis",
        "Acima de 50% em renda variável",
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
        return inflater.inflate(R.layout.fragment_question6, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = question6.question
        radioButtonOptionA.text = question6.optionOne
        radioButtonOptionB.text = question6.optionTwo
        radioButtonOptionC.text = question6.optionThree
        radioButtonOptionD.text = question6.optionFour

        btnProximaQuestao.setOnClickListener {

            var bundleNewScore6 = Bundle(onRadioButtonClicked())
            bundleNewScore6.putInt("score6", scoreQuestion6)

            findNavController().navigate(R.id.action_question6Fragment_to_question7Fragment, bundleNewScore6)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestion5 : Int = arguments?.get("score5") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _question6 = Question6Fragment().question6

        if (radioButtonOptionA.isChecked) {
            scoreQuestion6 = _question6.optionOneScore + scoreQuestion5
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestion6 = _question6.optionTwoScore + scoreQuestion5
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestion6 = _question6.optionThreeScore + scoreQuestion5
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestion6 = _question6.optionFourScore!! + scoreQuestion5
        }
        return scoreQuestion6
    }
}