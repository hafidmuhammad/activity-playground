package com.anangkur.activityplayground

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ParcelableClass(
    val name: String,
    val age: Int,
    val gender: String,
) : Parcelable