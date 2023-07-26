package com.example.kioskproject

data class Menu(
    var id: Int,
    var name: String,
)

data class Item(
    var id: Int,
    var name: String,
    var charge: Int
)