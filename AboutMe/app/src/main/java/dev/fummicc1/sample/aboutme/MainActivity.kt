package dev.fummicc1.sample.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import dev.fummicc1.sample.aboutme.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
        binding.nicknameText.setOnClickListener {
            updateNickName(it)
        }
        binding.myName = myName
    }

    private fun addNickName(view: View) {
        myName.nickName = binding.nicknameEdit.text.toString()
        view.visibility = View.GONE
        binding.nicknameEdit.visibility = View.GONE
        binding.nicknameText.visibility = View.VISIBLE

        // Hide the keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

        binding.invalidateAll()
    }

    private  fun updateNickName(view: View) {
        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Set the focus to the edit text.
        binding.nicknameEdit.requestFocus()

        // Show the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)
    }
}