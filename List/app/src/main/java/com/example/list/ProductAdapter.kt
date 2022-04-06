package com.example.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
// import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.list.model.Product
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ProductAdapter(private val products:ArrayList<Product>, private val context: Context) :
    RecyclerView.Adapter<ProductAdapter.CustomViewHolder>() {
    class CustomViewHolder(val view: ViewGroup) :
        RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_product, parent, false) as ViewGroup
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val product = products[position]

        val nameText = holder.view.findViewById<TextView>(R.id.nameText)
        nameText.text = product.name

        val priceText = holder.view.findViewById<TextView>(R.id.priceText)
        priceText.text = product.getPriceString()

        holder.view.setOnClickListener {
            /*val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("name", product.name)
            context.startActivity(intent)*/
            mListener?.selectItem(position)
        }

        holder.view.setOnLongClickListener { v ->
            MaterialAlertDialogBuilder(v!!.context)
                .setTitle("Delete")
                .setMessage("Do you want to delete this product?")
                .setPositiveButton("Yes") { _, _ ->
                    mListener?.deleteItem(position)
                }
                .setNegativeButton("No") { _, _ ->
                    // do nothing
                }
                .show()
            true
        }
    }

    fun deleteItem(position: Int) {
        products.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount() = products.size

    /*
     *
     *       Callback
     *
     * */
    interface AdapterCallback {
        fun selectItem(position: Int)
        fun deleteItem(position: Int)
    }
    private var mListener: AdapterCallback? = null

    fun setOnCallback(mItemClickListener: AdapterCallback) {
        this.mListener = mItemClickListener
    }
}