package dev.my.shoppinglist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ShoppingListViewModel(application: Application) : AndroidViewModel(application) {

    private val db: AppDatabase = Room.databaseBuilder(
        application.applicationContext,
        AppDatabase::class.java, "shopping-list-db"
    ).build()

    private val shoppingListDao = db.shoppingListDao()

    // LiveData for shopping lists
    private val _shoppingLists = MutableLiveData<List<ShoppingList>>()
    val shoppingLists: LiveData<List<ShoppingList>> get() = _shoppingLists

    fun loadShoppingLists() {
        viewModelScope.launch {
            _shoppingLists.postValue(shoppingListDao.getShoppingLists())
        }
    }

    fun saveShoppingList(list: ShoppingList, products: List<Product>) {
        viewModelScope.launch {
            val listId = shoppingListDao.insertShoppingList(list)
            val updatedProducts = products.map { it.copy(shoppingListId = listId.toInt()) }
            shoppingListDao.insertProducts(updatedProducts)
            loadShoppingLists() // Refresh the list after saving
        }
    }
}
