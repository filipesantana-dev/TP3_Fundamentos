package com.example.tp3_fundamentos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_question2.*

class Question2Fragment : Fragment() {

    var scoreQuestion2: Int = 0

    lateinit var radioButton: RadioButton

    val question2 = Question(
            2,
            "2. Qual o objetivo desse investimento?",
            "Preservação do capital para não perder valor ao longo do tempo,assumindo" +
                    " baixos riscos de perdas",
            "Aumento gradual do capital ao longo do tempo, assumindo riscos moderados",
            "Aumento do capital acima da taxa de retorno média do mercado, mesmo que" +
                    " isso implique assumir riscos de perdas elevadas",
            "Obter no curto prazo retornos elevados e significativamente acima da taxa " +
                    "de retorno média do mercado, assumindo riscos elevados",
            null,
            0,
            2,
            4,
            5,
            null
    )

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = question2.question
        radioButtonOptionA.text = question2.optionOne
        radioButtonOptionB.text = question2.optionTwo
        radioButtonOptionC.text = question2.optionThree
        radioButtonOptionD.text = question2.optionFour

        btnProximaQuestao.setOnClickListener {

            var bundleNewScore2 = Bundle(onRadioButtonClicked())
            bundleNewScore2.putInt("score2", scoreQuestion2)

            findNavController().navigate(R.id.action_question2Fragment2_to_question3Fragment, bundleNewScore2)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestion1: Int = arguments?.get("score1") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _question2 = Question2Fragment().question2

        if (radioButtonOptionA.isChecked) {
            scoreQuestion2 = _question2.optionOneScore + scoreQuestion1
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestion2 = _question2.optionTwoScore + scoreQuestion1
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestion2 = _question2.optionThreeScore + scoreQuestion1
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestion2 = _question2.optionFourScore!! + scoreQuestion1
        }
        return scoreQuestion2
    }
}