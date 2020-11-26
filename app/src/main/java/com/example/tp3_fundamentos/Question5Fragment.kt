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

class Question5Fragment : Fragment() {

    var scoreQuestion5 : Int = 0

    lateinit var radioButton: RadioButton

    val question5 = Question(
        5,
        "5. Caso as suas aplicações sofressem uma queda superior a 30%, " +
                "o que você faria?",
        "Resgataria toda a aplicação e aplicaria na poupança",
        "Manteria aplicação aguardando uma melhora do mercado",
        "Aumentaria a aplicação para aproveitar as oportunidades do mercado",
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
        val view = inflater.inflate(R.layout.fragment_question5, container, false)
        val usuarioNome = arguments?.get("userName").toString()
        /*val titulo = view.findViewById<TextView>(R.id.editTextUsuarioNome)
        titulo.setText(usuarioNome)*/

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = question5.question
        radioButtonOptionA.text = question5.optionOne
        radioButtonOptionB.text = question5.optionTwo
        radioButtonOptionC.text = question5.optionThree

        btnProximaQuestao.setOnClickListener {

            var bundleNewScore5 = Bundle(onRadioButtonClicked())
            bundleNewScore5.putInt("score5", scoreQuestion5)

            findNavController().navigate(R.id.action_question5Fragment_to_question6Fragment, bundleNewScore5)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestion4: Int = requireArguments().getInt("score4")

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _question5 = Question5Fragment().question5

        if (radioButtonOptionA.isChecked) {
            scoreQuestion5 = _question5.optionOneScore + scoreQuestion4
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestion5 = _question5.optionTwoScore + scoreQuestion4
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestion5 = _question5.optionThreeScore + scoreQuestion4
        }
        return scoreQuestion5
    }
}