package com.example.myapplication.Activity.activity

import android.content.Intent
import android.os.Bundle
import com.example.myapplication.Activity.viewmodel.MainactivityViewmodel
import com.example.myapplication.databinding.ActivityIntromainBinding

class IntromainActivity : RemoveFlag() {
    private lateinit var binding: ActivityIntromainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityIntromainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.apply {
            buttonStart.setOnClickListener(){
                startActivity(Intent(this@IntromainActivity, MainActivity::class.java))
            }
        }

    }
}