package com.example.tp3_fundamentos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var btnIniciarQuestionario: Button
    lateinit var editTextUsuarioNome: TextView
    lateinit var textViewCreditoCriadorPage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIniciarQuestionario = findViewById(R.id.btnIniciarQuestionario)
        editTextUsuarioNome = findViewById(R.id.editTextUsuarioNome)

        btnIniciarQuestionario.setOnClickListener {

            var nomeUsuario = editTextUsuarioNome.text.toString()

            if (nomeUsuario.isEmpty()) {
                Toast.makeText(this, "Informe seu nome", Toast.LENGTH_LONG
                ).show()
            } else {
                var alterActivity = Intent(
                        this,
                        QuestionsActivity::class.java)
                alterActivity.putExtra("userName", nomeUsuario)
                startActivity(alterActivity)
            }
        }

        textViewCreditoCriadorPage = findViewById(R.id.textViewCreditoCriadorPage)
        textViewCreditoCriadorPage.setOnClickListener {
            var creditoCriadorPage = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.bancopaulista.com.br/Arquivos/QuestionarioAPI.pdf")
            )
            if (creditoCriadorPage.resolveActivity(packageManager) !=
                    null)
                startActivity(creditoCriadorPage)
        }
    }
}