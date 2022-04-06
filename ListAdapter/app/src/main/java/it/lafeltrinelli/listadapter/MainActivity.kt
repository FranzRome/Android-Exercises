package it.lafeltrinelli.listadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.lafeltrinelli.listadapter.model.Product

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val arrayKotlin = arrayOf("Primo", "Secondo", "Terzo")
        /*val products = ArrayList<String>()
        products.add("Primo")
        products.add("Secondo")
        products.removeAt(0)*/

        //Definisco un array di Prodotti
        val products = ArrayList<Product>()

        //Popolo il mio array
        /*val product1 = Product("Prodotto 1", 10f)
        val product2 = Product("Prodotto 2", 5f)
        val product3 = Product("Prodotto 3", 20f)
        products.add(product1)
        products.add(product2)
        products.add(product3)*/
        for(n in 1..20){
            val product = Product("Prodotto $n", (n * 2).toFloat())
            products.add(product)
        }

        //Popolo  la recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //recyclerView.adapter = ProductAdapter(products, this)
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val productAdapter = ProductAdapter(products, this@MainActivity)
        recyclerView.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
        productAdapter.setOnCallback(object : ProductAdapter.AdapterCallback{
            override fun selectItem(position: Int) {
                Log.d("LogAdapter", "Product: $position")
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                startActivity(intent)
            }
        })

    }
}