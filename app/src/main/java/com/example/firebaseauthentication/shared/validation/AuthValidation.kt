package com.example.firebaseauthentication.shared.validation

object AuthValidation {

    fun validateEmail(email : String) : String? = when{
        email.isBlank() -> "Email cannot be empty"
        !email.contains("@") -> "Invalid email"
        else -> null
    }

    fun validatePassword(password : String) : String? = when{
        password.isBlank() -> "Password cannot be empty"
        password.length < 6 -> "Password must be at least 6 characters"
        else -> null
    }

    fun validateConfirmPassword(password: String,confirmPassword : String) : String? =
        if (password != confirmPassword) "password does not match" else null
}