package com.example.controldegastos

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnIA = findViewById<ImageButton>(R.id.btnIA)
        btnIA.setOnClickListener {
            val intent = Intent(this, IAActivity::class.java)
            startActivity(intent)
        }

        val btnAgregar = findViewById<ImageButton>(R.id.btnAgregar)
        btnAgregar.setOnClickListener {
            val intent = Intent(this, AgregarActivity::class.java)
            startActivity(intent)
        }

        val btnSalir = findViewById<ImageButton>(R.id.btnSalir)
        btnSalir.setOnClickListener {
            finish()
        }

        val filas = listOf(
            R.id.filaGasto1,
            R.id.filaGasto2,
            R.id.filaGasto3,
            R.id.filaGasto4,
            R.id.filaGasto5
        )
        for (idFila in filas) {
            findViewById<LinearLayout>(idFila).setOnClickListener {
                val intent = Intent(this, DetalleActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
