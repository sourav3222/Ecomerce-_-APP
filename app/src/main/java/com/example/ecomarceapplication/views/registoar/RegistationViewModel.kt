package com.example.ecomarceapplication.views.registoar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecomarceapplication.core.DataState
import com.example.ecomarceapplication.data.models.UserRegister
import com.example.ecomarceapplication.data.repogitoris.AuthRepository
import com.example.ecomarceapplication.services.AuthService

class RegistationViewModel: ViewModel() {

    private val _registrationResponse = MutableLiveData<DataState<UserRegister>>()

    val registrationResponse: LiveData<DataState<UserRegister>> = _registrationResponse




    fun userRegistation(user: UserRegister){


        _registrationResponse.postValue(DataState.Loading())

        val authService = AuthRepository()

        authService.userRegistation(user).
                addOnSuccessListener{

                    _registrationResponse.postValue(DataState.Success(user))

                }.addOnFailureListener{error->

            _registrationResponse.postValue(DataState.Error("${error.message}"))


        }



    }



}