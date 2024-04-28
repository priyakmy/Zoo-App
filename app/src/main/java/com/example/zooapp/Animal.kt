package com.example.zooapp

import java.io.Serializable


data class Animal(
    var name: String? = null,
    var des: String? = null,
    var image: Int? = null
):Serializable
