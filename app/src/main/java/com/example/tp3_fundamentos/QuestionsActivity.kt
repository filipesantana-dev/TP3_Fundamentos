package com.example.tp3_fundamentos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionsActivity : AppCompatActivity() {

    var nomeUsuario : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        Log.i("CicloDeVida", "QuestionsActivity onCreate")

        nomeUsuario = intent.getStringExtra("userName").toString()

        Toast.makeText(
                this,
                "Olá $nomeUsuario",
                Toast.LENGTH_LONG
        ).show()
    }
}