package com.anangkur.activityplayground

import java.io.Serializable

data class SerializableClass(
    val name: String,
    val age: Int,
    val gender: String,
) : Serializable