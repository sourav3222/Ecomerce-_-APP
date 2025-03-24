package com.example.ecomarceapplication.views.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecomarceapplication.core.DataState
import com.example.ecomarceapplication.data.models.UserLogin
import com.example.ecomarceapplication.data.models.UserRegister
import com.example.ecomarceapplication.data.repogitoris.AuthRepository
import com.example.ecomarceapplication.services.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(val authService: AuthRepository): ViewModel() {

    private val _loginResponse = MutableLiveData<DataState<UserLogin>>()

    val loginResponse: LiveData<DataState<UserLogin>> = _loginResponse




    fun userLogin(user: UserLogin){


        _loginResponse.postValue(DataState.Loading())



        authService.userLogin(user).
                addOnSuccessListener{

                    _loginResponse.postValue(DataState.Success(user))

                }.addOnFailureListener{error->

            _loginResponse.postValue(DataState.Error("${error.message}"))


        }



    }



}