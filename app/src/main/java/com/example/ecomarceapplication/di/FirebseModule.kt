package com.example.ecomarceapplication.di

import com.example.ecomarceapplication.data.repogitoris.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class FirebseModule {



    @Provides
    @Singleton
    fun providesFirebaseAuth() : FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun providesFirebaseFirestoreDB() : FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }


    @Provides
    @Singleton
    fun providesFirebase(jAuth : FirebaseAuth, db : FirebaseFirestore) : AuthRepository{
        return AuthRepository(jAuth, db)
    }
}