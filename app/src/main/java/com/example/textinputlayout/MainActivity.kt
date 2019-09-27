package com.example.textinputlayout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val setButton = findViewById<Button>(R.id.setting)
        val loginButton = findViewById<Button>(R.id.login)
        val usernameEditText = findViewById<TextInputEditText>(R.id.usernameEdit)
        val passEditText = findViewById<TextInputEditText>(R.id.passEdit)
        val passView = findViewById<TextView>(R.id.passView)

        passView.text = "パスワードを入力してください"

        loginButton.setOnClickListener{
            val sharedPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE)
            val passcode = sharedPreferences.getString("passcode", "")
            val username = sharedPreferences.getString("username", "")
            if (passcode.toString() == passEditText.text.toString() && username.toString() == usernameEditText.text.toString()) {
                val toast =Toast.makeText(this, "ログイン成功",Toast.LENGTH_SHORT)
                toast.show()
            }
        }

        setButton.setOnClickListener{
            val intent = Intent(this, SettingPasscodeActivity::class.java)
            startActivity(intent)
        }
    }
}
