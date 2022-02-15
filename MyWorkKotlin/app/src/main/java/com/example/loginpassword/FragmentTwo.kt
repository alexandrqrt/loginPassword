package com.example.loginpassword

import android.opengl.Visibility
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*

class FragmentTwo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tv: TextView = view.findViewById(R.id.tvFragmentTwo)
        val text = arguments?.getString("MyArg")
        tv.text = text
        val progressBar: ProgressBar = view.findViewById(R.id.pb)
        val nextButtonPassword: Button = view.findViewById(R.id.nextButtonPassword)
        val editPasswor: EditText = view.findViewById(R.id.editPassword)
        val checkBox: CheckBox = view.findViewById(R.id.checkBox2)
fun checkThePas ():Boolean{
    editPasswor.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            nextButtonPassword.isEnabled = s?.let { it.isNotEmpty() } ?: false
        }

        override fun afterTextChanged(s: Editable?) {

        }
    })
    return nextButtonPassword.isEnabled
}
    checkBox.setOnCheckedChangeListener { buttonView,isChecked ->

        if (checkThePas()) {nextButtonPassword.isEnabled = true}
        else {nextButtonPassword.isEnabled = false}

        }
        nextButtonPassword.setOnClickListener {
            progressBar.visibility = VISIBLE
            nextButtonPassword.isEnabled = false
            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = INVISIBLE
                nextButtonPassword.isEnabled = true
                Toast.makeText(context, R.string.godbye, Toast.LENGTH_SHORT).show()
            }, 2000)
        }


    }
}
