package com.android.myprovinsi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Provinsi(
    val name: String,
    val description: String,
    val photo: Int
):Parcelable
