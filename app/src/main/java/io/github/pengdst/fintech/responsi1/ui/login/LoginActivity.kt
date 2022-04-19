package io.github.pengdst.fintech.responsi1.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.pengdst.fintech.responsi1.databinding.ActivityLoginBinding
import io.github.pengdst.fintech.responsi1.ui.main.MainActivity
import io.github.pengdst.fintech.responsi1.ui.recovery.RecoveryActivity
import io.github.pengdst.fintech.responsi1.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnLogin.setOnClickListener {
                val email = tilEmail.editText?.text?.toString()
                val password = tilPassword.editText?.text?.toString()

                tilEmail.error = if (email.isNullOrEmpty()) "Email cannot empty" else null
                tilPassword.error = if (password.isNullOrEmpty()) "Password cannot empty" else null
                if (email.isNullOrEmpty() || password.isNullOrEmpty()) return@setOnClickListener

                Intent(applicationContext, MainActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }

            tvForgotPassword.setOnClickListener {
                Intent(applicationContext, RecoveryActivity::class.java).also {
                    startActivity(it)
                }
            }

            tvRegisterAccount.setOnClickListener {
                Intent(applicationContext, RegisterActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}