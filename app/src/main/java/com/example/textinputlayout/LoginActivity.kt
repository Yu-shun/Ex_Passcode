package com.example.textinputlayout

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setTitle("Hello")

        val username = intent.getStringExtra("UserName")

        val userText = findViewById<TextView>(R.id.user_View)

        userText.setText("こんにちは\n"+username+"さん")
    }
}
