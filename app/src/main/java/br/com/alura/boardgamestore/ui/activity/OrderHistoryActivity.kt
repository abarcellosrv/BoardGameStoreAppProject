package br.com.alura.boardgamestore.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.boardgamestore.dao.OrderHistoryDao
import br.com.alura.boardgamestore.databinding.OrdersListBinding
import br.com.alura.boardgamestore.ui.recyclerview.adapter.OrdersListAdapter

class OrderHistoryActivity : AppCompatActivity() {

    private val dao = OrderHistoryDao()
    private val adapter = OrdersListAdapter(this, dao.searchAll())
    private val binding by lazy {
        OrdersListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setRecyclerView()
    }

    override fun onResume() {
        super.onResume()
//        adapter.updateList
    }

    private fun setRecyclerView(){
        val recyclerView = binding.orderHistoryRecyclerview
        recyclerView.adapter = adapter
    }
}