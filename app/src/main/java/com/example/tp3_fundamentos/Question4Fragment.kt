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

class Question4Fragment : Fragment() {

    var scoreQuestion4: Int = 0

    lateinit var radioButton: RadioButton

    val question4 = Question(
        4,
        "4. Considerando seus rendimentos regulares, qual a porcentagem você " +
                "pretende reservar para aplicações Financeiras?",
        "No máximo 25%",
        "Entre 25,01 e 50%",
        "Acima de 50% ",
        null,
        null,
        0,
        2,
        4,
        null,
        null
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = question4.question
        radioButtonOptionA.text = question4.optionOne
        radioButtonOptionB.text = question4.optionTwo
        radioButtonOptionC.text = question4.optionThree

        btnProximaQuestao.setOnClickListener {

            var bundleNewScore4 = Bundle(onRadioButtonClicked())
            bundleNewScore4.putInt("score4", scoreQuestion4)

            findNavController().navigate(R.id.action_question4Fragment_to_question5Fragment, bundleNewScore4)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestion3: Int = arguments?.getInt("score3") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _question4 = Question4Fragment().question4

        if (radioButtonOptionA.isChecked) {
            scoreQuestion4 = _question4.optionOneScore + scoreQuestion3
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestion4 = _question4.optionTwoScore + scoreQuestion3
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestion4 = _question4.optionThreeScore + scoreQuestion3
        }
        return scoreQuestion4
    }
}
