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

class Question3Fragment : Fragment() {

    var scoreQuestion3: Int = 0

    lateinit var radioButton: RadioButton

    val question3 = Question(
        3,
        "3. Qual das alternativas melhor classifica sua formação e experiência " +
                "com o mercado Financeiro?",
        "Não possuo formação acadêmica ou conhecimento do mercado Financeiro ",
        "Possuo formação acadêmica na área Financeira, mas não tenho experiência " +
                "com o mercado Financeiro ",
        "Possuo formação acadêmica em outra área, mas possuo conhecimento do " +
                "mercado Financeiro ",
        "Possuo formação acadêmica na área Financeira ou pleno conhecimento do" +
                " mercado Financeiro",
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
        val view = inflater.inflate(R.layout.fragment_question3, container, false)
        val usuarioNome = arguments?.get("userName").toString()
        /*val titulo = view.findViewById<TextView>(R.id.editTextUsuarioNome)
        titulo.setText(usuarioNome)*/

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewQuestion.text = question3.question
        radioButtonOptionA.text = question3.optionOne
        radioButtonOptionB.text = question3.optionTwo
        radioButtonOptionC.text = question3.optionThree
        radioButtonOptionD.text = question3.optionFour

        btnProximaQuestao.setOnClickListener {

            var bundleNewScore3 = Bundle(onRadioButtonClicked())
            bundleNewScore3.putInt("score3", scoreQuestion3)


            findNavController().navigate(R.id.action_question3Fragment_to_question4Fragment, bundleNewScore3)
        }
    }

    private fun onRadioButtonClicked(): Int {
        val scoreQuestion2 = arguments?.getInt("score2") as Int

        val checkedOptionsRadioButtonId = radioGroupOptions.checkedRadioButtonId
        radioButton = radioGroupOptions.findViewById(checkedOptionsRadioButtonId)

        val _question3 = Question3Fragment().question3

        if (radioButtonOptionA.isChecked) {
            scoreQuestion3 = _question3.optionOneScore + scoreQuestion2
        } else if (radioButtonOptionB.isChecked) {
            scoreQuestion3 = _question3.optionTwoScore + scoreQuestion2
        } else if (radioButtonOptionC.isChecked) {
            scoreQuestion3 = _question3.optionThreeScore + scoreQuestion2
        } else if (radioButtonOptionD.isChecked) {
            scoreQuestion3 = _question3.optionFourScore!! + scoreQuestion2
        }
        return scoreQuestion3
    }
}