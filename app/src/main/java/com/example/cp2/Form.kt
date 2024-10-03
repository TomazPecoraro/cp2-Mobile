package com.example.cp2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class Form : Fragment() {

    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSubmit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate o layout para este fragmento
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar os componentes
        editTextName = view.findViewById(R.id.editTextName)
        editTextAge = view.findViewById(R.id.editTextAge)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        buttonSubmit = view.findViewById(R.id.btnSubmit)

        buttonSubmit.setOnClickListener {
            // Criar um bundle para passar os dados
            val name = editTextName.text.toString()
            val age = editTextAge.text.toString()
            val email = editTextEmail.text.toString()

            Log.d("FormFragment", "Name: $name, Age: $age, Email: $email") // Log dos dados

            val bundle = Bundle().apply {
                putString("name", name)
                putString("age", age)
                putString("email", email)
            }

            // Criar uma nova instância do DisplayFragment
            val displayFragment = Display().apply {
                arguments = bundle // Passar o bundle como argumentos
            }

            // Substituir o fragmento atual pelo DisplayFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, displayFragment)
                .commit() // Remove a adição à pilha de retorno
        }
    }
}
