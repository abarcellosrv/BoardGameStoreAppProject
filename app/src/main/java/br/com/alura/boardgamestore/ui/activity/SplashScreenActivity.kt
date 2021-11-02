package br.com.alura.boardgamestore.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.alura.boardgamestore.R

class SplashScreenActivity : AppCompatActivity(R.layout.activity_splash_screen) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val handle = Handler()
        handle.postDelayed({ val intent = Intent(this@SplashScreenActivity, ProductsListActivity::class.java)
            startActivity(intent)
            finish() }, 3000)

    }


}