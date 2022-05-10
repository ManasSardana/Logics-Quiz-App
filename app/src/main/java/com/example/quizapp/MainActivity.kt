package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Initializing Variables
    private lateinit var mainActivity: ActivityMainBinding
    //Variable for Firebase Authentication
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        auth = FirebaseAuth.getInstance()
        mainActivity = ActivityMainBinding.inflate(layoutInflater)

        /*if(auth.currentUser != null && auth.currentUser!!.isEmailVerified){
            startActivity(Intent(this, MainPage:: class.java))
            finish()
        }*/

        //Inflating to MainActivity
        mainActivity.button.setOnClickListener {
            val email = mainActivity.inputEmail.text.toString()
            val password = mainActivity.inputPassword.text.toString()
            if (email.trim().isNotEmpty() && password.trim().isNotEmpty()) {
                login(email, password)
            } else {
                Snackbar.make(mainActivity.root,
                    "Please enter the credentials !!",
                    Snackbar.LENGTH_LONG).show()
            }
            //activity?.startActivity(Intent(context, MainPage::class.java))
        }

        //Loading Forgot Password Fragment
        /*mainActivity.forgetPassword.setOnClickListener {

        }

        //Loading Registration Fragment
        mainActivity.loginSignUp.setOnClickListener {

        }*/
    }
    private fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    if(user!!.isEmailVerified) {
                        //activity?.startActivity(Intent(context, MainPage:: class.java))
                        //activity?.finish()
                        if(mainActivity.inputName.text.toString().isEmpty())
                        {
                            Toast.makeText(this,"Enter Your Name",Toast.LENGTH_SHORT).show()
                        }
                        else{
                            var intent = Intent(this,QuestionActivity::class.java)
                            intent.putExtra("${setData.name}",mainActivity.inputName.text.toString())
                            startActivity(intent)
                            finish()
                        }
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this, "Please verify the email first !!",
                            Toast.LENGTH_SHORT).show()                    }
                } else {
                    // If sign in fails, display a message to the user.
                    if (task.exception is FirebaseAuthInvalidCredentialsException ||
                        task.exception is FirebaseAuthInvalidUserException
                    ) {
                        Toast.makeText(this, "Invalid Credentials !!",
                            Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Something went wrong, Please try again later !!",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }
}