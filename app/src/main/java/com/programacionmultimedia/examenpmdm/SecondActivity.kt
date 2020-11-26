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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textView = findViewById<TextView>(R.id.textView)
        val boton = findViewById<Button>(R.id.botonAct2)
        val boton2 = findViewById<Button>(R.id.boton2Act2)
        val boton3 = findViewById<Button>(R.id.boton3Act2)
        val editText = findViewById<EditText>(R.id.editText2)

        if(!editText.text.equals('a') || !editText.text.equals('e') || !editText.text.equals('i') || !editText.text.equals('o') || !editText.text.equals('u')){
            println("No válido. Escribe una vocal")
            editText.text = null
        }
        //Guardamos en una lista las palabras del otro Main
        val palabra = mutableListOf<String>(intent.getStringExtra(VAR).toString())
        for(i in palabra) {
            //Imprimimos en el TextView la lista de palabra con salto de linea entre cada una
            textView.text = ("$i \n")
        }

        boton.setOnClickListener{
            //Recorre la lista de palabras
            for(i in palabra) {
                //Recorre cada letra de cada palabra
                for(j in i) {
                    textView.text = ("$j")
                    if (j == 'a' || j == 'e' || j =='i' || j=='o' || j=='u')
                        //Si la letra es una vocal la pinta otra vez
                        textView.text = ("$j")
                }
                textView.text = ("\n")
            }
        }

        boton2.setOnClickListener{
            var i=3
             repeat(palabra.size){
                 textView.text = palabra[it+i]
                 if(i>0) {
                     i -= 2
                 }else
                     i=0
             }
        }

        boton3.setOnClickListener{
            for (i in palabra){
                for(j in i){
                    //Si la letra escrita en el edittext es igual a la letra de la palabra sustituye esa letra por un smile
                    if (editText.text.equals(j))     {
                        textView.text = ("🙂")
                    }else
                         textView.text = ("$j")
                }
                 textView.text = ("\n")
            }

        }
    }

}