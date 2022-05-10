package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityRegisterationBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class RegistrationActivity : AppCompatActivity() {
    private lateinit var registrationActivity: ActivityRegisterationBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeration)
        auth = FirebaseAuth.getInstance()
        registrationActivity = ActivityRegisterationBinding.inflate(layoutInflater)

        //Registering the user
        registrationActivity.signUp.setOnClickListener {
            val email = registrationActivity.regEmail.text.toString()
            val password = registrationActivity.regPass.text.toString()
            val confirmPassword = registrationActivity.regConfPass.text.toString()
            if(email.trim().isNotEmpty() && password.trim().isNotEmpty()
                && confirmPassword.trim().isNotEmpty()){
                if(password == confirmPassword){
                    createAccount(email, confirmPassword)
                } else {
                    Snackbar.make(registrationActivity.root,
                        "Password Mismatch !!",
                        Snackbar.LENGTH_LONG).show()
                }
            } else {
                Snackbar.make(registrationActivity.root,
                    "Please enter the credentials !!",
                    Snackbar.LENGTH_LONG).show()
            }
        }
    }
    private fun createAccount(email: String, confirmPassword: String) {
        auth.createUserWithEmailAndPassword(email, confirmPassword).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                val user = auth.currentUser
                user!!.sendEmailVerification()
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this,
                                "Please Check Your Email for verification to Complete Your Registration.",
                                Toast.LENGTH_LONG).show()
                            startActivity(Intent(this,QuestionActivity :: class.java))
                        } else {
                            // If sign in fails, display a message to the user
                            if (task.exception is FirebaseAuthUserCollisionException) {
                                Toast.makeText(this, "User already registered.", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
            } else {
                // If sign in fails, display a message to the user
                if (task.exception is FirebaseAuthWeakPasswordException){
                    Toast.makeText(this, "Weak Password. Please use both alphabet and number !!"
                        , Toast.LENGTH_LONG).show()
                } else{
                    Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}