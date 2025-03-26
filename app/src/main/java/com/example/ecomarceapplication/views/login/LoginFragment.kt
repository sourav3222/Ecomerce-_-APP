package com.example.ecomarceapplication.views.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ecomarceapplication.R
import com.example.ecomarceapplication.base.BaseFragment
import com.example.ecomarceapplication.core.DataState
import com.example.ecomarceapplication.data.models.UserLogin
import com.example.ecomarceapplication.databinding.FragmentLoginBinding
import com.example.ecomarceapplication.isEmpty
import com.example.ecomarceapplication.views.dashboard.seller.SellerDashboard
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewModel : LoginViewModel by viewModels()




    override fun setListner() {

        with(binding){

            newuserbtn.setOnClickListener{

                findNavController().navigate(R.id.action_loginFragment_to_regestationFragment)
            }


            Loginbtn.setOnClickListener{

                emailEt.isEmpty()
                passwordEt.isEmpty()


                if (!emailEt.isEmpty() && !passwordEt.isEmpty()){

                   Toast.makeText(context, "All input done !", Toast.LENGTH_LONG).show()
                    val user = UserLogin(
                        emailEt.text.toString(),
                        passwordEt.text.toString(),

                        )
                    viewModel.userLogin(user)
                }
            }

        }

    }

    override fun allObserver() {

        viewModel.loginResponse.observe(viewLifecycleOwner){

            when(it){
                is DataState.Error -> {
                    loading.dismiss()
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    loading.show()
//                    Toast.makeText(context, "Loading....", Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {
                    loading.dismiss()
                    Toast.makeText(context, "created User: ${it.data}", Toast.LENGTH_SHORT).show()

                    startActivity(Intent(requireContext(), SellerDashboard ::class.java))

                    requireActivity().finish()

                }
            }
        }

    }


}


