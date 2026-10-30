package com.example.firebaseauthentication.model.result

import com.google.firebase.auth.FirebaseAuth

sealed interface AuthResult {
    data class Success(val user : FirebaseAuth) : AuthResult
    data class Failure(val message : String) : AuthResult
}