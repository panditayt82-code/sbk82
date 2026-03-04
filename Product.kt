package com.sublikami.inventario

data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val initialQuantity: Int,
    val soldQuantity: Int,
    val imageUrl: String
) {
    val stock: Int get() = initialQuantity - soldQuantity
}
