package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityForgotPasswordBinding
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityRegisterationBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var ForgotPasswordActivity: ActivityForgotPasswordBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ForgotPasswordActivity = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(ForgotPasswordActivity.root)
        auth = FirebaseAuth.getInstance()

        //Sending Password reset email
        ForgotPasswordActivity.forgotButton.setOnClickListener {
            val email = ForgotPasswordActivity.forgotEmail.text.toString()
            if (email.trim().isNotEmpty()){
                val eMail = ForgotPasswordActivity.forgotEmail.text.toString()
                //auth = Firebase.auth
                auth.sendPasswordResetEmail(eMail)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Snackbar.make(ForgotPasswordActivity.root,
                                "Password Reset Link Send to your Email !!",
                                Snackbar.LENGTH_LONG).show()
                        } else {
                            if (task.exception is FirebaseAuthInvalidCredentialsException ||
                                task.exception is FirebaseAuthInvalidUserException
                            ){
                                Snackbar.make(ForgotPasswordActivity.root,
                                    "Invalid Credentials !!",
                                    Snackbar.LENGTH_LONG).show()
                            } else {
                                Snackbar.make(ForgotPasswordActivity.root,
                                    "Something went wrong, Please try again later !!",
                                    Snackbar.LENGTH_LONG).show()
                            }
                        }
                    }
            } else {
                Snackbar.make(ForgotPasswordActivity.root,
                    "Please enter the credentials !!",
                    Snackbar.LENGTH_LONG).show()
            }
        }

        //Loading Login Fragment
        ForgotPasswordActivity.forgotRememberPassword.setOnClickListener {
            startActivity(Intent(this,MainActivity :: class.java))
        }

        //Loading Registration Fragment
        ForgotPasswordActivity.forgotSignUp.setOnClickListener {
            startActivity(Intent(this,RegistrationActivity :: class.java))
        }

    }
}