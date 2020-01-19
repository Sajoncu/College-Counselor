package com.example.collegecounselor


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.collegecounselor.databinding.FragmentGamePlayBinding
import kotlinx.android.synthetic.main.fragment_game_play.*
import java.lang.Exception
import java.util.*
import androidx.databinding.adapters.TextViewBindingAdapter.setText



/**
 * A simple [Fragment] subclass.
 */
class GamePlayFragment : Fragment() {

    data class Question(
        val text: String,
        val answers: List<String>,
        val level: String
    )

    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "What is Android Jetpack?",
            answers = listOf("all of these", "tools", "documentation", "libraries"),
            level="1"
        ),
        Question(
            text = "Base class for Layout?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot"),
            level="1"
        ),
        Question(
            text = "Layout for complex Screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout"),
            level="1"
        ),
        Question(
            text = "Pushing structured data into a Layout?",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick"),
            level="1"
        ),
        Question(
            text = "Inflate layout in fragments?",
            answers = listOf(
                "onCreateView",
                "onActivityCreated",
                "onCreateLayout",
                "onInflateLayout"
            ),
            level="1"
        ),
        Question(
            text = "Build system for Android?",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle"),
            level="1"
        ),
        Question(
            text = "Android vector format?",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector"),
            level="1"
        ),
        Question(
            text = "Android Navigation Component?",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher"),
            level="1"
        ),
        Question(
            text = "Registers app with launcher?",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher"),
            level="1"
        ),
        Question(
            text = "Mark a layout for Data Binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"),
            level="1"
        )
    )
    private val medium: MutableList<Question> = mutableListOf(
        Question(
            text = "What is Android Jetpack? M",
            answers = listOf("all of these", "tools", "documentation", "libraries"),
            level="2"
        ),
        Question(
            text = "Base class for Layout? M",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot"),
            level="2"
        ),
        Question(
            text = "Layout for complex Screens? M",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout"),
            level="2"
        ),
        Question(
            text = "Pushing structured data into a Layout? M",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick"),
            level="2"
        ),
        Question(
            text = "Inflate layout in fragments? M",
            answers = listOf(
                "onCreateView",
                "onActivityCreated",
                "onCreateLayout",
                "onInflateLayout"
            ),
            level="1"
        ),
        Question(
            text = "Build system for Android? M",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle"),
            level="1"
        ),
        Question(
            text = "Android vector format?",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector"),
            level="1"
        ),
        Question(
            text = "Android Navigation Component? M",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher"),
            level="1"
        ),
        Question(
            text = "Registers app with launcher? M",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher"),
            level="1"
        ),
        Question(
            text = "Mark a layout for Data Binding? M",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"),
            level="1"
        )
    )
    private val hard: MutableList<Question> = mutableListOf(
        Question(
            text = "What is Android Jetpack? hard",
            answers = listOf("all of these", "tools", "documentation", "libraries"),
            level="1"
        ),
        Question(
            text = "Base class for Layout? hard",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot"),
            level="1"
        ),
        Question(
            text = "Layout for complex Screens? hard",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout"),
            level="1"
        ),
        Question(
            text = "Pushing structured data into a Layout? hard",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick"),
            level="1"
        ),
        Question(
            text = "Inflate layout in fragments? hard",
            answers = listOf(
                "onCreateView",
                "onActivityCreated",
                "onCreateLayout",
                "onInflateLayout"
            ),
            level="1"
        ),
        Question(
            text = "Build system for Android? hard",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle"),
            level="1"
        ),
        Question(
            text = "Android vector format? hard",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector"),
            level="1"
        ),
        Question(
            text = "Android Navigation Component? hard",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher"),
            level="1"
        ),
        Question(
            text = "Registers app with launcher? hard",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher"),
            level="1"
        ),
        Question(
            text = "Mark a layout for Data Binding? hard",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"),
            level="1"
        )
    )
    private val extrahard: MutableList<Question> = mutableListOf(
        Question(
            text = "What is Android Jetpack? hard",
            answers = listOf("all of these", "tools", "documentation", "libraries"),
            level="1"
        ),
        Question(
            text = "Base class for Layout? hard",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot"),
            level="1"
        ),
        Question(
            text = "Layout for complex Screens? hard",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout"),
            level="1"
        ),
        Question(
            text = "Pushing structured data into a Layout? hard",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick"),
            level="1"
        ),
        Question(
            text = "Inflate layout in fragments? hard",
            answers = listOf(
                "onCreateView",
                "onActivityCreated",
                "onCreateLayout",
                "onInflateLayout"
            ),
            level="1"
        ),
        Question(
            text = "Build system for Android? hard",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle"),
            level="1"
        ),
        Question(
            text = "Android vector format? hard",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector"),
            level="1"
        ),
        Question(
            text = "Android Navigation Component? hard",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher"),
            level="1"
        ),
        Question(
            text = "Registers app with launcher? hard",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher"),
            level="1"
        ),
        Question(
            text = "Mark a layout for Data Binding? hard",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"),
            level="1"
        )
    )

    lateinit var binding: FragmentGamePlayBinding
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    lateinit var levelWizeQuestion: MutableList<Question>
    var level = ""
    var maxNumberOfQuestion: Int = 5
    var questionIndex = 0
    var score = 0

    private val COUNTDOWN_IN_MILLIS:Long = 10000

    lateinit var countDownTimer: CountDownTimer
    var timeLeftInMillis:Long = 0



    private fun setQuestion(){
        binding.textView2.text = "Score: "+score
        binding.textView.text = "${questionIndex+1}"+"/"+maxNumberOfQuestion+"\n"+"Questions"
        currentQuestion = levelWizeQuestion[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()

        //startProgress()
//        timeLeftInMillis = COUNTDOWN_IN_MILLIS
//        startCountDown()
    }

//    private fun startCountDown(){
//        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
//
//            override fun onTick(millisUntilFinished: Long) {
//                timeLeftInMillis = millisUntilFinished
//                updateCountDownText()
//            }
//
//            override fun onFinish() {
//                timeLeftInMillis = 0
//                updateCountDownText()
//            }
//        }
//        countDownTimer.start()
//
//    }
//    private fun updateCountDownText(){
//        var minutes:Int = ((timeLeftInMillis/1000)/60).toInt()
//        var seconds = ((timeLeftInMillis/1000)%60).toInt()
//
//        textView5.text = minutes.toString()+":"+seconds.toString()
//    }
//    private fun startProgress(){
//        var count:Int = 0
//        val timer = Timer()
//
//        timer.schedule(object:TimerTask(){
//            override fun run() {
//                count++
//                progressBar.progress = count
//
//                if (count > 100){
//                    //change question
//                    progressBar.progress = 0
//                    setQuestion()
//                }
//            }
//        },0, 100)
//    }

    private fun randomizeQuestion(){
        //questions.shuffle()
        levelWizeQuestion.shuffle()
        questionIndex = 0
        setQuestion()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game_play, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_play, container, false)
        val args = GamePlayFragmentArgs.fromBundle(arguments!!)
        level = args.level
        binding.button5.text = "Level "+level
        selectQuestionAccordingToLevel()
        randomizeQuestion()

        binding.game = this
        return binding.root
    }

    private fun selectQuestionAccordingToLevel(){
        if(level == "1"){
            levelWizeQuestion = questions
        }
        else if(level == "2"){
            levelWizeQuestion = medium
        }
        else if(level == "3"){
            levelWizeQuestion = hard
        }
        else if(level == "4"){
            levelWizeQuestion = extrahard
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        option1.setOnClickListener{
            checkAnswer(option1.text.toString())
        }

        option2.setOnClickListener{
            checkAnswer(option2.text.toString())
        }

        option3.setOnClickListener{
            checkAnswer(option3.text.toString())
        }

        option4.setOnClickListener{
            checkAnswer(option4.text.toString())
        }
    }


    private fun checkAnswer(answer:String){

        if(answer.equals(currentQuestion.answers[0])){
            score++
        }
        else{
            //wrongAnswerList.add(currentQuestion.theQuestion)
        }

        questionIndex++
        if(questionIndex<=maxNumberOfQuestion-1){
            setQuestion()
            binding.invalidateAll()
        }
        else{
            getScore()
        }
    }



    private fun getScore() = if(score>=3){
        val sharedPreference = this.activity!!.getSharedPreferences("sp", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        var l: String? = sharedPreference.getString("CURRENT_LEVEL","1")

        if(l == "1"){
            editor.putString("CURRENT_LEVEL", "2")
            editor.putBoolean("LEVEL_2", true)
            editor.commit()
        } else if(l == "2"){
            editor.putString("CURRENT_LEVEL", "3")
            editor.putBoolean("LEVEL_3", true)
            editor.commit()
        } else if(l == "3"){
            editor.putString("CURRENT_LEVEL", "4")
            editor.putBoolean("LEVEL_4", true)
            editor.commit()
        }
        //val action = QuizFragmentDirections.actionQuizFragment3ToQuizWonFragment(score,wrongAnswerList.toTypedArray())
        //view!!.findNavController().navigate(action)
        Toast.makeText(context, "You answered "+score+" out of "+maxNumberOfQuestion+"questions", Toast.LENGTH_SHORT).show()
    }
    else{
        //val action = QuizFragmentDirections.actionQuizFragment3ToQuizLostFragment(score,wrongAnswerList.toTypedArray())
        //view!!.findNavController().navigate(action)
        Toast.makeText(context, "You answered "+score+" out of "+maxNumberOfQuestion+"questions", Toast.LENGTH_SHORT).show()
    }
}
