package com.example.firebaseauthentication.shared.extension

import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

fun Exception.toAutoMessage(): String {
    return when (this) {
        is FirebaseAuthUserCollisionException ->
            "An account already exists for this email"

        is FirebaseAuthWeakPasswordException ->
            "Password should be at least 6 characters"

        is FirebaseAuthInvalidCredentialsException ->
            "Invalid email or password"

        is FirebaseAuthInvalidUserException ->
            "No account found for this email"

        is FirebaseAuthException ->
            when (errorCode) {
                "ERROR_NETWORK_REQUEST_FAILED" ->
                    "Network error. Please check your connection."

                "ERROR_TOO_MANY_REQUESTS" ->
                    "Too many attempts. Please try again later."

                else -> message ?: "Authentication failed."
            }

        is FirebaseException ->
            message ?: "Authentication failed."

        else -> message ?: "Something went wrong. Please try again."
    }
}