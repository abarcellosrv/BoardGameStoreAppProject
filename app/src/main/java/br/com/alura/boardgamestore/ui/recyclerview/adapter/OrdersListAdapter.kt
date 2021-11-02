package br.com.alura.boardgamestore.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.boardgamestore.databinding.OrderItemBinding
import br.com.alura.boardgamestore.model.Orders
import br.com.alura.boardgamestore.model.Product
import br.com.alura.boardgamestore.ui.recyclerview.adapter.OrdersListAdapter.ViewHolder
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class OrdersListAdapter(
    private val context: Context,
    orders: List<Orders>
) : RecyclerView.Adapter<ViewHolder>() {

    private val orders = orders.toMutableList()

    class ViewHolder(private val binding: OrderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun attach(product: Product) {


        }
        private fun brCurrencyFormat(valor: BigDecimal): String {
            val formatter: NumberFormat = NumberFormat
                .getCurrencyInstance(Locale("pt", "br"))
            return formatter.format(valor)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = OrderItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}