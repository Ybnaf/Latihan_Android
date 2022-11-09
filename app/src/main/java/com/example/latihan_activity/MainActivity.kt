package com.example.latihan_activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        btnCalculate.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate) {
            //val artinya Object Immutable yang tidak dapat di ubah isinya atau di ganti nilainya.
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            //isEmptyFields adalah metode yang digunakan untuk mengecek isi kolom EditText.
            var isEmptyFields = false

            //jika input kosong maka akan muncul pernyataan error "Field Ini Tidak Boleh Kosong".
            if (inputLength.isEmpty()) {
                isEmptyFields = true
                edtLength.error = "Field Ini Tidak Boleh Kosong"
            }

            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                edtWidth.error = "Field Ini Tidak Boleh Kosong"
            }

            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                edtHeight.error = "Field Ini Tidak Boleh Kosong"
            }

            //jika input tidak kosong maka hasil akan ditampilkan.
            if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }

    private fun toDouble(str: String): Double? {
        return try {
            str.toDouble()
        } catch (e: NumberFormatException) {
            null
        }

    }
}


