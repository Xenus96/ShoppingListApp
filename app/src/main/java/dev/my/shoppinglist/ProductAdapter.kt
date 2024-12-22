package dev.my.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val products: MutableList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: EditText = itemView.findViewById(R.id.edit_title)
        val productCategory: EditText = itemView.findViewById(R.id.prod)
        val isBought: CheckBox = itemView.findViewById(R.id.checkbox_bought)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.productName.setText(product.name)
        holder.productCategory.setText(product.category)
        holder.isBought.isChecked = product.isBought

        holder.isBought.setOnCheckedChangeListener { _, isChecked ->
            products[position] = product.copy(isBought = isChecked)
        }
    }

    fun updateProducts(newProducts: List<Product>) {
        products.clear()
        products.addAll(newProducts)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = products.size

    fun getProducts(): List<Product> = products
}


