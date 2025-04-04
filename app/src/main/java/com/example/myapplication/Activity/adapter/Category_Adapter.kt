package com.example.myapplication.Activity.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.Activity.model.CategoriesModel
import com.example.myapplication.databinding.ActivityCategorieViewBinding

import android.content.Context

class Category_Adapter(
    private val items:MutableList<CategoriesModel>
): RecyclerView.Adapter<Category_Adapter.ViewHolderCategory>() {
    @SuppressLint("RestrictedApi")
    private lateinit var context:Context

    inner class ViewHolderCategory(val binding: ActivityCategorieViewBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCategory {
        context = parent.context

        val binding=ActivityCategorieViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderCategory(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolderCategory, position: Int) {
        val item=items[position]
        holder.binding.titleCategory.text=item.Name
//        print(item.name)
        Glide.with(context)
            .load(item.Picture)
            .into(holder.binding.imageView4)


    }
}