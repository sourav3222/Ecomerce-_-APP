package com.example.ecomarceapplication.data.repogitoris

import com.example.ecomarceapplication.data.models.UserLogin
import com.example.ecomarceapplication.data.models.UserRegister
import com.example.ecomarceapplication.services.AuthService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class AuthRepository: AuthService {


    override fun userRegistation(user: UserRegister):Task<AuthResult> {


        val jAuth = FirebaseAuth.getInstance()

      return  jAuth.createUserWithEmailAndPassword(user.email,user.password)
    }

    override fun userLogin(user: UserLogin) :Task<AuthResult> {
        val jAuth = FirebaseAuth.getInstance()

        return jAuth.signInWithEmailAndPassword(user.email, user.password)
    }
}