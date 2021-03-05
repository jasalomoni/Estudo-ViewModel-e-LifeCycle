package com.one.digitalinnovation.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtContador: TextView
    lateinit var btnDados: Button
    lateinit var btnExibir: Button

    lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDados()
        initClick()
    }

    private fun initDados() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        txtContador = findViewById(R.id.txtContador)
        btnDados = findViewById(R.id.btnDados)
        btnExibir = findViewById(R.id.btnExibir)

        mViewModel.mContador.observe(this, Observer { valor ->
            txtContador.setText(valor)
        })
    }

    private fun initClick() {
        btnDados.setOnClickListener {
            mViewModel.Contador()
        }

        btnExibir.setOnClickListener {
            Toast.makeText(applicationContext, "Valor do Contador: ${mViewModel.mContador.value}", Toast.LENGTH_SHORT).show()
        }
    }
}