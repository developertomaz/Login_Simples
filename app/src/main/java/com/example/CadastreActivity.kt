package com.example

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.login.MainActivity
import com.example.login.R

class CadastreActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastre)

        editText = findViewById(R.id.editText)
        editText2 = findViewById(R.id.editText2)

        val btnCadastro: Button = findViewById(R.id.button)

        btnCadastro.setOnClickListener {
           if (!validar()){
               Toast.makeText(this, "Alert! Campos não preechidos", Toast.LENGTH_LONG).show()
           }else{
               Toast.makeText(this, " Cadastrado realizado com sucesso!", Toast.LENGTH_LONG).show()
               val volta =Intent(this,MainActivity::class.java)
               startActivity(volta)
           }

            // Comando padrao esconder teclado
            val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            service.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }


    private fun validar(): Boolean {

        return ( editText.text.toString().isNotEmpty()
                && editText2.text.toString().isNotEmpty()
                )
    }
}