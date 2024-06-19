package com.example.shoesshop.activity

import android.content.Intent
import android.os.Bundle
import com.example.shoesshop.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {
    private lateinit  var bindings:ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(bindings.root)
        bindings.startBtn.setOnClickListener{
            startActivity(Intent(this@IntroActivity, MainActivity::class.java))
        }

    }
}