package com.example.ecomarceapplication.views.stater

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ecomarceapplication.R
import com.example.ecomarceapplication.base.BaseFragment
import com.example.ecomarceapplication.databinding.FragmentStartBinding

class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {






    override fun setListner() {
        with(binding){

            Loginbtn.setOnClickListener{

                findNavController().navigate(R.id.action_startFragment_to_loginFragment)
            }

            Registerbtn.setOnClickListener{
                findNavController().navigate(R.id.action_startFragment_to_regestationFragment)
            }



        }
    }

    override fun allObserver() {

    }


}