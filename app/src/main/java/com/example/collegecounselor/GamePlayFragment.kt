package com.example.collegecounselor


import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.lockeddialog.view.*


/**
 * A simple [Fragment] subclass.
 */
class GamePlayFragment : Fragment() {

    data class Question(
        val text: String,
        val answers: List<String>
    )

    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "What is Android Jetpack?",
            answers = listOf("all of these", "tools", "documentation", "libraries")
        ),
        Question(
            text = "Base class for Layout?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
        ),
        Question(
            text = "Layout for complex Screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
        ),
        Question(
            text = "Pushing structured data into a Layout?",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")
        ),
        Question(
            text = "Inflate layout in fragments?",
            answers = listOf(
                "onCreateView",
                "onActivityCreated",
                "onCreateLayout",
                "onInflateLayout"
            )
        ),
        Question(
            text = "Build system for Android?",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
        ),
        Question(
            text = "Android vector format?",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector")
        ),
        Question(
            text = "Android Navigation Component?",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
        ),
        Question(
            text = "Registers app with launcher?",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
        ),
        Question(
            text = "Mark a layout for Data Binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
        )
    )
    private val medium: MutableList<Question> = mutableListOf(
        Question(
            text = "What is Android Jetpack? M",
            answers = listOf("all of these", "tools", "documentation", "libraries")
        ),
        Question(
            text = "Base class for Layout? M",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
        ),
        Question(
            text = "Layout for complex Screens? M",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
        ),
        Question(
            text = "Pushing structured data into a Layout? M",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")
        ),
        Question(
            text = "Inflate layout in fragments? M",
            answers = listOf(
                "onCreateView",
                "onActivityCreated",
                "onCreateLayout",
                "onInflateLayout"
            )
        ),
        Question(
            text = "Build system for Android? M",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
        ),
        Question(
            text = "Android vector format?",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector")
        ),
        Question(
            text = "Android Navigation Component? M",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
        ),
        Question(
            text = "Registers app with launcher? M",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
        ),
        Question(
            text = "Mark a layout for Data Binding? M",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
        )
    )
    private val hard: MutableList<Question> = mutableListOf(
        Question(
            text = "What is Android Jetpack? hard",
            answers = listOf("all of these", "tools", "documentation", "libraries")
        ),
        Question(
            text = "Base class for Layout? hard",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
        ),
        Question(
            text = "Layout for complex Screens? hard",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
        ),
        Question(
            text = "Pushing structured data into a Layout? hard",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")
        ),
        Question(
            text = "Inflate layout in fragments? hard",
            answers = listOf(
                "onCreateView",
                "onActivityCreated",
                "onCreateLayout",
                "onInflateLayout"
            )
        ),
        Question(
            text = "Build system for Android? hard",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
        ),
        Question(
            text = "Android vector format? hard",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector")
        ),
        Question(
            text = "Android Navigation Component? hard",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
        ),
        Question(
            text = "Registers app with launcher? hard",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
        ),
        Question(
            text = "Mark a layout for Data Binding? hard",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
        )
    )
    private val extrahard: MutableList<Question> = mutableListOf(
        Question(
            text = "What is Android Jetpack? hard",
            answers = listOf("all of these", "tools", "documentation", "libraries")
        ),
        Question(
            text = "Base class for Layout? hard",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
        ),
        Question(
            text = "Layout for complex Screens? hard",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
        ),
        Question(
            text = "Pushing structured data into a Layout? hard",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")
        ),
        Question(
            text = "Inflate layout in fragments? hard",
            answers = listOf(
                "onCreateView",
                "onActivityCreated",
                "onCreateLayout",
                "onInflateLayout"
            )
        ),
        Question(
            text = "Build system for Android? hard",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
        ),
        Question(
            text = "Android vector format? hard",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector")
        ),
        Question(
            text = "Android Navigation Component? hard",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
        ),
        Question(
            text = "Registers app with launcher? hard",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
        ),
        Question(
            text = "Mark a layout for Data Binding? hard",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
        )
    )

    lateinit var binding: FragmentGamePlayBinding
    lateinit var currentQuestion: Question
    lateinit var answerss: MutableList<String>
    lateinit var levelWizeQuestion: MutableList<Question>
    lateinit var sharedPreference: SharedPreferences
    var level = ""
    var maxNumberOfQuestion: Int = 10
    var questionIndex = 0
    var score = 0

    private val COUNTDOWN_IN_MILLIS:Long = 10000

    lateinit var countDownTimer: CountDownTimer
    var timeLeftInMillis:Long = 0



    private fun setQuestion(){

        binding.option1.setBackgroundResource(R.drawable.buttonbg)
        binding.option2.setBackgroundResource(R.drawable.buttonbg)
        binding.option3.setBackgroundResource(R.drawable.buttonbg)
        binding.option4.setBackgroundResource(R.drawable.buttonbg)


        binding.textView.text = "${questionIndex+1}"+"/"+maxNumberOfQuestion+"\n"+"Questions"
        currentQuestion = levelWizeQuestion[questionIndex]
        answerss = currentQuestion.answers.toMutableList()
        answerss.shuffle()


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

        //TODO: these lines of code for catching the current level
        val args = GamePlayFragmentArgs.fromBundle(arguments!!)
        level = args.level
        binding.button5.text = "Level "+level

        //TODO: this will initialize the score value according to level
        //initializeScore()


        //TODO: this will initialize question according to level
        selectQuestionAccordingToLevel()

        //TODO: this method is for shuffle question
        randomizeQuestion()

        //TODO: statement for passing reference to the layout using data binding
        binding.game = this

        return binding.root
    }

//    private fun initializeScore(){
//        sharedPreference = activity!!.getSharedPreferences("sp", Context.MODE_PRIVATE)
//        if(level == "1"){
//            score = sharedPreference.getInt("L_1_HS",0)
//        }
//        if (level == "2"){
//            score = sharedPreference.getInt("L_2_HS",0)
//        }
//        if(level == "3"){
//            score = sharedPreference.getInt("L_3_HS",0)
//        }
//        if(level == "4"){
//            score = sharedPreference.getInt("L_4_HS",0)
//        }
//    }

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

        //TODO: this listener method is used for skiping the current question and go next question
        skip.setOnClickListener{
            if(questionIndex>=maxNumberOfQuestion-1){
                getScore()
            }else{
                questionIndex++
                setQuestion()
                binding.invalidateAll()
            }
        }

        //TODO: this listener is for giving a hint to the user
        hint.setOnClickListener{
            this.score -= 30
            binding.textView2.text = "Score: "+score
            updateAnswerInterface()
        }

        sharedPreference = activity!!.getSharedPreferences("sp", Context.MODE_PRIVATE)
    }

    private fun updateAnswerInterface(){
        if(currentQuestion.answers[2] == option1.text || currentQuestion.answers[3] == option1.text){
            option1.setBackgroundResource(R.drawable.bggooglesignin)
        }

        if(currentQuestion.answers[2] == option2.text || currentQuestion.answers[3] == option2.text){
            option2.setBackgroundResource(R.drawable.bggooglesignin)
        }

        if(currentQuestion.answers[2] == option3.text || currentQuestion.answers[3] == option3.text){
            option3.setBackgroundResource(R.drawable.bggooglesignin)
        }

        if(currentQuestion.answers[2] == option4.text || currentQuestion.answers[3] == option4.text){
            option4.setBackgroundResource(R.drawable.bggooglesignin)
        }
    }

    private fun checkAnswer(answer:String) {
        if (questionIndex <= maxNumberOfQuestion - 1){
            if (answer.equals(currentQuestion.answers[0])) {
                score += 75
            } else {
                //wrongAnswerList.add(currentQuestion.theQuestion)
            }
        }
        questionIndex++
        if(questionIndex<=maxNumberOfQuestion-1){
            setQuestion()
            binding.invalidateAll()
        }
        else{
            getScore()
        }

        binding.textView2.text = "Score: "+score
    }



    private fun getScore(){
        var heightScore = sharedPreference.getInt("HEIGHTSCORE", 0)
        var editor = sharedPreference.edit()
        if(score>heightScore){

            editor.putInt("HEIGHTSCORE", score)
        }

        if(level == "1"){
            if(score>=0 && score>=750){
                editor.putInt("CURRENT_LEVEL", 2)
                editor.putInt("L_1_HS",score)
                editor.putBoolean("LEVEL_2", true)
                editor.putBoolean("LEVEL_3", false)
                editor.putBoolean("LEVEL_4", false)
                editor.commit()
                createDialogForLevelLocked()
            }
        }
        if(level == "2") {
            if (score >= 0 && score >= 750) {
                editor.putInt("CURRENT_LEVEL", 3)
                editor.putInt("L_2_HS", score)
                editor.putBoolean("LEVEL_1", true)
                editor.putBoolean("LEVEL_2", true)
                editor.putBoolean("LEVEL_3", true)
                editor.putBoolean("LEVEL_4", false)
                editor.commit()
                createDialogForLevelLocked()
            }
        }

        if(level == "3") {
            if (score >= 0 && score >= 750) {
                editor.putInt("CURRENT_LEVEL", 4)
                editor.putInt("L_3_HS", score)
                editor.putBoolean("LEVEL_1", true)
                editor.putBoolean("LEVEL_2", true)
                editor.putBoolean("LEVEL_3", true)
                editor.putBoolean("LEVEL_4", true)
                editor.commit()
                createDialogForLevelLocked()
            }
        }

        if(level == "4"){

            Toast.makeText(activity, "You unlock all the level", Toast.LENGTH_SHORT).show()

            if (score >= 0 && score >= 750) {
                editor.putInt("L_4_HS",score)
                editor.commit()
            }
        }
    }

    private fun createDialogForLevelLocked(){
        val mDialogView = LayoutInflater.from(activity).inflate(R.layout.congratulation, null)
        val mBuilder = AlertDialog.Builder(activity)
            .setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        mDialogView.btnOk.setOnClickListener{
            mAlertDialog.dismiss()
            //val action = QuizFragmentDirections.actionQuizFragment3ToQuizWonFragment(score,wrongAnswerList.toTypedArray())
            //view!!.findNavController().navigate(action)
            Navigation.findNavController(view!!).navigate(R.id.action_gamePlayFragment_to_lavelFragment)
        }
    }
}
