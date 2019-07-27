package com.example.picpaytest.data.model

import java.io.Serializable

data class User(
    val id: Long,
    val name: String,
    val img: String,
    val username: String) : Serializable