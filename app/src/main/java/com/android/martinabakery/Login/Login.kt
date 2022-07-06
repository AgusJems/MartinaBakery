package com.android.martinabakery.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.martinabakery.MainActivity
import com.android.martinabakery.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private var email =""
    private var password =""
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        checkUser()

        binding.btnLogin.setOnClickListener{
            validateData()
        }
    }

    private fun validateData() {
        email = binding.etEmail.text.toString().trim()
        password = binding.etPassword.text.toString().trim()

        if (password.isEmpty()) {
            binding.etPassword.error = "Please Enter Password"
        }else if (email.matches(emailPattern.toRegex())){
            binding.etEmail.error = "Invalid Email Address"
        }else{
            firebaseLogin()
        }
    }

    private fun firebaseLogin() {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                val firebaseUser = auth.currentUser
                val email = firebaseUser!!.email
            }
    }

    private fun checkUser() {
        val firebaseUser = auth.currentUser
        if (firebaseUser != null) {
            startActivity(Intent(this, MainActivity:: class.java))
            finish()
        }
    }
}