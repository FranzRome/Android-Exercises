package com.example.firebase.model

class Product(var name: String, var description: String) {

    fun getNameString(): String{
        return this.name
    }

    fun getDescriptionString(): String{
        return this.description
    }
}