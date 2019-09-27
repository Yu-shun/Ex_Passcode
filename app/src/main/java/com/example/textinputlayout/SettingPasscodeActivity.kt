package com.example.textinputlayout

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingPasscodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_passcode)

        val saveButton = findViewById<Button>(R.id.saveButton)
        val passcodeEditText = findViewById<EditText>(R.id.passcodeEditText)
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val sharedPreferences = getSharedPreferences("userData",Context.MODE_PRIVATE)

        saveButton.setOnClickListener(View.OnClickListener {
            val passcode = passcodeEditText.text.toString()
            val username = usernameEditText.text.toString()
            if(passcodeEditText.text.toString().length >= 4 && passcodeEditText.text.toString().length <= 10
                && usernameEditText.text.toString().length >= 4 && usernameEditText.text.toString().length <= 10){
                val editor = sharedPreferences.edit()
                editor.putString("passcode", passcode)
                editor.putString("username", username)
                editor.apply()

                val toast = Toast.makeText(this, "パスワードを設定しました", Toast.LENGTH_SHORT)
                toast.show()

                finish()
            }
        })
    }
}
