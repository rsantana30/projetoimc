package com.example.projetoimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val tvResult =  findViewById<TextView>(R.id.textview_result)
        val tvClassificacao =  findViewById<TextView>(R.id.textview_classificacao)
        val result = intent.getFloatExtra("Extra_Result", 0.1f)

        tvResult.text = result.toString()

        val classificacao = if (result < 18.50) {
            "Abaixo do peso"
        } else if (result in 18.50..24.99) {
            "Normal"
        } else if (result in 25.00..29.99){
            "Sobrepeso"
        } else if (result in 30.00..34.99){
            "Obesidade grau I"
        } else if (result in 35.00..39.99){
            "Obesidade grau II"
        } else {
            "Obesidade grau III"
        }
        tvClassificacao.text=getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}