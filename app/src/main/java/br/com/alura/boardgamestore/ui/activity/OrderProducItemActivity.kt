package br.com.alura.boardgamestore.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.boardgamestore.dao.OrderProductDao
import br.com.alura.boardgamestore.databinding.OrderItemBinding
import br.com.alura.boardgamestore.ui.recyclerview.adapter.OrderProductItemAdapter

class OrderItemActivity : AppCompatActivity() {
    private val dao = OrderProductDao()
    private val adapter = OrderProductItemAdapter(context = this, orderItems = dao.searchAll())
    private val binding by lazy {
        OrderItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.updateList(dao.searchAll())
    }



    private fun setRecyclerView() {
        val recyclerView = binding.productsListRecyclerview
        recyclerView.adapter = adapter
    }
}