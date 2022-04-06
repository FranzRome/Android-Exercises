package com.example.list.model

class Product (var name: String, var price: Float){

   fun getPriceString(): String{
       return "$price€"
   }
}