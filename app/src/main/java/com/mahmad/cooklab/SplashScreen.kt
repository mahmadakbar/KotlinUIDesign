package com.mahmad.cooklab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // lootie anim
        val lootieAnim: LottieAnimationView = findViewById(R.id.animationView)
        lootieAnim.cancelAnimation()
        lootieAnim.setMinFrame(0)
        lootieAnim.setMaxFrame(47)

        // text anim
        val texttt: TextView = findViewById(R.id.cooklabanim)
        val txtAnim: Animation = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
        texttt.startAnimation(txtAnim)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 2000 is the delayed time in milliseconds.
    }
}