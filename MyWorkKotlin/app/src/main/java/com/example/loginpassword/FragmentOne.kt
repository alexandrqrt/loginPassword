package com.example.loginpassword

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import org.w3c.dom.Text

class FragmentOne : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonAnr:Button = view.findViewById(R.id.buttonanr)
        val nextButton: Button = view.findViewById(R.id.nextButton)
        val editText: EditText = view.findViewById(R.id.editText)
        val bundle = Bundle()
        if (editText.text.isNotEmpty()) nextButton.isEnabled = true
        nextButton.setOnClickListener {
            val name = editText.text
            val hello = "Уважаемый, $name, введите ваш пароль"
            bundle.putString("MyArg", hello)
            findNavController().navigate(R.id.action_fragmentOne_to_fragmentTwo, bundle)
        }
        buttonAnr.setOnClickListener {
            Thread.sleep(10000)
        }
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                nextButton.isEnabled = s?.let { it.isNotEmpty() } ?: false
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }
}