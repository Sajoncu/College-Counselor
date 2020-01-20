package com.example.collegecounselor


import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.collegecounselor.databinding.FragmentLavelBinding
import kotlinx.android.synthetic.main.fragment_lavel.*
import kotlinx.android.synthetic.main.lockeddialog.view.*

/**
 * A simple [Fragment] subclass.
 */
class LavelFragment : Fragment() {
    lateinit var binding: FragmentLavelBinding
    lateinit var sharedPreference: SharedPreferences
    lateinit var L_1_HS:String
    lateinit var L_2_HS:String
    lateinit var L_3_HS:String
    lateinit var L_4_HS:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_lavel, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lavel, container, false)

        sharedPreference = activity!!.getSharedPreferences("sp", Context.MODE_PRIVATE)
        L_1_HS = sharedPreference.getInt("L_1_HS", 0).toString()
        L_1_HS = "Height Score: "+L_1_HS
        L_2_HS = sharedPreference.getInt("L_2_HS", 0).toString()
        L_2_HS = "Height Score: "+L_2_HS
        L_3_HS = sharedPreference.getInt("L_3_HS", 0).toString()
        L_3_HS = "Height Score: "+L_3_HS
        L_4_HS = sharedPreference.getInt("L_4_HS", 0).toString()
        L_4_HS = "Heig ht Score: "+L_4_HS

        binding.level = this
        return binding.root
    }

    private fun goGameFragment(level:String){
//        val action = QuizFragmentDirections.actionQuizFragment3ToQuizWonFragment(score,wrongAnswerList.toTypedArray())
//        view!!.findNavController().navigate(action)
        val action = LavelFragmentDirections.actionLavelFragmentToGamePlayFragment(level)
        view!!.findNavController().navigate(action)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val sharedPreference = this.activity!!.getSharedPreferences("sp", Context.MODE_PRIVATE)
        binding.level1.setOnClickListener{
            if(sharedPreference.getBoolean("LEVEL_1", true) == true){
                goGameFragment("1")
            } else {
                Toast.makeText(activity, "Level is locked :(", Toast.LENGTH_LONG).show()
            }
        }

        binding.level2.setOnClickListener{
            if(sharedPreference.getBoolean("LEVEL_2", false) != true){
//                Toast.makeText(activity, "Level is locked :(", Toast.LENGTH_LONG).show()
                createDialogForLevelLocked()
            } else {
                goGameFragment("2")
            }
        }

        binding.level3.setOnClickListener{
            if(sharedPreference.getBoolean("LEVEL_3", false) != true){
//                Toast.makeText(activity, "Level is locked :(", Toast.LENGTH_LONG).show()
                createDialogForLevelLocked()
            } else {
                goGameFragment("3")
            }
        }

        binding.level4.setOnClickListener{
            if(sharedPreference.getBoolean("LEVEL_4", false) != true){
//                Toast.makeText(activity, "Level is locked :(", Toast.LENGTH_LONG).show()
                createDialogForLevelLocked()
            } else {
                goGameFragment("4")
            }
        }

    }

    private fun createDialogForLevelLocked(){
        val mDialogView = LayoutInflater.from(activity).inflate(R.layout.lockeddialog, null)
        val mBuilder = AlertDialog.Builder(activity)
            .setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        mDialogView.btnOk.setOnClickListener{
            mAlertDialog.dismiss()
        }
    }
}

