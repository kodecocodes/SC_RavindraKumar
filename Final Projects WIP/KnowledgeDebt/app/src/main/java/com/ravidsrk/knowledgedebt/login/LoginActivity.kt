package com.ravidsrk.knowledgedebt.login

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ravidsrk.knowledgedebt.R
import com.ravidsrk.knowledgedebt.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginHandler {

    private lateinit var binding: ActivityLoginBinding
    private val model = LoginModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.model = model
        binding.handler = this
    }

    override fun onLoginClicked(email: String, password: String) {
        Toast.makeText(this, "Email: $email\nPassword: $password", Toast.LENGTH_SHORT).show()
    }
}
