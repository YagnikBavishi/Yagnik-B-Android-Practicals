package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.androidpractical.R

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val edFirstName: EditText = findViewById(R.id.firstName)
        val edLastName: EditText = findViewById(R.id.lastName)
        val rgGender: RadioGroup = findViewById(R.id.rgGender)
        val cbCricket: CheckBox = findViewById(R.id.cricket)
        val cbReading: CheckBox = findViewById(R.id.reading)
        val cbWriting: CheckBox = findViewById(R.id.writing)
        val submitButton: Button = findViewById(R.id.btnSubmit)

        submitButton.setOnClickListener {
            val gender: RadioButton = findViewById(rgGender.checkedRadioButtonId)
            var checkedCricket = ""
            var checkedReading = ""
            var checkedWriting = ""

            if (cbCricket.isChecked) {
                checkedCricket = cbCricket.text as String
            }
            if (cbReading.isChecked) {
                checkedReading = cbReading.text as String
            }
            if (cbWriting.isChecked) {
                checkedWriting = cbWriting.text as String
            }

            Toast.makeText(
                this,
                "Form Values :-" +
                        "FirstName : " + edFirstName.text + "\n" +
                        "LastName : " + edLastName.text + "\n" +
                        "Gender : " + gender.text + "\n" +
                        "Hobbies : " + checkedCricket + " " + checkedReading + " " + checkedWriting,
                Toast.LENGTH_SHORT
            ).show();
        }
    }
}