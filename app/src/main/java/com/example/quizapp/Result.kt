package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityQuestionBinding
import com.example.quizapp.databinding.ActivityResultBinding

//import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    private lateinit var result: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        result = ActivityResultBinding.inflate(layoutInflater)
        setContentView(result.root)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        val userName=intent.getStringExtra(setData.name)
        val score=intent.getStringExtra(setData.score)
        val totalQuestion=intent.getStringExtra("total size")

        result.congo.text="Congratulations ${userName} !!"
        result.Score.text="${score} / 15"
        result.button.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}