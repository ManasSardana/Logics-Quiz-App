package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*
import kotlin.random.Random


class QuestionActivity : AppCompatActivity() {

    private var Name: String? = null
    private var score: Int = 0
    private var maxQue: Int = 1
    private var counterDown: CountDownTimer? = null
    private var timeLeft: Long = -1
    private var currentPosition: Int = 1
    private var questionList: ArrayList<QuestionData>? = setData.getQuestion()
    private var selecedOption: Int = 0
    private var question = questionList!![currentPosition-1]
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Name = intent.getStringExtra(setData.name)

        questionList = setData.getQuestion()

        setQuestion()

        opt_1.setOnClickListener {

            selectedOptionStyle(opt_1, 1)
        }
        opt_2.setOnClickListener {

            selectedOptionStyle(opt_2, 2)
        }
        opt_3.setOnClickListener {

            selectedOptionStyle(opt_3, 3)
        }
        opt_4.setOnClickListener {

            selectedOptionStyle(opt_4, 4)
        }

        submit.setOnClickListener {
            if (selecedOption != 0) {
                //val question = questionList!![currentPosition - 1]
                if (selecedOption != question.correct_ans) {
                    setColor(selecedOption, R.drawable.wrong_question_option)
                } else {
                    score++;
                }
                setColor(question.correct_ans, R.drawable.correct_question_option)
                if (currentPosition == 15/*questionList!!.size*/){
                    submit.text = "FINISH"
                    if (counterDown != null || counterDown == null) {
                        counterDown!!.cancel()
                    }
                } else {
                    submit.text = "Go to Next"
                    if (counterDown != null || counterDown == null) {
                        counterDown!!.cancel()
                    }
                }
            } else {
                when {
                    currentPosition <= 15/*questionList!!.size*/ -> {
                        if (counterDown != null || counterDown == null) {
                            counterDown!!.cancel()
                        }
                        setQuestion()
                        //showTimer()
                    }
                    else -> {
                        var intent = Intent(this, Result::class.java)
                        intent.putExtra(setData.name, Name.toString())
                        intent.putExtra(setData.score, score.toString())
                        intent.putExtra("total size", 15/*questionList!!.size.toString()*/)

                        startActivity(intent)
                        finish()
                    }
                }
            }
            selecedOption = 0
        }

    }

    fun setColor(opt: Int, color: Int) {
        when (opt) {
            1 -> {
                opt_1.background = ContextCompat.getDrawable(this, color)
            }
            2 -> {
                opt_2.background = ContextCompat.getDrawable(this, color)
            }
            3 -> {
                opt_3.background = ContextCompat.getDrawable(this, color)
            }
            4 -> {
                opt_4.background = ContextCompat.getDrawable(this, color)
            }
        }
    }


    fun setQuestion() {
        showTimer()
        questionList!!.shuffle()
        //val queNo = Random.nextInt(35) + 1
        question = questionList!![currentPosition-1]
        //val question = questionList!![queNo-1]

        val number = ArrayList<Int>()
        for (i in 1..15){
            number.add(i)
        }

        setOptionStyle()

        progress_bar.progress = currentPosition
        progress_bar.max = 15 //questionList!!.size
        progress_text.text = "${currentPosition}" + "/" + "${15}"
        question_text.text = question.question
        opt_1.text = question.option_one
        opt_2.text = question.option_tw0
        opt_3.text = question.option_three
        opt_4.text = question.option_four
        currentPosition++
        maxQue++
    }

    fun setOptionStyle() {
        var optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(0, opt_1)
        optionList.add(1, opt_2)
        optionList.add(2, opt_3)
        optionList.add(3, opt_4)

        for (op in optionList) {
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.question_option)
            op.typeface = Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view: TextView, opt: Int) {

        setOptionStyle()
        selecedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))

    }
    private fun showTimer(){
        // QuestionActivity.reSend.isEnabled = false
        counterDown = object : CountDownTimer(30000,1000){
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished
                //  QuestionActivity.counter.isVisible = true
                val counter = findViewById<TextView>(R.id.counter)
                counter.text = getString(
                    R.string.seconds_remaining,millisUntilFinished / 1000
                )
            }

            override fun onFinish() {
            //    QuestionActivity.resend.isEnabled = true
            //    QuestionActivity.resend.isVisible = false
                if (maxQue <= 15) {
                    if(currentPosition <= 15) {
                        if (counterDown != null || counterDown == null) {
                            counterDown!!.cancel()
                            showTimer()
                        }
                        setQuestion()
                    }
                }
            }
        }.start()
    }

}