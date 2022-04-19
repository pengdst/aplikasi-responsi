package io.github.pengdst.fintech.responsi1.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.pengdst.fintech.responsi1.R
import io.github.pengdst.fintech.responsi1.databinding.ActivityRecoveryBinding
import io.github.pengdst.fintech.responsi1.databinding.ActivityRegisterBinding
import io.github.pengdst.fintech.responsi1.ui.main.MainActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnRegister.setOnClickListener {
                val email = tilEmail.editText?.text?.toString()
                val password = tilPassword.editText?.text?.toString()
                val confirmPassword = tilConfirmPassword.editText?.text?.toString()

                tilEmail.error = if (email.isNullOrEmpty()) "Email cannot empty" else null
                tilPassword.error = if (password.isNullOrEmpty()) "Password cannot empty" else null
                tilConfirmPassword.error = if ((password != confirmPassword) || confirmPassword.isNullOrEmpty()) "Password and confirmation Password didn't match" else null
                if (email.isNullOrEmpty() || password.isNullOrEmpty() || password != confirmPassword) return@setOnClickListener

                Intent(applicationContext, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                }.also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}