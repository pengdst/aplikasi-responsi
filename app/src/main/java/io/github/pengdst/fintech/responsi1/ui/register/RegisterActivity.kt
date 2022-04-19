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

                tilEmail.error = if (!email.isNullOrEmpty()) "Email cannot empty".also {
                    return@setOnClickListener
                } else null
                tilPassword.error = if (!password.isNullOrEmpty()) "Password cannot empty".also {
                    return@setOnClickListener
                } else null
                tilConfirmPassword.error = if (password != confirmPassword ) "Password and confirmation Password didn't match".also {
                    return@setOnClickListener
                } else null

                Intent(applicationContext, MainActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}