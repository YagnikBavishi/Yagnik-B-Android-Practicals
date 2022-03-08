package com.example.androidpractical.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import com.example.androidpractical.Models.SharedViewModel
import com.example.androidpractical.R

class ViewMessageFragment : Fragment() {

    private var sharedViewModelInstance: SharedViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_view_message, container, false)
        val textViewForBundle: TextView = view.findViewById(R.id.textViewForBundle)
        val textViewForViewModel: TextView = view.findViewById(R.id.textViewForViewModel)


        setFragmentResultListener(getString(R.string.key)) { _, bundle ->
            val message: String = bundle.getString(getString(R.string.message), "")
            textViewForBundle.text = message
        }

        sharedViewModelInstance =
            ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        sharedViewModelInstance!!.getData().observe(viewLifecycleOwner, {
            textViewForViewModel.text = it as Editable?
        })

        return view
    }
}