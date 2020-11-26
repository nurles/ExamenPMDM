package com.programacionmultimedia.examenpmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    companion object{
        var LISTA = mutableListOf<String>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val boton = findViewById<Button>(R.id.button)

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                LISTA = editText.text.toString().split("\n") as MutableList<String>
                boton.isEnabled = LISTA.size > 3
            }


        })

        boton.setOnClickListener {
            for (i in LISTA) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(SecondActivity.VAR, i)
                startActivity(intent)
            }
        }
    }
}