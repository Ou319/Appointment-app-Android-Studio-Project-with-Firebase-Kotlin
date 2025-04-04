package com.example.myapplication.Activity.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Activity.adapter.Category_Adapter
import com.example.myapplication.Activity.viewmodel.MainactivityViewmodel
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: MainactivityViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initCategory()
    }

    private fun initCategory() {
        binding.progressBar1.visibility= View.VISIBLE

        viewModel.Categorie.observe(this, Observer {
            binding.recyclerView.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            binding.recyclerView.adapter=Category_Adapter(it)
            binding.progressBar1.visibility= View.GONE
        })

        viewModel.loadCategorie()
    }
}