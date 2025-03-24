package com.example.ecomarceapplication.data.repogitoris

import com.example.ecomarceapplication.core.Nodes
import com.example.ecomarceapplication.data.models.UserLogin
import com.example.ecomarceapplication.data.models.UserRegister
import com.example.ecomarceapplication.services.AuthService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class AuthRepository @Inject constructor(private val jAuth: FirebaseAuth, private val db : FirebaseFirestore): AuthService {


    override fun userRegistation(user: UserRegister):Task<AuthResult> {




      return  jAuth.createUserWithEmailAndPassword(user.email,user.password)
    }

    override fun userLogin(user: UserLogin) :Task<AuthResult> {


        return jAuth.signInWithEmailAndPassword(user.email, user.password)
    }

    override fun creatUser(user: UserRegister) : Task<Void> {

   return   db.collection(Nodes.USER).document(user.userID).set(user)

    }
}