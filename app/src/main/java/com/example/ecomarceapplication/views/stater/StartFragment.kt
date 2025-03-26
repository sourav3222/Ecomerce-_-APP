package com.example.ecomarceapplication.views.stater

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ecomarceapplication.R
import com.example.ecomarceapplication.base.BaseFragment
import com.example.ecomarceapplication.databinding.FragmentStartBinding
import com.example.ecomarceapplication.views.dashboard.seller.SellerDashboard
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate) {






    override fun setListner() {
        setUpAutoLogin()

        with(binding){

            Loginbtn.setOnClickListener{

                findNavController().navigate(R.id.action_startFragment_to_loginFragment)
            }

            Registerbtn.setOnClickListener{
                findNavController().navigate(R.id.action_startFragment_to_regestationFragment)
            }



        }
    }

    private fun setUpAutoLogin() {

        FirebaseAuth.getInstance().currentUser?.let {

           startActivity(Intent(requireContext(), SellerDashboard ::class.java))

            requireActivity().finish()

        }
    }

    override fun allObserver() {

    }


}