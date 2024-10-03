package com.example.cp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.cp2.Display
import com.example.cp2.Form
import com.example.cp2.R

class MainActivity : AppCompatActivity() {
    private lateinit var btnForm: Button
    private lateinit var btnDisplay: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encontrando os botões na interface
        btnForm = findViewById(R.id.btnForm)
        btnDisplay = findViewById(R.id.btnDisplay)

        // Definindo o clique no botão Form
        btnForm.setOnClickListener {
            val formFragment = Form()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, formFragment)
                .commit()
        }

        // Definindo o clique no botão Display
        btnDisplay.setOnClickListener {
            val displayFragment = Display()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, displayFragment)
                .commit()
        }

        // No seu MainActivity
        val btnAbout: Button = findViewById(R.id.btnAbout) // Supondo que você tenha adicionado esse botão no layout
        btnAbout.setOnClickListener {
            startActivity(Intent(this, About::class.java))
        }

    }
}
