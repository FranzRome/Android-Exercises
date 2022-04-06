package it.lafeltrinelli.listadapter.model

class Product(var name: String, var price: Float) {

    fun getPriceString(): String{
        return "Prezzo: $price€"
    }
}

/*class Product{

    var name: String? = null
    var price: Float? = null

    fun getPriceString(): String{
        return ""
    }
}*/