package com.example.myapplication.Activity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.Activity.model.DoctoresModel
import com.example.myapplication.databinding.ActivityDocotresViewBinding

class Docotore_Adapter(
    private val items:MutableList<DoctoresModel>
):RecyclerView.Adapter<Docotore_Adapter.ViewHolderDocotore>(){

    private lateinit var context: Context

    class ViewHolderDocotore(val binding: ActivityDocotresViewBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDocotore {
        context =parent.context
        val binding=ActivityDocotresViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderDocotore(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolderDocotore, position: Int) {
        val item=items[position]

        holder.binding.doctoreName.text=item.Name
        holder.binding.specDoctore.text=item.Special
        holder.binding.rating.text=item.Rating.toString()
        holder.binding.exceper.text = "${item.Expriense} Years"


        Glide.with(context)
            .load(item.Picture)
            .into(holder.binding.imgDoctore)

    }
}