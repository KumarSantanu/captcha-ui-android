package com.demo.captchaui

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.appixon.captchaui.CaptchaLayout
import com.appixon.captchaui.CaptchaUI

class MainActivity : AppCompatActivity(), CaptchaLayout.OnButtonClickedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showCaptchaButton = findViewById<TextView>(R.id.acb_show_captcha)

        showCaptchaButton.setOnClickListener {
            CaptchaUI.Builder(this)
                .setCaptchaTextColor(ContextCompat.getColor(applicationContext, R.color.greenDark))
                .setCaptchaLineColor(ContextCompat.getColor(applicationContext, R.color.greenDark))
                .setCaptchaCodeLength(6)
                .setCaptchaPositiveText("Verify")
                .setCaptchaPositiveTextColor(Color.WHITE)
                .setCaptchaNegativeText("Close")
                .setCaptchaButtonListener(this)
                .build()
        }
    }

    override fun onNegativeButtonClicked() {
        Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show()

    }

    override fun onVerificationCodeVerified() {
        Toast.makeText(this, "Everything is awesome", Toast.LENGTH_SHORT).show()
    }
}