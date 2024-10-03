package com.example.cp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class Display : Fragment() {

    private lateinit var gridLayout: GridLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate o layout para este fragmento
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar o GridLayout
        gridLayout = view.findViewById(R.id.gridLayout)

        // Obter os argumentos passados
        arguments?.let {
            val name = it.getString("name") ?: "Nome não fornecido"
            val age = it.getString("age") ?: "Idade não fornecida"
            val email = it.getString("email") ?: "Email não fornecido"

            // Criar TextViews dinamicamente e adicionar ao GridLayout
            val nameTextView = TextView(context).apply {
                text = "Nome: $name"
            }

            val ageTextView = TextView(context).apply {
                text = "Idade: $age"
            }

            val emailTextView = TextView(context).apply {
                text = "Email: $email"
            }

            // Adiciona os TextViews ao GridLayout
            gridLayout.addView(nameTextView)
            gridLayout.addView(ageTextView)
            gridLayout.addView(emailTextView)
        }
    }
}
