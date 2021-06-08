package com.example.studentregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var tilName: TextInputEditText
    lateinit var tilDOB: TextInputEditText
    lateinit var spNationality: Spinner
    lateinit var tilPhone: TextInputEditText
    lateinit var tilEmail: TextInputEditText
    lateinit var btnRegister: Button
    lateinit var tilId: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        clickRegister()

    }
    fun castViews(){
        tilName = findViewById(R.id.tilName)
        tilDOB = findViewById(R.id.tilDOB)
        spNationality = findViewById(R.id.spNationality)
        tilEmail = findViewById(R.id.tilEmail)
        tilPhone = findViewById(R.id.tilPhone)
        btnRegister = findViewById(R.id.btnRegister)
        tilId = findViewById(R.id.tilId)
        val nationality = arrayOf("Kenyan", "Ugandan", "Rwandan", "South Sudan")
        var nationalityAdapter = ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, nationality)
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spNationality.adapter = nationalityAdapter
    }
    fun clickRegister(){
        btnRegister.setOnClickListener {
            var name = tilName.text.toString()
            if (name.isEmpty()) {
                tilName.setError("Name is required")
            }
            var dob = tilDOB.text.toString()
            if (dob.isEmpty()) {
                tilDOB.setError("Date of birth is required")
            }
            var idNumber = tilId.text.toString()
            if (idNumber.isEmpty()){
                tilId.setError("ID Number required")
            }
            var nationality = spNationality.selectedItem.toString()
            var email = tilEmail.text.toString()
            if (email.isEmpty()){
                tilEmail.setError("Email required")
            }
            var phone = tilPhone.text.toString()
            if (phone.isEmpty()){
                tilPhone.setError("Input phone number")
            }
            var details = Register(
                name = name, dob = dob, nationality = "",
                idNumber = idNumber, email = email, phoneNumber = phone
            )
//        Toast.makeText(baseContext, details.toString(), Toast.LENGTH_LONG).show()
            val intent = Intent(baseContext,CourseDetailsActivity::class.java)
            startActivity(intent)
        }
    }
    data class Register(var name: String,
                        var dob: String,
                        var nationality: String,
                        var idNumber: String,
                        var email: String,
                        var phoneNumber: String)
}
