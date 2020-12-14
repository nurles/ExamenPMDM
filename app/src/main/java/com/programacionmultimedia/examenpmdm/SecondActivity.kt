package com.programacionmultimedia.examenpmdm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity  : AppCompatActivity(){

    companion object{
        const val VAR = "palabra"
    }
    val vocales = listOf("a", "e", "i", "o", "u")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textView = findViewById<TextView>(R.id.textView)
        val boton = findViewById<Button>(R.id.botonAct2)
        val boton2 = findViewById<Button>(R.id.boton2Act2)
        val boton3 = findViewById<Button>(R.id.boton3Act2)
        val editText = findViewById<EditText>(R.id.editText2)

        val texto = intent.getStringExtra(VAR)

        texto?.let {
            textView.text = it.replace(",", "\n")
        }

        //Duplicar vocales
        boton.setOnClickListener {
            texto?.let { text: String ->
                var salida = text
                vocales.forEach {
                    salida = salida.replace(it, it + it, true)
                }
                textView.text = salida
            }
        }

        //Invertir orden
        boton2.setOnClickListener {
            texto?.let { text: String ->
                val lista = text.toList()
                val listaInvertida = lista.reversed()
                var salida = ""
                listaInvertida.forEach {
                    salida += it + "\n"
                }
                textView.text = salida
            }
        }

        //Reemplazar vocal por emoji
        boton3.setOnClickListener {
            texto?.let { text: String ->
                val remplazo = text.replace(editText.text.toString(), "🙂")
                val lista = remplazo.split(",")
                var salida = ""
                lista.forEach {
                    if (it.contains("🙂")) {
                        salida += it + "\n"
                    }
                }
                textView.text = salida
            }
        }
    }

}