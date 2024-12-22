package dev.my.shoppinglist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val category: String? = null,
    val isBought: Boolean = false,
    val shoppingListId: Int
)
