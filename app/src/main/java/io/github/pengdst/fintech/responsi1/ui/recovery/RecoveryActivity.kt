package io.github.pengdst.fintech.responsi1.ui.recovery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.pengdst.fintech.responsi1.R
import io.github.pengdst.fintech.responsi1.databinding.ActivityRecoveryBinding
import io.github.pengdst.fintech.responsi1.ui.main.MainActivity

class RecoveryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecoveryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecoveryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnResetPassword.setOnClickListener {
                val email = tilEmail.editText?.text?.toString()

                tilEmail.error = if (email.isNullOrEmpty()) "Email cannot empty" else null
                if (email.isNullOrEmpty()) return@setOnClickListener

                Intent(applicationContext, MainActivity::class.java).also {
                    onBackPressed()
                }
            }
        }
    }
}