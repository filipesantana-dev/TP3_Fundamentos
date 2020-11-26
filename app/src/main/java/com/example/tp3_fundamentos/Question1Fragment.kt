package com.example.tp3_fundamentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_questions.*
import kotlinx.android.synthetic.main.fragment_question1.*

class Question1Fragment : Fragment() {

    var scoreQuestion1 = 0

    lateinit var radioButton: RadioButton

    val question1 = Question(
            1,
            "1. Por quanto tempo você pretende deixar seu dinheiro investido?",
            "Menos de 6 meses",
            "Entre 6 meses e 1 ano",
            "Entre 1 ano e 3 anos",
            "Acima de 3 anos",
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
        val view = inflater.inflate(R.layout.fragment_question1, container, false)
        val usuarioNome = arguments?.get("userName").toString()
        /*val titulo = view.findViewById<TextView>(R.id.editTextUsuarioNome)
        titulo.setText(usuarioNome)*/


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = question1.question
        radioButtonOptionA.text = question1.optionOne
        radioButtonOptionB.text = question1.optionTwo
        radioButtonOptionC.text = question1.optionThree
        radioButtonOptionD.text = question1.optionFour

        btnProximaQuestao.setOnClickListener {

            var bundleScore = Bundle(onRadioButtonClicked())
            bundleScore.putInt("score1", scoreQuestion1)


            findNavController().navigate(R.id.action_question1Fragment_to_question2Fragment2, bundleScore)
        }
    }

    private fun onRadioButtonClicked(): Int {

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _question1 = Question1Fragment().question1

        if (radioButtonOptionA.isChecked) {
            scoreQuestion1 = _question1.optionOneScore
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestion1 = _question1.optionTwoScore
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestion1 = _question1.optionThreeScore
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestion1 = _question1.optionFourScore!!
        }
        return scoreQuestion1
    }
}