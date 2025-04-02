package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityIntromainBinding

class IntromainActivity : RemoveFlag() {
    private lateinit var binding: ActivityIntromainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityIntromainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.apply {
            buttonStart.setOnClickListener(){
                startActivity(Intent(this@IntromainActivity,MainActivity::class.java))
            }
        }

    }
}