package com.example.myapplication.Activity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Activity.model.CategoriesModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.math.log

class MainactivityViewmodel:ViewModel(){
    private val firebaseDatabase= FirebaseDatabase.getInstance()


    //get taples of Categories
    private val _Categorie=MutableLiveData<MutableList<CategoriesModel>>()
    val Categorie:LiveData<MutableList<CategoriesModel>> = _Categorie

    fun loadCategorie(){
        val ref=firebaseDatabase.getReference("Category")
        
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val categoryList= mutableListOf<CategoriesModel>()

                for(child in snapshot.children){
                    val category=child.getValue(CategoriesModel::class.java)
                    if (category != null) {
                        categoryList.add(category)
                    }
                }

                _Categorie.value=categoryList
            }

            override fun onCancelled(error: DatabaseError) {
                _Categorie.value= mutableListOf()
            }

        })
    }

}