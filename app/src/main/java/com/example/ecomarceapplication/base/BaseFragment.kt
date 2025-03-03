package com.example.ecomarceapplication.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

@Suppress("DEPRECATION")
abstract class BaseFragment <VB : ViewBinding>(

    private val bindingInflater : (inflater : LayoutInflater) -> VB // higher odear function

) : Fragment() {


    private var _binding : VB? = null

    val binding :VB
        get() = _binding as VB


lateinit var loading: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = bindingInflater.invoke(inflater)

        loading = ProgressDialog(requireContext())


        setListner()
        allObserver()

        return binding.root
    }

    abstract fun setListner()
    abstract fun allObserver()
}