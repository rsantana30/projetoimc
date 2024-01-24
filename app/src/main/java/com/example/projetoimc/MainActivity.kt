package com.example.projetoimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtpeso: EditText = findViewById(R.id.edt_peso)
        val edtalt: EditText = findViewById(R.id.edt_altura)
        val btn: Button = findViewById(R.id.btn_calcular)

        btn.setOnClickListener {

           val alturaStr = edtalt.text.toString()
            val pesoStr = edtpeso.text.toString()
            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {

                val peso = edtpeso.text.toString().toFloat()
                val altura = edtalt.text.toString().toFloat()
                val alturaquadrado: Float = altura * altura
                val imc: Float = peso / alturaquadrado


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("Extra_Result", imc)
                    }
                startActivity(intent)
            } else Toast.makeText(this, "Preencha todos os campos!",Toast.LENGTH_LONG).show()
        }
    }
}