package com.example.androidpractical.activities


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.Toast
import android.widget.CompoundButton
import android.annotation.SuppressLint
import com.example.androidpractical.R


class ButtonDemoActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_demo)

        val layoutLinear: LinearLayout = findViewById(R.id.linearLayout)
        val button: Button = findViewById(R.id.btnForm)
        val imageButton: ImageButton = findViewById(R.id.imageButton)
        val submit: Button = findViewById(R.id.simpleButton)

        button.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }

        imageButton.setOnClickListener {
            val toast = Toast.makeText(
                applicationContext,
                "Hello Form image Button",
                Toast.LENGTH_SHORT
            )
            toast.show()
        }

        val simpleToggleButton: ToggleButton = findViewById(R.id.simpleToggleButton)
        simpleToggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                simpleToggleButton.setBackgroundColor(Color.BLUE)
                layoutLinear.setBackgroundColor(Color.GREEN)
            } else {
                simpleToggleButton.setBackgroundColor(Color.BLACK)
                layoutLinear.setBackgroundColor(Color.WHITE)
                simpleToggleButton.setTextColor(Color.WHITE)
            }
        }

        val layout = layoutInflater.inflate(R.layout.toast_layout, null)
        submit.setOnClickListener {
            val toast = Toast(applicationContext)
            toast.duration = Toast.LENGTH_SHORT
            toast.setView(layout)
            toast.show()
        }
    }
}