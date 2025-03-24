package com.example.ecomarceapplication.views.registoar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecomarceapplication.core.DataState
import com.example.ecomarceapplication.data.models.UserRegister
import com.example.ecomarceapplication.data.repogitoris.AuthRepository
import com.example.ecomarceapplication.services.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RegistationViewModel @Inject constructor(val authService: AuthRepository): ViewModel() {

    private val _registrationResponse = MutableLiveData<DataState<UserRegister>>()

    val registrationResponse: LiveData<DataState<UserRegister>> = _registrationResponse




    fun userRegistation(user: UserRegister){


        _registrationResponse.postValue(DataState.Loading())



        authService.userRegistation(user).
                addOnSuccessListener{

                    it.user?.let { createdUser->

                        user.userID = createdUser.uid



                        authService.creatUser(user).addOnSuccessListener{

                            _registrationResponse.postValue(DataState.Success(user))

                        }.addOnFailureListener{ error->

                            _registrationResponse.postValue(DataState.Error("${error.message}"))


                        }

                    }



                }.addOnFailureListener{error->

            _registrationResponse.postValue(DataState.Error("${error.message}"))


        }



    }



}