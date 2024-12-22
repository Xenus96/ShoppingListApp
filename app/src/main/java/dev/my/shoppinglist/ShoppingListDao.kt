package dev.my.shoppinglist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShoppingListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingList(list: ShoppingList): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<Product>)

    @Query("SELECT * FROM ShoppingList")
    suspend fun getShoppingLists(): List<ShoppingList>

    @Query("SELECT * FROM Product WHERE shoppingListId = :listId")
    suspend fun getProductsForList(listId: Int): List<Product>
}
