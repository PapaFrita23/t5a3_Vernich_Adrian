package com.example.t5a3_vernich_adrian.activities

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.t5a3_vernich_adrian.R
import com.example.t5a3_vernich_adrian.databinding.ActivityMovimientosBinding
import com.example.t5a3_vernich_adrian.listener.onClickListenerMovimiento
import com.example.t5a3_vernich_adrian.pojo.Movimiento

class MovimientoActivity : AppCompatActivity(), onClickListenerMovimiento {
    private lateinit var binding: ActivityMovimientosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovimientosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Declaramos la variable del spinner
        val spCuentas: Spinner = findViewById(R.id.spnCuentas)

        //Primer spinner de las cuentas
        val cuentas = resources.getStringArray(R.array.accounts)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cuentas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spCuentas.adapter = adapter
        spCuentas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val opcionSeleccionada = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }

    override fun onItemClick(movimiento: Movimiento) {
        Toast.makeText(this, "Has seleccionado la cuenta ${movimiento.getId()}", Toast.LENGTH_SHORT).show()
    }
}