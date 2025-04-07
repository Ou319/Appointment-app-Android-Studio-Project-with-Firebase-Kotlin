package com.example.myapplication.Activity.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.myapplication.Activity.model.DoctoresModel
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDatailBinding

class Datail_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityDatailBinding
    private lateinit var item:DoctoresModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDatailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getBundel()
    }

    private fun getBundel() {
        item=intent.getParcelableExtra("object")!!
        binding.apply {

            tvDoctorName.text=item.Name
            tvSpecialization.text=item.Special
            tvLocation.text=item.Location
            tvPatientsCount.text=item.Patiens
            tvExperienceYears.text=item.Expriense.toString()
            tvRatingValue.text=item.Rating.toString()
            tvBiographyContent.text=item.Biography
        }
        Glide.with(this@Datail_Activity)
            .load(item.Picture)
            .into(binding.ivProfileImage)

        binding.ivBack.setOnClickListener {
            finish()
        }

    }
}