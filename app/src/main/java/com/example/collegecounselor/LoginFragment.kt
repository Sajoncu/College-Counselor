package com.example.collegecounselor


import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.collegecounselor.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        val sharedPreference = activity!!.getSharedPreferences("sp", Context.MODE_PRIVATE)
//        var editor = sharedPreference?.edit()
//        editor?.putBoolean("LEVEL_1", true)
//        editor?.putBoolean("LEVEL_2", false)
//        editor?.putBoolean("LEVEL_3", false)
//        editor?.putBoolean("LEVEL_4", false)
//        editor?.putString("CURRENT_LEVEL", "1")

        //val sharedPreference = this.activity!!.getSharedPreferences("sp", Context.MODE_PRIVATE)

        binding.playGame.setOnClickListener{
            Toast.makeText(activity, "Clicked", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_lavelFragment)
            //it.findNavController().navigate(R.id.action_loginFragment_to_lavelFragment)
        }

        return binding.root
        // return inflater.inflate(R.layout.fragment_login, container, false)
    }


}
