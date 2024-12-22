package dev.my.shoppinglist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShoppingList(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String
)