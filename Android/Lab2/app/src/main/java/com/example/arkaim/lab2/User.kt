package com.example.arkaim.lab2

import android.os.Parcel
import android.os.Parcelable

data class User (var name: String, var info: String) : Parcelable {
    constructor(parsel: Parcel) : this (parsel.readString(), parsel.readString()){}


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(info)
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int {
        return 0
    }
}

