package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.model.Product
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore

class MainActivity : AppCompatActivity() {

    private val db = Firebase.firestore
    private lateinit var updateButton : Button
    private lateinit var first: TextView
    private lateinit var last: TextView
    private lateinit var productNameEditText: EditText
    private lateinit var productDescriptionEditText: EditText
    private lateinit var addProductButton: Button
    private lateinit var productsList: RecyclerView

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateButton = findViewById(R.id.updateButton)
        first = findViewById(R.id.first)
        last = findViewById(R.id.last)
        productNameEditText = findViewById(R.id.productNameEditText)
        productDescriptionEditText = findViewById(R.id.productDescriptionEditText)
        addProductButton = findViewById(R.id.addProductButton)
        productsList = findViewById(R.id.productsList)

        // Create the observer which updates the UI.
        val nameObserver = Observer<ArrayList<Product>> { newList: ArrayList<Product> ->
            // Update the UI, in this case, a TextView.
            productsList.apply {
                adapter = ProductAdapter(newList, this@MainActivity)
                layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            }
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.products.observe(this, nameObserver)

        updateButton.setOnClickListener {
            db.collection("users").whereEqualTo("first", "Ada")
                .get()
                .addOnSuccessListener {
                    for(document in it) {
                        first.text = document.data["first"].toString()
                        last.text = document.data["last"].toString()
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("Firebase", "Error getting documents.", exception)
                }
        }

        addProductButton.setOnClickListener{
            addProduct()
        }

        loadProducts()
    }

    private fun addProduct(){
        // Commented code does the same things without viewModel
        /*val product = hashMapOf(
            "name" to productNameEditText.text.toString(),
            "description" to productDescriptionEditText.text.toString()
        )

        db.collection("products")
            .add(product)
            .addOnSuccessListener { documentReference ->
                Log.d("Firebase", "DocumentSnapshot added with ID: ${documentReference.id}")
                loadProducts()
            }
            .addOnFailureListener { e ->
                Log.w("Firebase", "Error adding document", e)
            }*/

        viewModel.addProduct(productNameEditText.text.toString(), productDescriptionEditText.text.toString())
    }

    private fun loadProducts(){
        // Commented code does the same things without viewModel
        /*var products = ArrayList<Product>()

        db.collection("products")
            .get()
            .addOnSuccessListener {
                for(document in it) {
                    products.add(Product(document.data.getValue("name").toString(),
                                         document.data.getValue("description").toString()))
                }

                products.reverse()

                productsList.apply {
                    adapter = ProductAdapter(products, this@MainActivity)
                    layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                }
            }
            .addOnFailureListener { exception ->
                Log.w("Firebase", "Error getting documents.", exception)
            }*/

            viewModel.loadProducts()
    }

}