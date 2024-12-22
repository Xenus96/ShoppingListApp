package dev.my.shoppinglist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EditingActivity : AppCompatActivity() {

    private val viewModel: ShoppingListViewModel by viewModels {
        ShoppingListViewModelFactory(application)
    }
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editing)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        adapter = ProductAdapter(mutableListOf())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val saveButton: Button = findViewById(R.id.btn_save)
        saveButton.setOnClickListener {
            val title = findViewById<EditText>(R.id.edit_title).text.toString().trim()
            if (title.isEmpty()) {
                findViewById<EditText>(R.id.edit_title).error = "Title cannot be empty"
                return@setOnClickListener
            }

            val products = adapter.getProducts()
            val shoppingList = ShoppingList(title = title)
            viewModel.saveShoppingList(shoppingList, products)

            finish() // Return to the previous screen
        }

    }
}
