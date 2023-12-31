package com.example.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.CadastreActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtName: EditText
    private lateinit var txtSenha: EditText
    private lateinit var linkBtn: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtName = findViewById(R.id.txt_Name)
        txtSenha = findViewById(R.id.txt_Senha)
        linkBtn = findViewById(R.id.link_btn)


        //----------------------------------------------
        val dbName: String = "User"
        val dbPassword: Int = 123

        val btnCadastro: Button = findViewById(R.id.button)
        btnCadastro.setOnClickListener {
            if (!valid()) {
                Toast.makeText(this, "Campo obrigatório!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            // Comando padrao esconder teclado
            val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            service.hideSoftInputFromWindow(currentFocus?.windowToken, 0)


            val name = txtName.text.toString()
            val password = txtSenha.text.toString().toInt()

            if (name == dbName && password == dbPassword) {

                val go1 = Intent(this, HomeActivity::class.java)
                startActivity(go1)
            } else {
                Toast.makeText(
                    this,
                    "Alerta! Usuário não encontrado!",
                    Toast.LENGTH_SHORT
                ).show()
            }

            //Link para cadastrar---------------------------------
            linkBtn.setOnClickListener {
                val ir = Intent(this, CadastreActivity::class.java)
                startActivity(ir)
            }
        }

    }


    private fun valid(): Boolean {
        return (txtName.text.toString().isNotEmpty()
                && txtSenha.text.isNotEmpty()
                )
    }
}