package com.example.tp3_fundamentos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        Log.i("CicloDeVida", "QuestionsActivity onCreate")

        var usuarioNome = intent.getStringExtra("userName").toString()

        //var finalScore: Int = 0

        Toast.makeText(
                this,
                "Olá $usuarioNome",
                Toast.LENGTH_LONG
        ).show()
    }
}