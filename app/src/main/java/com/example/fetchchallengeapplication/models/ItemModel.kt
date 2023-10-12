package com.example.fetchchallengeapplication.models

import android.os.Parcel
import android.os.Parcelable

// This is the ItemModel or the data model which holds the parameters included in the response body.
// It consists of id, listId and name.
// There is also standard boiler plate code for Parcelable, which would help aid the transfer of data of
// type ItemModel between different pages via Intent.
data class ItemModel(
    val id: Int,
    val listId: Int,
    val name: String
) : Parcelable {

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(listId)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        @JvmField
        val CREATOR = object: Parcelable.Creator<ItemModel> {
            override fun createFromParcel(parcel: Parcel): ItemModel {
                val id = parcel.readInt()
                val listId = parcel.readInt()
                val name = parcel.readString()

                return ItemModel(id, listId, name!!)
            }

            override fun newArray(size: Int): Array<ItemModel> {
                TODO("Not yet implemented")
            }
        }
    }
}