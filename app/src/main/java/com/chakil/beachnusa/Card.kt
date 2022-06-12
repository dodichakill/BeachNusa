package com.chakil.beachnusa
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Card (
 var photo: Int,
 var name: String,
 var desc: String
) : Parcelable