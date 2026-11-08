package com.example.aplikasikopidannyemil.model

data class MenuItem(
    val id: Int,
    val name: String,
    val price: String,
    val description: String,
    val imageUrl: String = "https://via.placeholder.com/150"
)

val dummyMenu = listOf(
    MenuItem(1, "Kopi Susu Gula Aren", "Rp 20.000", "Espresso dengan susu segar dan gula aren murni."),
    MenuItem(2, "Americano Dingin", "Rp 15.000", "Espresso shot ganda dengan air es."),
    MenuItem(3, "Matcha Latte", "Rp 25.000", "Bubuk matcha premium Jepang dengan susu."),
    MenuItem(4, "Roti Bakar Coklat Keju", "Rp 18.000", "Roti bakar tebal dengan limpahan coklat dan keju."),
    MenuItem(5, "Pisang Goreng Crispy", "Rp 15.000", "Pisang kepok goreng renyah dengan taburan gula halus."),
    MenuItem(6, "Kentang Goreng", "Rp 12.000", "Kentang goreng gurih dengan saus sambal.")
)
