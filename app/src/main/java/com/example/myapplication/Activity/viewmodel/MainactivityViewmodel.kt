package com.example.myapplication.Activity.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Activity.model.CategoriesModel
import com.example.myapplication.Activity.model.DoctoresModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainactivityViewmodel:ViewModel(){
    private val firebaseDatabase= FirebaseDatabase.getInstance()


    //get taples of Categories
    private val _Categorie=MutableLiveData<MutableList<CategoriesModel>>()
    val Categorie:LiveData<MutableList<CategoriesModel>> = _Categorie

    //get taple of Categories
    private val _Doctore=MutableLiveData<MutableList<DoctoresModel>>()
    val Doctore:LiveData<MutableList<DoctoresModel>> = _Doctore

    //this is for Doctore
    fun loadDocotore(){
        val ref=firebaseDatabase.getReference("Doctors")

        ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val doctoteList = mutableListOf<DoctoresModel>()

                for (child in snapshot.children){
                    val doctore=child.getValue(DoctoresModel::class.java)
                    if (doctore != null) {
                        doctoteList.add(doctore)
                    }
                }
                _Doctore.value=doctoteList
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("FirebaseError", "Error loading categories: ${error.message}")
                _Doctore.value = mutableListOf()
            }

        })
    }

    //this for Categories
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
                Log.e("FirebaseError", "Error loading categories: ${error.message}")
                _Categorie.value= mutableListOf()
            }

        })
    }

}