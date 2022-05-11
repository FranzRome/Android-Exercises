package com.example.firebase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebase.model.Product
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainViewModel : ViewModel(){

    private val db = Firebase.firestore

    val products: MutableLiveData<ArrayList<Product>> by lazy {
        MutableLiveData<ArrayList<Product>>().also {
            loadProducts()
        }
    }

    fun addProduct(name: String, description: String){
        val product = hashMapOf(
            "name" to name,
            "description" to description
        )

        db.collection("products")
            .add(product)
            .addOnSuccessListener { documentReference ->
                Log.d("Firebase", "DocumentSnapshot added with ID: ${documentReference.id}")
                loadProducts()
            }
            .addOnFailureListener { e ->
                Log.w("Firebase", "Error adding document", e)
            }
    }

    fun loadProducts(){
        val productsArray = ArrayList<Product>()

        db.collection("products")
            .get()
            .addOnSuccessListener {
                for(document in it) {
                    productsArray.add(
                        Product(document.data.getValue("name").toString(),
                        document.data.getValue("description").toString())
                    )
                }

                //productsArray.reverse()

                /*productsList.apply {
                    adapter = ProductAdapter(products, this@MainActivity)
                    layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                }*/

                this.products.value = productsArray
            }
            .addOnFailureListener { exception ->
                Log.w("Firebase", "Error getting documents.", exception)
            }


    }
}