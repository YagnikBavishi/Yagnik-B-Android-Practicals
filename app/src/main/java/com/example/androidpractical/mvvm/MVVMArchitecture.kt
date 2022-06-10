package com.example.androidpractical.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.androidpractical.R
import com.example.androidpractical.databinding.ActivityMvvmarchitectureBinding
import com.example.androidpractical.mvvm.viewModel.LoginViewModel

class MVVMArchitecture : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMvvmarchitectureBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmarchitectureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.onClick = this

        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this
        true.also { binding.imgProfile.clipToOutline = it }

        viewModel.message.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btnSubmit -> {
                Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
