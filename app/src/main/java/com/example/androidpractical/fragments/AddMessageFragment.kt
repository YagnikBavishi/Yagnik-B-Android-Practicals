package com.example.androidpractical.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import com.example.androidpractical.Models.SharedViewModel
import com.example.androidpractical.R

class AddMessageFragment : Fragment() {

    private var sharedViewModelInstance: SharedViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_add_message, container, false)

        val editTextForBundle: EditText = view.findViewById(R.id.etForBundle)
        val btnBundle: Button = view.findViewById(R.id.btnSendDataUsingBundle)
        val editTextForViewModel: EditText = view.findViewById(R.id.etForViewModel)
        val btnViewModel: Button = view.findViewById(R.id.btnSendDataUsingViewModel)

        btnBundle.setOnClickListener {
            val message: String = editTextForBundle.text.toString()
            val bundle = Bundle().apply {
                if (message.isEmpty()) {
                    Toast.makeText(
                        activity,
                        getString(R.string.second_edit_text),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    putString(getString(R.string.message), message)
                    Toast.makeText(activity, getString(R.string.message_send_sucess), Toast.LENGTH_SHORT)
                        .show()
                }
            }
            setFragmentResult(getString(R.string.key), bundle)
        }

        sharedViewModelInstance =
            ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        btnViewModel.setOnClickListener {
            val message = editTextForViewModel.text
            if (message.isEmpty()) {
                Toast.makeText(
                    activity,
                    getString(R.string.first_text_view),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                sharedViewModelInstance?.setData(message)
                Toast.makeText(activity, getString(R.string.message_send_sucess), Toast.LENGTH_SHORT)
                    .show()
            }
        }
        return view
    }
}