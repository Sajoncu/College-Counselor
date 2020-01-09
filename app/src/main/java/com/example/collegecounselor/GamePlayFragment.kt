package com.example.collegecounselor


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.collegecounselor.databinding.FragmentGamePlayBinding
import kotlinx.android.synthetic.main.fragment_game_play.*

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

    lateinit var binding: FragmentGamePlayBinding
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    lateinit var levelWizeQuestion: MutableList<Question>
    var maxNumberOfQuestion: Int = 5
    var questionIndex = 0
    var score = 0


    private fun setQuestion(){
        binding.textView2.text = "Score: "+score
        binding.textView.text = "${questionIndex+1}"+"/"+maxNumberOfQuestion+"\n"+"Questions"
        currentQuestion = questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
    }

    private fun randomizeQuestion(){
        questions.shuffle()
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

        randomizeQuestion()
        binding.game = this

        return binding.root
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

    private fun getScore(){
        if(score>=2){
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
}
