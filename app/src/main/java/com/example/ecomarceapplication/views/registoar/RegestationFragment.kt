package com.example.ecomarceapplication.views.registoar

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
import com.example.ecomarceapplication.data.models.UserRegister
import com.example.ecomarceapplication.databinding.FragmentRegestationBinding
import com.example.ecomarceapplication.isEmpty
import com.example.ecomarceapplication.views.dashboard.seller.SellerDashboard
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegestationFragment : BaseFragment<FragmentRegestationBinding>(FragmentRegestationBinding::inflate) {



    private val viewModel : RegistationViewModel by viewModels ()








    override fun setListner() {
        with(binding){

            registraionbtn.setOnClickListener{

                nameEt.isEmpty()
                emailEt.isEmpty()
                passwordEt.isEmpty()


                if (!nameEt.isEmpty() && ! emailEt.isEmpty() && !passwordEt.isEmpty()){

//                    Toast.makeText(context, "All input done !", Toast.LENGTH_LONG).show()
                    val user = UserRegister(
                        nameEt.text.toString(),
                        emailEt.text.toString(),
                        passwordEt.text.toString(),
                        "Seller",
                        ""
                    )

                    viewModel.userRegistation(user)
                }
            }
        }
    }

    override fun allObserver() {
      registrationObserver()
    }

    //OOAD -> object orianted analicys design(coad design)

    fun registrationObserver() {

        viewModel.registrationResponse.observe(viewLifecycleOwner){

            when(it){
                is DataState.Error -> {

                    loading.dismiss()
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading ->{
                    loading.show()
                    Toast.makeText(context, "Loading....", Toast.LENGTH_SHORT).show()
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