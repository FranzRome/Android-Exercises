package com.example.list

//import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.list.model.Product
// import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val products = ArrayList<Product>()

        products.add(Product("banana", 0.24f))
        products.add(Product("apple", 0.32f))
        products.add(Product("orange", 0.22f))
        products.add(Product("pear", 0.32f))
        products.add(Product("grape", 0.32f))
        products.add(Product("strawberry", 0.32f))
        products.add(Product("pineapple", 0.32f))
        products.add(Product("watermelon", 0.32f))

        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ProductAdapter(products, this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val productAdapter = ProductAdapter(products, this)
        recyclerView.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
        productAdapter.setOnCallback(object : ProductAdapter.AdapterCallback{
            override fun selectItem(position: Int) {
                TODO("Not yet implemented")
            }

            override fun deleteItem(position: Int) {
                Log.d("LogAdapter", "Product: $position")
                products.removeAt(position)
                productAdapter.notifyItemRemoved(position)
            }
        })
    }
}