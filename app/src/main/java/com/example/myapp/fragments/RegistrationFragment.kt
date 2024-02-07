package com.example.myapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.myapp.R


class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_registration, container, false)

        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        val button = view.findViewById<Button>(R.id.productButton)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_productFragment)
        }
        return view
    }

}