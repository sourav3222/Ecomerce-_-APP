package com.example.ecomarceapplication.services

import com.example.ecomarceapplication.data.models.UserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthService {

    fun userRegistation(user: UserRegister): Task<AuthResult>
}