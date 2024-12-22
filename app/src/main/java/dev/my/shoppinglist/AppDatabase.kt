package dev.my.shoppinglist

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ShoppingList::class, Product::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun shoppingListDao(): ShoppingListDao
}

