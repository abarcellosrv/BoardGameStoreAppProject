package br.com.alura.boardgamestore.ui.recyclerview.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.boardgamestore.R
import br.com.alura.boardgamestore.extensions.tryImageLoad
import br.com.alura.boardgamestore.model.Product
import br.com.alura.boardgamestore.databinding.ProductItemBinding
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class ProductsListAdapter(
    private val context: Context,
    products: List<Product>
) : RecyclerView.Adapter<ProductsListAdapter.ViewHolder>() {

    private val products = products.toMutableList()

    class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun attach(product: Product) {
            val name = binding.productItemName
            name.text = product.name
            val description = binding.productItemDescription
            description.text = product.description
            val price = binding.productItemPrice
            val formattedPrice: String =
                brCurrencyFormat(product.price)
            price.text = formattedPrice
            val numberOfPlayers = binding.numberOfPlayers
            numberOfPlayers.text = product.numberofPlayers.toString()

            if(product.image == null){
                binding.imageView.setImageResource(R.drawable.dicelogo)
            } else {
                binding.imageView.tryImageLoad(product.image)
            }

        }

        private fun brCurrencyFormat(valor: BigDecimal): String {
            val formatter: NumberFormat = NumberFormat
                .getCurrencyInstance(Locale("pt", "br"))
            return formatter.format(valor)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProductItemBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = products[position]
        holder.attach(produto)
    }

    override fun getItemCount(): Int = products.size

    fun updateList(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

}
