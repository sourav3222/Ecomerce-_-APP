package com.example.ecomarceapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ecomarceapplication.base.BaseFragment
import com.example.ecomarceapplication.databinding.FragmentDaseboardBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DaseboardFragment : BaseFragment<FragmentDaseboardBinding>(FragmentDaseboardBinding::inflate) {

@Inject
    lateinit var jAuth : FirebaseAuth


    override fun setListner() {


        with(binding){
            btnLogout.setOnClickListener{

                jAuth.signOut()

                findNavController().navigate(R.id.action_daseboardFragment_to_startFragment)
            }
        }
    }

    override fun allObserver() {

    }


}