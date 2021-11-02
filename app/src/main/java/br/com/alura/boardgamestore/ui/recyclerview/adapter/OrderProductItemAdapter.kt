package br.com.alura.boardgamestore.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.boardgamestore.databinding.OrderItemProductBinding
import br.com.alura.boardgamestore.model.OrderItems
import br.com.alura.boardgamestore.model.Product
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class OrderProductItemAdapter(
    private val context: Context,
    orderItems: List<OrderItems>
) : RecyclerView.Adapter<OrderProductItemAdapter.ViewHolder>() {

    private val orderItems = orderItems.toMutableList()

    class ViewHolder(private val binding: OrderItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun attach(orderItems: OrderItems){
            val name = binding.orderProductName
            name.text = orderItems.name
            val price = binding.unitPrice
            val formattedPrice: String = brCurrencyFormat(orderItems.price)
            price.text = formattedPrice
        }
        private fun brCurrencyFormat(valor: BigDecimal): String {
            val formatter: NumberFormat = NumberFormat
                .getCurrencyInstance(Locale("pt", "br"))
            return formatter.format(valor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = OrderItemProductBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val orderItemProduct = orderItems[position]
        holder.attach(orderItemProduct)
    }

    override fun getItemCount(): Int = orderItems.size

    fun updateList(orderItems: List<OrderItems>){
        this.orderItems.clear()
        this.orderItems.addAll(orderItems)
        notifyDataSetChanged()
    }
}