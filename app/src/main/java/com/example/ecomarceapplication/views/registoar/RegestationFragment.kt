package com.example.ecomarceapplication.views.registoar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecomarceapplication.R
import com.example.ecomarceapplication.databinding.FragmentRegestationBinding
import com.example.ecomarceapplication.isEmpty

class RegestationFragment : Fragment() {
    lateinit var binding: FragmentRegestationBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegestationBinding.inflate(inflater,container,false)

        setListner()
        return binding.root
    }

    private fun setListner() {
        with(binding){

            registraionbtn.setOnClickListener{

                nameEt.isEmpty()
                emailEt.isEmpty()
                passwordEt.isEmpty()
            }
        }
    }


}