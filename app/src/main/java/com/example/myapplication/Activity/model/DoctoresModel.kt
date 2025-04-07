package com.example.myapplication.Activity.model

import android.os.Parcel
import android.os.Parcelable

class DoctoresModel(
    val Id:Int=0,
    val Address:String = "",
    val Biography:String = "",
    val Expriense:Int = 0,
    val Location:String = "",
    val Mobile:String = "",
    val Name:String = "",
    val Patiens:String = "",
    val Picture:String = "",
    val Rating:Double = 0.0,
    val Special:String = "",
    val Site:String = "",

):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Id)
        parcel.writeString(Address)
        parcel.writeString(Biography)
        parcel.writeInt(Expriense)
        parcel.writeString(Location)
        parcel.writeString(Mobile)
        parcel.writeString(Name)
        parcel.writeString(Patiens)
        parcel.writeString(Picture)
        parcel.writeDouble(Rating)
        parcel.writeString(Special)
        parcel.writeString(Site)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DoctoresModel> {
        override fun createFromParcel(parcel: Parcel): DoctoresModel {
            return DoctoresModel(parcel)
        }

        override fun newArray(size: Int): Array<DoctoresModel?> {
            return arrayOfNulls(size)
        }
    }

}